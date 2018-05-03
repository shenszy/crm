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

    public boolean add(GoodsPojo goodsPojo) {
        //TODO
        goodsPojo.setsId(1);
        return  goodsPojoMapper.insert(goodsPojo) == 1;
    }

    public boolean delete(String gId) {
        if(gId==null||gId.isEmpty()){
            return false;
        }else{
            return  goodsPojoMapper.deleteByPrimaryKey(gId)==1;
        }
    }

    public boolean update(GoodsPojo goods) {
        return goods != null && goods.getgId() != null && goodsPojoMapper.updateByPrimaryKeySelective(goods) == 1;
        }

    public GoodsPojo getById(String gId) {
        if(gId==null||gId.isEmpty()){
            return null;
        }else{
            return  goodsPojoMapper.selectByPrimaryKey(gId);
        }
    }
}
