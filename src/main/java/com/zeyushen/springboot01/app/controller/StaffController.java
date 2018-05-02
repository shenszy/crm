package com.zeyushen.springboot01.app.controller;


import com.zeyushen.springboot01.app.model.AddressPojo;
import com.zeyushen.springboot01.app.model.DepInfoPojo;
import com.zeyushen.springboot01.app.model.StaffPojo;
import com.zeyushen.springboot01.app.services.AddressServices;
import com.zeyushen.springboot01.app.services.DepInfoServices;
import com.zeyushen.springboot01.app.services.StaffServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffServices staffServices;
    @Autowired
    private DepInfoServices depInfoServices;
    @Autowired
    private AddressServices addressServices;

    @RequestMapping("/allStaff.html")
    public ModelAndView getAllStaff(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = true,defaultValue = "false") Boolean onlyData) {
        List<DepInfoPojo> depInfoPojoList=depInfoServices.getAll();
        ModelAndView mv = new ModelAndView("/filemanagement/staff/staff");
        String path="/filemanagement/staff/staff ::#table_paging";
        PagingUtil.paging("allStaff",mv,pageNum,onlyData,path, staffServices::getAllStaff);
        mv.addObject("depInfoPojoList",depInfoPojoList);
        return mv;
    }

    @RequestMapping("/depAndAdress")
    public ModelAndView getDepAndAdress(String parentID,@RequestParam(required = true,defaultValue = "/filemanagement/staff/addStaff.html") String path){
        //选择部门
        List<DepInfoPojo> dep=depInfoServices.getAll();
        //三级联动
        List<AddressPojo> address=addressServices.getArea(parentID);
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("dep",dep);
        mv.addObject("addresses",address);
        return mv;
    }

    @RequestMapping("/insert.html")
    public String insertSelective(StaffPojo staffPojo){
        staffServices.insertSelective(staffPojo);
        return "forward:/staff/allStaff.html";
    }

    @RequestMapping("/delete.html")
    public String deleteBySId(Integer sId){
        staffServices.deleteBySId(sId);
        return "forward:/staff/allStaff.html";
    }

    @RequestMapping("/getOneForAlter")
    public ModelAndView getOneStaff(Integer sId,String parentID,@RequestParam(required = true,defaultValue = "/filemanagement/staff/alterStaff.html") String path){
        StaffPojo oneStaff=staffServices.selectBySId(sId);
        DepInfoPojo oneDep=depInfoServices.selectByPrimaryKey(oneStaff.getdId());
        //选择部门
        List<DepInfoPojo> dep=depInfoServices.getAll();
        List<AddressPojo> address=addressServices.getArea(parentID);
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("oneStaff",oneStaff);
        mv.addObject("oneDep",oneDep);
        mv.addObject("dep",dep);
        mv.addObject("addresses",address);
        return mv;
    }

    @RequestMapping("/alter.html")
    public String alterOneStaff(StaffPojo staffPojo){
        staffServices.updateBySId(staffPojo);
        return "forward:/staff/allStaff.html";
    }

    @RequestMapping("/getStaffByTerm.html")
    public ModelAndView getStaffByTerm(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = true,defaultValue = "true") Boolean onlyData,
                                       String sName,Integer dId ){
        ModelAndView mv = new ModelAndView("/filemanagement/staff/staff ::#table_paging");
        String path="/filemanagement/staff/staff ::#table_paging";
        PagingUtil.paging("allStaff",mv,pageNum,onlyData,path,()->staffServices.getStaffByTerm(sName,sName,dId));
        return mv;
    }
}
