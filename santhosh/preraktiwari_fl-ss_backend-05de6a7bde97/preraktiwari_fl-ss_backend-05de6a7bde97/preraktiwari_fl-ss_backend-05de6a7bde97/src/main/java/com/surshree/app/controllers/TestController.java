package com.surshree.app.controllers;

import com.surshree.app.repository.RoleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    RoleRepo repo;

    @GetMapping("/")
    public String user(){
        log.info("started loading");

        log.info("load by id ended");
        return "loaded";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>Welcome Admin</h1>";
    }
}
