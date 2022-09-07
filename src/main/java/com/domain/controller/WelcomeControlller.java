package com.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeControlller {

    @GetMapping
    public String welcome(){
        return "Selamaat dataang Springboot";
    }

//    @PostMapping
//    public String other(){
//        return "Lainnya dong";
//    }
}
