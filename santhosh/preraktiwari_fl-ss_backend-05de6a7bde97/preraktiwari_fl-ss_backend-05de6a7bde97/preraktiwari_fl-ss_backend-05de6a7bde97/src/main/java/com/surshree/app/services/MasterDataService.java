package com.surshree.app.services;

import com.surshree.app.domain.entities.MstCompetitionCategory;
import com.surshree.app.domain.entities.MstStateEntity;
import com.surshree.app.repository.MstCompetitionCategoryRepo;
import com.surshree.app.repository.MstStateEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterDataService {

    @Autowired
    private MstStateEntityRepo stateRepo;

    @Autowired
    private MstCompetitionCategoryRepo categoryRepo;

    public List<MstStateEntity> getAllStates(){
        return this.stateRepo.findAll();
    }

    public List<MstCompetitionCategory> getAllCompCategory(){
        return this.categoryRepo.findAll();
    }
}
