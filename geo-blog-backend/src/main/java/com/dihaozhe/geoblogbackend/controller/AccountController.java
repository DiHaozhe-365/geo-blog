package com.dihaozhe.geoblogbackend.controller;

import com.dihaozhe.common.response.Result;
import com.dihaozhe.geoblogbackend.pojo.entity.Account;
import com.dihaozhe.geoblogbackend.service.AccountService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@Tag(name = "账号相关接口", description = "账号相关接口")
public class AccountController {

    @Resource
    public AccountService accountService;

    @GetMapping("/list")
    @Operation(summary = "获取账号列表")
    @ApiOperationSupport(author = "邸浩哲")
    public Result list() {
        return Result.success(accountService.list());
    }
}
