package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.DepInfoPojo;
import com.zeyushen.springboot01.app.services.DepInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/depinfo")
public class DepInfoController {
    @Autowired
    private DepInfoServices depInfoServices;

    @RequestMapping("/depall")
    @ResponseBody
    public List<DepInfoPojo> getAll(){
        return depInfoServices.getAll();
    }

    @RequestMapping("/depone")
    @ResponseBody
    public DepInfoPojo selectByPrimaryKey(Integer dId){
        return depInfoServices.selectByPrimaryKey(dId);
    }
}
