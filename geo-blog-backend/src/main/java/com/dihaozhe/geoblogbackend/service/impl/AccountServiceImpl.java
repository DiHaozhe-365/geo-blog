package com.dihaozhe.geoblogbackend.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dihaozhe.geoblogbackend.mapper.AccountMapper;
import com.dihaozhe.geoblogbackend.pojo.entity.Account;
import com.dihaozhe.geoblogbackend.pojo.vo.request.EmailRegisterVO;
import com.dihaozhe.geoblogbackend.service.AccountService;
import com.dihaozhe.geoblogbackend.utils.Constent;
import com.dihaozhe.geoblogbackend.utils.FlowUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    FlowUtils flowUtils;

    @Resource
    AmqpTemplate amqpTemplate;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    PasswordEncoder passwordEncoder;

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

    @Override
    public String registerEmailVerifyCode(String type, String email, String ip) {
        synchronized (ip.intern()) {
            if (!this.verifyLimit(ip)) {
                return "请求频繁，请稍后再试";
            }
            Random random = new Random();
            int code = random.nextInt(899999) + 100000;
            Map<String, Object> data = Map.of("type",type,"email", email, "code", code);
            amqpTemplate.convertAndSend("mail", data);
            stringRedisTemplate.opsForValue()
                    .set(Constent.VERIFY_EMAIL_DATA + email, String.valueOf(code), 3, TimeUnit.MINUTES);
            return null;
        }
    }

    @Override
    public String registerEmailAccount(EmailRegisterVO emailRegisterVO ) {
        String email = emailRegisterVO.getEmail();
        String username = emailRegisterVO.getUsername();
        String key = Constent.VERIFY_EMAIL_DATA + email;
        String code = stringRedisTemplate.opsForValue().get(key);
        if (code == null) {
            return "请先获取验证码";
        }
        if (!code.equals(emailRegisterVO.getCode())) {
            return "验证码错误，请重新输入";
        }
        if (existsAccountByEmail(email)) {
            return "此电子邮件已被其他用户注册";
        }
        if (existsAccountByUsername(username)) {
            return "此账号已被其他用户注册";
        }
        String password = passwordEncoder.encode(emailRegisterVO.getPassword());
        Account account = new Account();
        account.setId(null);
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);
        account.setRole("普通用户");
        account.setNickname(emailRegisterVO.getNickname());
        if (this.save(account)) {
            stringRedisTemplate.delete(key);
            return null;
        } else {
            return "内部错误，请联系管理员";
        }
    }

    private boolean verifyLimit(String ip) {
        String key = Constent.VERIFY_EMAIL_LIMIT + ip;
        return flowUtils.limitOnceCheck(key, 60);
    }

    // 通过邮箱判断用户是否存在
    private boolean existsAccountByEmail(String email) {
        return this.baseMapper.exists(Wrappers.<Account>query().eq("email", email));
    }

    // 通过账号判断用户是否存在
    private boolean existsAccountByUsername(String username) {
        return this.baseMapper.exists(Wrappers.<Account>query().eq("username", username));
    }
}
