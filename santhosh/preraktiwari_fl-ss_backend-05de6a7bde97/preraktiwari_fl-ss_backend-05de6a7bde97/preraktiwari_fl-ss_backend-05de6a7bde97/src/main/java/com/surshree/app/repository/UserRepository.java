package com.surshree.app.repository;

import com.surshree.app.CacheConstants;
import com.surshree.app.domain.entities.UserEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Cacheable(value = CacheConstants.CACHE_USERS, key = "#username")
    Optional<UserEntity> findByUsername(String username);

    @Override
    @CacheEvict(value = CacheConstants.CACHE_USERS, key = "#user.username", condition = "#user.username != null")
    UserEntity save(UserEntity user);

}
