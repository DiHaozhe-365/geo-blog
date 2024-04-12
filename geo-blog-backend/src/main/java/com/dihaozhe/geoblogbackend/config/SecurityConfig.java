package com.dihaozhe.geoblogbackend.config;

import com.dihaozhe.geoblogbackend.filter.JwtAuthorizeFilter;
import com.dihaozhe.geoblogbackend.pojo.entity.Account;
import com.dihaozhe.geoblogbackend.pojo.vo.response.AuthorizeVO;
import com.dihaozhe.geoblogbackend.service.AccountService;
import com.dihaozhe.geoblogbackend.utils.JwtUtils;
import com.dihaozhe.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig {

    @Resource
    JwtUtils jwtUtils;

    @Resource
    JwtAuthorizeFilter jwtAuthorizeFilter;

    @Resource
    AccountService accountService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(conf -> conf
                        .requestMatchers("/api/auth/**", "/error", "/doc.html", "/webjars/**", "/v2/**","/v3/**", "/swagger-resources/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(conf -> conf
                        .loginProcessingUrl("/api/auth/login")
                        .successHandler(this::onAuthenticationSuccess)
                        .failureHandler(this::onAuthenticationFailure)
                )
                .logout(conf -> conf
                        .logoutUrl("/api/auth/logout")
                        .logoutSuccessHandler(this::onLogoutSuccess)
                )
                .exceptionHandling(conf -> conf
                        .authenticationEntryPoint(this::onUnauthorized)
                        .accessDeniedHandler(this::onAccessDeny)
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(conf -> conf
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthorizeFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // 登录成功
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        User user = (User) authentication.getPrincipal();
        Account account = accountService.selectAccountByUsernameOrPhoneOrEmail(user.getUsername());
        String token = jwtUtils.createJwt(user, account.getId(), account.getUsername());
        AuthorizeVO authorizeVO = new AuthorizeVO();
        BeanUtils.copyProperties(account, authorizeVO);
        authorizeVO.setToken(token);
        authorizeVO.setExpire(jwtUtils.expireTime());
        response.getWriter().write(Result.success(authorizeVO).toJSON());
    }

    // 登录失败
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException authenticationException) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(Result.unauthorized(authenticationException.getMessage()).toJSON());
    }

    // 退出登录成功
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String authorization = request.getHeader("Authorization");
        if (jwtUtils.invalidateJwt(authorization)) {
            writer.write(Result.success().toJSON());
        } else {
            writer.write(Result.failure(400,"退出登录失败").toJSON());
        }
    }

    // 未验证
    public void onUnauthorized(HttpServletRequest request,
                               HttpServletResponse response,
                               AuthenticationException authenticationException) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(Result.unauthorized(authenticationException.getMessage()).toJSON());
    }

    // 权限不足
    public void onAccessDeny(HttpServletRequest request,
                             HttpServletResponse response,
                             AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(Result.forbidden(accessDeniedException.getMessage()).toJSON());
    }
}
