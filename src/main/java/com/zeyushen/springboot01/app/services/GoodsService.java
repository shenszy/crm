package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.GoodsPojoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsService.class);
    @Autowired
    GoodsPojoMapper goodsPojoMapper;


}
