package com.dihaozhe.geoblogbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dihaozhe.geoblogbackend.mapper.AccountMapper;
import com.dihaozhe.haoblogbackend.pojo.entity.Account;
import com.dihaozhe.geoblogbackend.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.selectAccountByUsernameOrPhoneOrEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("账号或密码错误");
        }
        return User
                .withUsername(username)
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

    @Override
    public Account selectAccountByUsernameOrPhoneOrEmail(String text) {
        return this.query()
                .eq("username", text).or()
                .eq("phone",text).or()
                .eq("email",text)
                .eq("status","正常")
                .ne("is_deleted", 1)
                .one();
    }
}
