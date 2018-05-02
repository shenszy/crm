package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.GoodsPojoMapper;
import com.zeyushen.springboot01.app.model.GoodsPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsService.class);
    @Autowired
    GoodsPojoMapper goodsPojoMapper;


    public List<GoodsPojo> getAllGoods() {
        return  goodsPojoMapper.getAll();
    }
}
