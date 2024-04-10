package com.dihaozhe.geoblogbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dihaozhe.geoblogbackend.pojo.entity.Account;
import com.dihaozhe.geoblogbackend.pojo.vo.request.EmailRegisterVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Account>, UserDetailsService {

    // 根据账号或手机号或邮箱查询账号
    Account selectAccountByUsernameOrPhoneOrEmail(String text);

    // 注册邮件验证码
    String registerEmailVerifyCode(String type, String email, String ip);

    // 注册邮件账号
    String registerEmailAccount(EmailRegisterVO emailRegisterVO);
}
