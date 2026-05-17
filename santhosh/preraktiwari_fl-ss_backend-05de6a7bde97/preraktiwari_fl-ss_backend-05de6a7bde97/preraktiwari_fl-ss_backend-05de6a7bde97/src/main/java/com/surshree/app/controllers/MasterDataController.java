package com.surshree.app.controllers;

import com.surshree.app.services.MasterDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MasterDataController {
    @Autowired
    private MasterDataService dataService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/master/state")
    public ResponseEntity getStates(){
        return ResponseEntity.ok(this.dataService.getAllStates());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/master/categories")
    public ResponseEntity getCompCategories(){
        return ResponseEntity.ok(this.dataService.getAllCompCategory());
    }
}
