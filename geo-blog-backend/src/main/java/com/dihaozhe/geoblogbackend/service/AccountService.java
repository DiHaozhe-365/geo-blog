package com.dihaozhe.geoblogbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dihaozhe.geoblogbackend.pojo.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Account>, UserDetailsService {

    // 根据账号或手机号或邮箱查询账号
    Account selectAccountByUsernameOrPhoneOrEmail(String text);
}
