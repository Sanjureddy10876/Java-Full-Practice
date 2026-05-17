package com.app.service.sms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/p")
public class TestController {

   @GetMapping(value = "/dd")
public String test(){

    return "test sucess";
}

}
