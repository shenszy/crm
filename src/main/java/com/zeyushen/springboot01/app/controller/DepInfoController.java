package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.DepInfoPojo;
import com.zeyushen.springboot01.app.services.DepInfoServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepInfoController {
    @Autowired
    private DepInfoServices depInfoServices;

    /**
     * 查询所有部门数据
     * @param pageNum  页码
     * @param onlyData 数据
     * @return
     */
    @RequestMapping("/allDep.html")
    public ModelAndView getAll(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                               @RequestParam(required = true,defaultValue = "false") Boolean onlyData){
        ModelAndView mv = new ModelAndView("/filemanagement/dep/dep");
        PagingUtil.paging("allDep",mv,pageNum,onlyData,()->depInfoServices.getAll());
        return mv;
    }

    @RequestMapping("/addDep.html")
    public ModelAndView addDep(){
        ModelAndView mv=new ModelAndView("/filemanagement/dep/addDep");
        return mv;
    }

    /**
     * 插入单条数据
     * @param dName 部门名称
     * @return
     */
    @RequestMapping("/insert.html")
    public String addOneDep(String dName){
        depInfoServices.addOneDep(dName);
        return "forward:/dep/allDep.html";
    }

    @RequestMapping("/delete.html")
    public String deleteById(Integer dId){
        depInfoServices.deleteById(dId);
        return "forward:/dep/allDep.html";
    }

    @RequestMapping("/depone")
    public DepInfoPojo selectByPrimaryKey(Integer dId){
        return depInfoServices.selectByPrimaryKey(dId);
    }
}
