package com.surshree.app.controllers;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.surshree.app.GlobalConstant;
import com.surshree.app.domain.entities.*;
import com.surshree.app.models.comp.*;
import com.surshree.app.services.CompetitionService;
import com.surshree.app.services.CustomUserDetailsService;
import com.surshree.app.services.FileService;
import com.surshree.app.util.ControllerUtils;
import com.surshree.app.util.DateUtils;
import com.surshree.app.util.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.ValidationException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class CompetitionController {

    @Autowired
    private CompetitionService compService;

    @Autowired
    private CustomUserDetailsService userSrvc;

    @Autowired
    private FileService fileService;

    private RazorpayClient razorpayClient;

    @PostConstruct
    public void initRpClient(){
        try {
            this.razorpayClient = new RazorpayClient(GlobalConstant.rpKey, GlobalConstant.rpSecret);
        }catch (RazorpayException e){
            log.error("Error Occurred While Initializing RP Client", e);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions")
    public ResponseEntity saveCompetitions(@RequestBody CompetitionRequestResponseModel request){
        CompetitionEntity competitionEntity = null;
        if(request.getCompetitionId() != null){
            competitionEntity = this.compService.getCompetitionsById(request.getCompetitionId()).get();
        }else {
            competitionEntity = new CompetitionEntity();
        }
        BeanUtils.copyProperties(request, competitionEntity);
        competitionEntity.setCompPhoto(UUID.fromString(request.getCompPhoto()));
        competitionEntity = this.compService.saveOrUpdate(competitionEntity);
        return ControllerUtils.getCreatedResponse("{competitionId}", competitionEntity.getCompetitionId().toString());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("competitions/active")
    public ResponseEntity getActiveCompetitions(){
        List<CompetitionRequestResponseModel> responses = compService.getActiveCompetitions()
                                                                     .get()
                                                                     .stream()
                                                                     .map(CompetitionRequestResponseModel::new)
                                                                     .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("competitions/{competitionId}")
    public ResponseEntity getCompetition(@PathVariable Long competitionId){
        CompetitionRequestResponseModel response = compService.getCompetitionsById(competitionId)
                                                                .map(CompetitionRequestResponseModel::new)
                                                                .get();
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions/enrollment/{competitionId}")
    public ResponseEntity enrollInCompetition(@PathVariable Long competitionId){
        //this.saveSubmittedEntry(competitionId);
        SubmittedEntriesEntity submittedEntriesEntity = this.getSubmittedEntry(competitionId);
        this.compService.saveOrUpdate(submittedEntriesEntity);
        return ResponseEntity.ok().build();
    }

    private SubmittedEntriesEntity getSubmittedEntry(Long competitionId){
        UserDetails user = this.userSrvc.loadUserByUsername(UserContext.getLoggedInUserId());
        CompetitionEntity comp = this.compService.getCompetitionsById(competitionId).get();
        SubmittedEntriesEntity submittedEntriesEntity = new SubmittedEntriesEntity();
        submittedEntriesEntity.setUserEntity((UserEntity) user);
        submittedEntriesEntity.setCompetitionEntity(comp);
        submittedEntriesEntity.setIsShortlisted(GlobalConstant.DB_NO);
        submittedEntriesEntity.setIsWinner(GlobalConstant.DB_NO);
        submittedEntriesEntity.setWinnerDesc(GlobalConstant.ONE_SPACE);
        submittedEntriesEntity.setPriceWon(BigDecimal.ZERO);
        int age = DateUtils.DU.getAge(((UserEntity) user).getDob());
        if(age < comp.getMinAge() || age > comp.getMaxAge()){
            throw new ValidationException("You cannot enroll into this competition as you do not meet the age criteria.");
        }
        return submittedEntriesEntity;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions/enrollment/{submittedEntryId}/{fileId}")
    public ResponseEntity attachFileToEnrolledCompetition(@PathVariable Long submittedEntryId, @PathVariable String fileId){
        SubmittedEntriesEntity submittedEntriesEntity = this.compService.findSubmittedEntryById(submittedEntryId);
        submittedEntriesEntity.setFileId(UUID.fromString(fileId));
        this.compService.saveOrUpdate(submittedEntriesEntity);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("competitions/enrollment")
    public ResponseEntity getEnrolledCompetition() {
        UserDetails user = this.userSrvc.loadUserByUsername(UserContext.getLoggedInUserId());
        List<EnrollmentResponse> enrollments = this.compService.getEnrolledCompetitionIds(((UserEntity)user).getUserId());
        return ResponseEntity.ok(enrollments);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions/subscribe/{compId}")
    public ResponseEntity subscribeToCompetition(@PathVariable Long compId){
        SubmittedEntriesEntity submittedEntriesEntity = this.getSubmittedEntry(compId);
        UserEntity user = submittedEntriesEntity.getUserEntity();
        CompetitionEntity comp = submittedEntriesEntity.getCompetitionEntity();

        SubscriptionEntity subscription = this.compService.getSubscriptionEntityByCompIdAndUserId(comp.getCompetitionId(), user.getUserId()).orElseGet(SubscriptionEntity::new);

        UUID subUuid = UUID.randomUUID();

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", comp.getSubscriptionPrice().multiply(new BigDecimal(100))); // amount in the smallest currency unit
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", subUuid.toString());
        orderRequest.put("payment_capture", true);

        JSONObject notes = new JSONObject();
        notes.put("ssOrderId", subUuid);
        notes.put("ssUserId", user.getUsername());
        orderRequest.put("notes", notes);

        try {
            Order order = razorpayClient.Orders.create(orderRequest);
            if(subscription.getBusinessKey() == null) {
                subscription.setBusinessKey(comp.getCompetitionId());
                subscription.setUserEntity((UserEntity) user);
            }
            subscription.setIsSuccessful(GlobalConstant.DB_YES);
            subscription.setSubscriptionUuid(subUuid);
            subscription.setAmountPaid(comp.getSubscriptionPrice());
            subscription.setOrderId(order.get("id"));
            subscription.setSubscriptionType("COMP");
            this.compService.saveSubscriptionEntity(subscription);
            SubscriptionEntity retuenEntity = new SubscriptionEntity();
            retuenEntity.setOrderId(subscription.getOrderId());
            return ResponseEntity.ok(retuenEntity);
        } catch (RazorpayException e){
            log.error("Error Occurred While Creating Order", e);
            return ResponseEntity.unprocessableEntity().body("Error occurred while processing your request. Please try again later.");
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions/search")
    public ResponseEntity searchCompetitions(@RequestBody CompetitionSearchModel searchModel){
        List<CompetitionRequestResponseModel> responses = compService.searchCompetitions(searchModel)
                                                                        .get()
                                                                        .stream()
                                                                        .map(CompetitionRequestResponseModel::new)
                                                                        .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("competitions/enrollment/{competitionId}")
    public ResponseEntity getAllEnrollments(@PathVariable Long competitionId){
        List<SubmittedEntriesModel> submittedEntriesModels = this.compService.getAllEnrollments(competitionId);
        if (submittedEntriesModels.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(submittedEntriesModels);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("competitions/shortlisted/{competitionId}")
    public ResponseEntity getShortlistedEntries(@PathVariable Long competitionId){
        List<SubmittedEntriesModel> submittedEntriesModels = this.compService.getShortlistedEntries(competitionId);
        if (submittedEntriesModels.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(submittedEntriesModels);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("competitions/winners/{competitionId}")
    public ResponseEntity getCompetitionWinners(@PathVariable Long competitionId){
        List<SubmittedEntriesModel> submittedEntriesModels = this.compService.getCompetitionWinners(competitionId);
        if (submittedEntriesModels.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Map<String,List<SubmittedEntriesModel>> map = submittedEntriesModels.stream()
                                                                            .collect(Collectors.groupingBy(p -> p.getCompetitionId().toString()));
        List<WinnerModel> response = new ArrayList<>();
        for (Map.Entry<String,List<SubmittedEntriesModel>> entry : map.entrySet()) {
            WinnerModel model = new WinnerModel();
            model.setCompId(entry.getKey());
            model.setWinners(entry.getValue());
            response.add(model);
        }
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("competitions/allwinners")
    public ResponseEntity getAllCompetitionWinners(){
        List<SubmittedEntriesModel> submittedEntriesModels = this.compService.getAllCompetitionWinners();
        if (submittedEntriesModels.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Map<String,List<SubmittedEntriesModel>> map = submittedEntriesModels.stream()
                .collect(Collectors.groupingBy(p -> p.getCompetitionId().toString()));
        List<WinnerModel> response = new ArrayList<>();
        for (Map.Entry<String,List<SubmittedEntriesModel>> entry : map.entrySet()) {
            WinnerModel model = new WinnerModel();
            model.setCompId(entry.getKey());
            model.setWinners(entry.getValue());
            SubmittedEntriesModel sem = entry.getValue().get(0);
            model.setCompDesc(sem.getCompDesc());
            model.setCompPhoto(sem.getCompPhoto());
            model.setCompTitle(sem.getCompTitle());
            response.add(model);
        }
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions/shortlist/{submittedEntryId}")
    public ResponseEntity markShortlisted(@PathVariable Long submittedEntryId){
        SubmittedEntriesEntity submittedEntriesEntity = this.compService.findSubmittedEntryById(submittedEntryId);
        submittedEntriesEntity.setIsShortlisted(GlobalConstant.DB_YES);
        this.compService.saveOrUpdate(submittedEntriesEntity);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions/winner")
    public ResponseEntity markWinners(@RequestBody List<SubmittedEntriesModel> models){
        this.compService.markWinner(models);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("competitions/subscribe/{orderId}/{paymentId}/{errorCode}/{errorDesc}")
    public ResponseEntity processPayment(@PathVariable String orderId, @PathVariable String paymentId, @PathVariable(required = false) String errorCode, @PathVariable(required = false) String errorDesc){
        Optional<SubscriptionEntity> subscriptionEntity = this.compService.getSubscriptionByOrderId(orderId);

        subscriptionEntity.ifPresent(d -> {
            SubmittedEntriesEntity submittedEntriesEntity = null;
            if(paymentId != null && !paymentId.equals("null")) {
                d.setTransactionId(paymentId);
                submittedEntriesEntity = this.getSubmittedEntry(d.getBusinessKey());
            }
            if(errorCode != null && !errorCode.equals("null")) {
                d.setErrorCode(errorCode);
                d.setErrorDesc(errorDesc);
            }else{
                d.setErrorCode(null);
                d.setErrorDesc(null);
            }

            this.compService.saveCompetitionAndSubscription(submittedEntriesEntity, d);
        });
        return ResponseEntity.ok().build();
    }
}
