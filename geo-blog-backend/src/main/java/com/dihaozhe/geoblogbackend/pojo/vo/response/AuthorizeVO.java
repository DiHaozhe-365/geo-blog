package com.dihaozhe.geoblogbackend.pojo.vo.response;

import lombok.Data;

import java.util.Date;

@Data
public class AuthorizeVO {
    private String username;
    private String role;
    private String token;
    private Date expire;
}
