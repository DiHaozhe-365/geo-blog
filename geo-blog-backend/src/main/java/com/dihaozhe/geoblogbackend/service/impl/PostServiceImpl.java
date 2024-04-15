package com.dihaozhe.geoblogbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dihaozhe.geoblogbackend.mapper.PostMapper;
import com.dihaozhe.geoblogbackend.pojo.entity.Post;
import com.dihaozhe.geoblogbackend.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}




