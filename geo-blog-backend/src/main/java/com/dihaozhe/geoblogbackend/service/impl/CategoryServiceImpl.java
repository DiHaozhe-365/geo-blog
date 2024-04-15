package com.dihaozhe.geoblogbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dihaozhe.geoblogbackend.mapper.CategoryMapper;
import com.dihaozhe.geoblogbackend.pojo.entity.Category;
import com.dihaozhe.geoblogbackend.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}




