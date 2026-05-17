package com.surshree.app.services;

import com.surshree.app.domain.entities.BaseEntity;
import com.surshree.app.domain.entities.UserDetailsEntity;
import com.surshree.app.domain.entities.UserEntity;
import com.surshree.app.domain.enums.UserTypeEnum;
import com.surshree.app.repository.UserDetailsRepo;
import com.surshree.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserDetailsRepo userDerailsRepo;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = this.userRepo.findByUsername(username);
        UserEntity userEntity = user.orElseThrow(() -> new UsernameNotFoundException("User details not found for user --> " + username));

        userEntity.getAuthorities().stream().forEach(r -> log.info("Granted Authorities --> " + r.toString()));

        return userEntity;
    }

    public UserDetailsEntity loadUserDetailsByUserName(String username){
        return this.userDerailsRepo.findByUserName(username);
    }

    @Transactional
    public UserEntity saveOrUpdateUser(UserEntity user, UserDetailsEntity details){
        user = this.userRepo.save(user);
        if(details != null) {
            details.setUser(user);
            this.userDerailsRepo.save(details);
        }
        return user;
    }

    @Transactional
    public UserDetailsEntity saveOrUpdateUser(UserDetailsEntity userDetails){
        return this.userDerailsRepo.save(userDetails);
    }

    public Optional<? extends BaseEntity> getUserTypeDetailsByUserType(UserEntity user){
        Optional<? extends BaseEntity> userTypeDetails = Optional.empty();
        switch(UserTypeEnum.getDescByName(user.getUserType())){
            case CONT:  {  break; }
            case MENT:  {  break; }
            case ADMN : { return Optional.of(user); }
            default :  throw new RuntimeException("Not Yet Implemented for specified user > " + user.getUserType());
        }
        return userTypeDetails;
    }
}
