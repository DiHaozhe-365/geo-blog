package com.dihaozhe.geoblogbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dihaozhe.geoblogbackend.mapper.TagMapper;
import com.dihaozhe.geoblogbackend.pojo.entity.Tag;
import com.dihaozhe.geoblogbackend.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}




