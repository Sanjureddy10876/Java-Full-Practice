package com.surshree.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(path = "/health")
    public String imUpAndRunning() {
        return "{healthy:true}";
    }

    @GetMapping(path = "/gettestapireddy")
    public String testApi(){
        return "hello santhosh how are you";
    }

}
