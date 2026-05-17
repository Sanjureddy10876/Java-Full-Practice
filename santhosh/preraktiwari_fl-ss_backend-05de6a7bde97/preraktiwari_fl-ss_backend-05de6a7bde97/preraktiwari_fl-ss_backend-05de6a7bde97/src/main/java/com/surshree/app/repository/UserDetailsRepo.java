package com.surshree.app.repository;

import com.surshree.app.domain.entities.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity, Integer> {
    public UserDetailsEntity findByUserName(String userName);
}
