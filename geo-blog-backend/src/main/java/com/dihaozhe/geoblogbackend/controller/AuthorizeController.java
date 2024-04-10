package com.dihaozhe.geoblogbackend.controller;

import com.dihaozhe.common.response.Result;
import com.dihaozhe.geoblogbackend.pojo.vo.request.EmailRegisterVO;
import com.dihaozhe.geoblogbackend.service.AccountService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {

    @Resource
    AccountService accountService;

    @GetMapping("/ask-code")
    public Result<Void> askVerifyCode(@RequestParam @Email String email,
                                      @RequestParam @Pattern(regexp = "(register|reset)") String type,
                                      HttpServletRequest request) {
        return this.messageHandle(() ->
                accountService.registerEmailVerifyCode(type, email, request.getRemoteAddr()));
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody EmailRegisterVO emailRegisterVO) {
        return this.messageHandle(() ->
                accountService.registerEmailAccount(emailRegisterVO));
    }

    private Result<Void> messageHandle(Supplier<String> action) {
        String message = action.get();
        return message == null ? Result.success() : Result.failure(400, message);
    }
}
