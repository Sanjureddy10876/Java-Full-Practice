package com.surshree.app.services;

import com.surshree.app.GlobalConstant;
import com.surshree.app.domain.entities.*;
import com.surshree.app.models.comp.CompetitionSearchModel;
import com.surshree.app.models.comp.EnrollmentResponse;
import com.surshree.app.models.comp.SubmittedEntriesModel;
import com.surshree.app.repository.CompetitionEntityRepo;
import com.surshree.app.repository.CompetitionEntityRepoImpl;
import com.surshree.app.repository.SubmittedEntriesRepo;
import com.surshree.app.repository.SubscriptionRepo;
import com.surshree.app.util.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionEntityRepo compRepo;

    @Autowired
    private SubmittedEntriesRepo entriesRepo;

    @Autowired
    private SubscriptionRepo subscriptionRepo;

    @Autowired
    private CompetitionEntityRepoImpl compRepoImpl;

    public Optional<List<CompetitionEntity>> getActiveCompetitions(){
        return this.compRepo.findByIsActiveAndIsWinnerAnnouncedOrderByCreatedTsDesc(GlobalConstant.DB_YES, GlobalConstant.DB_NO);
    }

    public Optional<CompetitionEntity> getCompetitionsById(Long competitionsId){
        return this.compRepo.findById(competitionsId);
    }

    @Transactional
    public SubmittedEntriesEntity saveOrUpdate(SubmittedEntriesEntity submittedEntriesEntity){
        return this.entriesRepo.save(submittedEntriesEntity);
    }

    @Transactional
    public CompetitionEntity saveOrUpdate(CompetitionEntity competitionEntity){
        return this.compRepo.save(competitionEntity);
    }

    public SubmittedEntriesEntity findSubmittedEntryById(Long submittedEntryId){
        return this.entriesRepo.findById(submittedEntryId).get();
    }

    public List<EnrollmentResponse> getEnrolledCompetitionIds(Long userId){
        List<EnrollmentResponse> enrollments = null;
        Optional<List<SubmittedEntriesEntity>> optEntries = this.entriesRepo.findByUserId(userId);
        if(optEntries.isPresent()){
            enrollments = optEntries.get()
                                    .stream()
                                    .map(c -> {
                                        EnrollmentResponse er = new EnrollmentResponse();
                                        er.setCompetitionId(c.getCompetitionEntity().getCompetitionId());
                                        er.setSubmittedEntryId(c.getSubmittedEntriesId());
                                        if(c.getFileId() != null){
                                            er.setFileId(c.getFileId().toString());
                                            er.setFileUploaded(true);
                                        }
                                        return er;
                                    })
                                    .collect(Collectors.toList());
        }
        return enrollments;
    }

    @Transactional
    public SubscriptionEntity saveCompetitionAndSubscription(SubmittedEntriesEntity submittedEntriesEntity, SubscriptionEntity subscriptionEntity){
        if(submittedEntriesEntity != null){
            this.entriesRepo.save(submittedEntriesEntity);
        }
        return this.subscriptionRepo.save(subscriptionEntity);
    }

    @Transactional
    public SubscriptionEntity saveSubscriptionEntity(SubscriptionEntity entity){
        return this.subscriptionRepo.save(entity);
    }

    public Optional<List<CompetitionEntity>> searchCompetitions(CompetitionSearchModel searchModel){
        return this.compRepoImpl.findUsingCriteria(searchModel);
    }

    @Transactional
    public List<SubmittedEntriesModel> getAllEnrollments(Long competitionId) {
        List<SubmittedEntriesModel> submittedEntriesModels = new ArrayList<>();
        this.entriesRepo
            .findByCompetitionId(competitionId)
            .ifPresent(entries -> this.prepareEntries(entries, submittedEntriesModels));
        return submittedEntriesModels;
    }

    @Transactional
    public List<SubmittedEntriesModel> getShortlistedEntries(Long competitionId) {
        List<SubmittedEntriesModel> submittedEntriesModels = new ArrayList<>();
        this.entriesRepo
                .findByCompetitionIdAndIsShortlisted(competitionId)
                .ifPresent(entries -> this.prepareEntries(entries, submittedEntriesModels));
        return submittedEntriesModels;
    }

    @Transactional
    public List<SubmittedEntriesModel> getCompetitionWinners(Long competitionId) {
        List<SubmittedEntriesModel> submittedEntriesModels = new ArrayList<>();
        this.entriesRepo
                .findByCompetitionIdAndIsWinnerAnnounced(competitionId)
                .ifPresent(entries -> this.prepareEntries(entries, submittedEntriesModels));
        return submittedEntriesModels;
    }

    @Transactional
    public List<SubmittedEntriesModel> getAllCompetitionWinners() {
        List<SubmittedEntriesModel> submittedEntriesModels = new ArrayList<>();
        this.entriesRepo
                .findAllByIsWinnerAnnounced()
                .ifPresent(entries -> this.prepareEntries(entries, submittedEntriesModels));
        return submittedEntriesModels;
    }

    private void prepareEntries(List<SubmittedEntriesEntity> entries, List<SubmittedEntriesModel> submittedEntriesModels ){
        entries.forEach(entry -> {
            SubmittedEntriesModel sem = new SubmittedEntriesModel();
            BeanUtils.copyProperties(entry, sem);
            CompetitionEntity comp = entry.getCompetitionEntity();
            sem.setCompDesc(comp.getDescription());
            sem.setCompPhoto(comp.getCompPhoto() != null ? comp.getCompPhoto().toString() : null);
            sem.setCompTitle(comp.getTitle());
            sem.setCompetitionId(comp.getCompetitionId());
            UserEntity user = entry.getUserEntity();
            UserDetailsEntity details = user.getDetails();
            if(details != null) {
                sem.setState(details.getAddress().getAddressState());
                sem.setCity(details.getAddress().getAddressCity());
                if(details.getProfilePicture() != null) {
                    sem.setUserProfile(details.getProfilePicture().toString());
                }
            }
            sem.setUsername(user.getUsername());
            sem.setFullUserName(user.getFirstName() + " " + user.getLastName());
            sem.setGender(user.getGender());
            sem.setAge(DateUtils.DU.getAge(user.getDob()));
            if(entry.getFileId() != null) {
                sem.setFileId(entry.getFileId().toString());
            }
            submittedEntriesModels.add(sem);
        });
    }

    @Transactional
    public void markWinner(List<SubmittedEntriesModel> models) {
        models.forEach(
                model -> {
                    SubmittedEntriesEntity entity = this.entriesRepo.findById(model.getSubmittedEntriesId()).get();
                    entity.setIsWinner(GlobalConstant.DB_YES);
                    entity.setPriceWon(model.getPriceWon());
                    entity.setWinnerDesc(model.getWinnerDesc());
                    entity.getCompetitionEntity().setIsWinnerAnnounced(GlobalConstant.DB_YES);
                    this.entriesRepo.save(entity);
                }
        );
    }

    public Optional<SubscriptionEntity> getSubscriptionEntityByCompIdAndUserId(Long compId, Long userId){
        return this.subscriptionRepo.findByBusinessKeyAndSubscriptionTypeAndUserId(compId, userId, "COMP");
    }

    public Optional<SubscriptionEntity> getSubscriptionByOrderId(String orderId) {
        return this.subscriptionRepo.findByOrderId(orderId);
    }
}
