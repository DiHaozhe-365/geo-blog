package com.dihaozhe.geoblogbackend.controller;

import com.dihaozhe.common.response.Result;
import com.dihaozhe.geoblogbackend.pojo.vo.request.EmailRegisterVO;
import com.dihaozhe.geoblogbackend.service.AccountService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "认证相关接口", description = "认证相关接口")
public class AuthorizeController {

    @Resource
    AccountService accountService;

    @GetMapping("/ask-code")
    @Operation(summary = "获取邮箱验证码")
    @ApiOperationSupport(author = "邸浩哲")
    public Result<Void> askVerifyCode(@RequestParam @Email String email,
                                      @RequestParam @Pattern(regexp = "(register|reset)") String type,
                                      HttpServletRequest request) {
        return this.messageHandle(() ->
                accountService.registerEmailVerifyCode(type, email, request.getRemoteAddr()));
    }

    @PostMapping("/register")
    @Operation(summary = "注册账号")
    @ApiOperationSupport(author = "邸浩哲")
    public Result<Void> register(@RequestBody EmailRegisterVO emailRegisterVO) {
        return this.messageHandle(() ->
                accountService.registerEmailAccount(emailRegisterVO));
    }

    @PostMapping("/login")
    @Operation(summary = "登录账号")
    @ApiOperationSupport(author = "邸浩哲")
    public Result<Void> login(@RequestParam String username, @RequestParam String password) {
        return null;
    }

    @GetMapping("/logout")
    @Operation(summary = "退出登录")
    @ApiOperationSupport(author = "邸浩哲")
    public Result<Void> logout() {
        return null;
    }

    private Result<Void> messageHandle(Supplier<String> action) {
        String message = action.get();
        return message == null ? Result.success() : Result.failure(400, message);
    }
}
