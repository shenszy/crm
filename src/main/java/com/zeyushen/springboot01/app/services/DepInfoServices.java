package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.DepInfoPojoMapper;
import com.zeyushen.springboot01.app.model.DepInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("depInfoServices")
public class DepInfoServices {
    @Autowired
    private DepInfoPojoMapper depInfoPojoMapper;

    public DepInfoPojo selectByPrimaryKey (Integer dId){
        return depInfoPojoMapper.selectByPrimaryKey(dId);

    }

    public List<DepInfoPojo> getAll(){
        return depInfoPojoMapper.getAll();
    }

    public int addOneDep(String dName){return depInfoPojoMapper.addOneDep(dName);}

    public int deleteById(Integer dId){return depInfoPojoMapper.deleteById(dId);}
}
