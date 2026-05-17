package com.surshree.app.services;

import com.surshree.app.domain.entities.MstRoleEntity;
import com.surshree.app.domain.enums.RoleEnum;
import com.surshree.app.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public MstRoleEntity getRoleForUser(String userType){
        return roleRepo.findByRoleName(RoleEnum.getDescByName(userType).getDesc());
    }

    public MstRoleEntity saveOrUpdate(MstRoleEntity role){
        return this.roleRepo.save(role);
    }
}
