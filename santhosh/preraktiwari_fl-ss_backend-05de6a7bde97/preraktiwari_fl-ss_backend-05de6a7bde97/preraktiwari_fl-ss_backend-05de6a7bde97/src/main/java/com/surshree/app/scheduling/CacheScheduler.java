package com.surshree.app.scheduling;

import com.surshree.app.CacheConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CacheScheduler {

    @Autowired
    private CacheManager cacheManager;

    @Scheduled(fixedDelay = 600000)
    public void clearUserCache(){
        log.info("Clear user cache : START");
        cacheManager.getCache(CacheConstants.CACHE_USERS).clear();
        log.info("Clear user cache : END");
    }
}
