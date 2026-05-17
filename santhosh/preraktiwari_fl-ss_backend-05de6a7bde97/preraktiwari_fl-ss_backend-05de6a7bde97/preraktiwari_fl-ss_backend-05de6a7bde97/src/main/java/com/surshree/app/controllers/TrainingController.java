package com.surshree.app.controllers;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.surshree.app.GlobalConstant;
import com.surshree.app.domain.entities.*;
import com.surshree.app.models.training.TrainingContentModel;
import com.surshree.app.models.training.TrainingModel;
import com.surshree.app.services.CustomUserDetailsService;
import com.surshree.app.services.TrainingService;
import com.surshree.app.util.ControllerUtils;
import com.surshree.app.util.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    private RazorpayClient razorpayClient;

    @PostConstruct
    public void initRpClient(){
        try {
            this.razorpayClient = new RazorpayClient(GlobalConstant.rpKey, GlobalConstant.rpSecret);
        }catch (RazorpayException e){
            log.error("Error Occurred While Initializing RP Client", e);
        }
    }

    @PostMapping("/training")
    public ResponseEntity saveTraining(@RequestBody TrainingModel request){
        TrainingEntity trainingEntity = this.trainingService.findById(request.getTrainingId()).orElseGet(TrainingEntity::new);
        BeanUtils.copyProperties(request, trainingEntity, "trainingId");
        trainingEntity.setTrainingPhoto(UUID.fromString(request.getTrainingPhoto()));

        if(request.getTrainingContents() != null){
            trainingEntity.getTrainingContents().clear();
            request.getTrainingContents().forEach(c -> {
                TrainingContentEntity tc = new TrainingContentEntity();
                BeanUtils.copyProperties(c, tc);
                tc.setContentId(UUID.fromString(c.getContentId()));
                tc.setTrainingEntity(trainingEntity);
                trainingEntity.getTrainingContents().add(tc);
            });
        }

        this.trainingService.save(trainingEntity);
        return ControllerUtils.getCreatedResponse("{trainingId}/", trainingEntity.getTrainingId().toString());
    }

    @GetMapping("/trainings")
    public ResponseEntity getTrainings(){
        Optional<List<TrainingEntity>> optTrainingEntities = this.trainingService.getAllTrainings();
        Optional<List<SubscriptionEntity>> optSubscriptionEntities = this.trainingService.getSubscriptionEntityByUserId(UserContext.getLoggedInUserId());
        List<TrainingModel> trainingModels = new ArrayList<>();
        optTrainingEntities.get()
                            .forEach(e -> {
                                TrainingModel trainingModel = new TrainingModel();
                                List<TrainingContentModel> trainingContentModels = new ArrayList<>();
                                trainingModel.setTrainingContents(trainingContentModels);
                                BeanUtils.copyProperties(e, trainingModel);
                                trainingModel.setTrainingPhoto(e.getTrainingPhoto().toString());
                                if(optSubscriptionEntities.isPresent()){
                                    boolean isPresent = optSubscriptionEntities.get()
                                            .stream()
                                            .anyMatch(s -> s.getBusinessKey().compareTo(e.getTrainingId()) == 0 && Objects.nonNull(s.getTransactionId()));
                                    if(isPresent){
                                        trainingModel.setIsSubscribed(Boolean.TRUE);
                                    }
                                }
                                e.getTrainingContents().forEach(tc -> {
                                    TrainingContentModel trainingContentModel = new TrainingContentModel();
                                    BeanUtils.copyProperties(tc, trainingContentModel);
                                    trainingContentModel.setContentId(tc.getContentId().toString());
                                    trainingContentModels.add(trainingContentModel);
                                });
                                trainingModel.getTrainingContents().sort(TrainingContentModel::compare);
                                trainingModels.add(trainingModel);
                            });
        return ResponseEntity.ok(trainingModels);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("trainings/subscribe/{trainingId}")
    public ResponseEntity subscribeToCompetition(@PathVariable Long trainingId){
        UserEntity user = (UserEntity)this.customUserDetailsService.loadUserByUsername(UserContext.getLoggedInUserId());
        TrainingEntity trainingEntity = this.trainingService.findById(trainingId).get();
        SubscriptionEntity subscription = this.trainingService.getSubscriptionEntityByTrainingIdAndUserId(trainingId, user.getUserId()).orElseGet(SubscriptionEntity::new);

        UUID subUuid = UUID.randomUUID();

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", trainingEntity.getSubscriptionAmount().multiply(new BigDecimal(100))); // amount in the smallest currency unit
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
                subscription.setBusinessKey(trainingId);
                subscription.setUserEntity((UserEntity) user);
            }
            subscription.setIsSuccessful(GlobalConstant.DB_YES);
            subscription.setSubscriptionUuid(subUuid);
            subscription.setAmountPaid(trainingEntity.getSubscriptionAmount());
            subscription.setOrderId(order.get("id"));
            subscription.setSubscriptionType("TRNG");
            this.trainingService.saveSubscriptionEntity(subscription);
            SubscriptionEntity retuenEntity = new SubscriptionEntity();
            retuenEntity.setOrderId(subscription.getOrderId());
            return ResponseEntity.ok(retuenEntity);
        } catch (RazorpayException e){
            log.error("Error Occurred While Creating Order", e);
            return ResponseEntity.unprocessableEntity().body("Error occurred while processing your request. Please try again later.");
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("trainings/subscribe/{orderId}/{paymentId}/{errorCode}/{errorDesc}")
    public ResponseEntity processPayment(@PathVariable String orderId, @PathVariable String paymentId, @PathVariable(required = false) String errorCode, @PathVariable(required = false) String errorDesc){
        Optional<SubscriptionEntity> subscriptionEntity = this.trainingService.getSubscriptionByOrderId(orderId);

        subscriptionEntity.ifPresent(d -> {
            SubmittedEntriesEntity submittedEntriesEntity = null;
            if(paymentId != null && !paymentId.equals("null")) {
                d.setTransactionId(paymentId);
            }
            if(errorCode != null && !errorCode.equals("null")) {
                d.setErrorCode(errorCode);
                d.setErrorDesc(errorDesc);
            }else{
                d.setErrorCode(null);
                d.setErrorDesc(null);
            }
            this.trainingService.saveSubscriptionEntity(d);
        });
        return ResponseEntity.ok().build();
    }
}
