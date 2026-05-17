package com.surshree.app.repository;

import com.surshree.app.CacheConstants;
import com.surshree.app.domain.entities.MstRoleEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<MstRoleEntity, Integer> {

    public MstRoleEntity findByRoleName(String roleName);
}
