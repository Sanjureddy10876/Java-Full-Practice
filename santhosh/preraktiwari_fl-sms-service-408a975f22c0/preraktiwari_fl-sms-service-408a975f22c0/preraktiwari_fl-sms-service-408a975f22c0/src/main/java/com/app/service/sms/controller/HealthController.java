package com.app.service.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.sms.service.PodInfoService;


@RestController
public class HealthController {
	
    @Autowired
    private PodInfoService podService;
    
    @GetMapping(path = "/health")
    public String imUpAndRunning() {
        System.out.println(":::::::::::::::::data");
        return "{healthy:true}";
    }

    @GetMapping(path = "/")
    public String getPodInfo(){
        return this.podService.getInfo();
    }
}
