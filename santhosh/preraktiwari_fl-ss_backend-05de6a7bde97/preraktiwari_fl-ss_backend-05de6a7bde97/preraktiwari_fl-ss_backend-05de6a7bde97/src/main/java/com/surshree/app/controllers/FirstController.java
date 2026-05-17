package com.surshree.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping(path = "/gettestapi")
    public String testApi(){
        return "hello santhosh how are you";
    }









    @GetMapping(value = "StoringVale")
    public String store(){
        return "hello how can i help you";

    }



}
