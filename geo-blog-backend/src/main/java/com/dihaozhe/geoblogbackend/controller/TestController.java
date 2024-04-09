package com.dihaozhe.geoblogbackend.controller;

import com.dihaozhe.geoblogbackend.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Resource
    public AccountService accountService;

    @GetMapping("/hello")
    public String test() {
        return "Hello World";
    }
}
