package com.dihaozhe.geoblogbackend.controller;

import com.dihaozhe.geoblogbackend.pojo.entity.Account;
import com.dihaozhe.geoblogbackend.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Resource
    public AccountService accountService;

    @GetMapping("/list")
    public List<Account> list() {
        return accountService.list();
    }
}
