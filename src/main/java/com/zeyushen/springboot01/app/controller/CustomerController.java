package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.services.CustomerServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    public CustomerServices customerServices;

    @RequestMapping("/allCustomer")
    public ModelAndView getAllCustomer(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = true,defaultValue = "false") Boolean onlyData){
        List<CustomerInfoPojo> customerList=customerServices.getAllCustomer();
        ModelAndView mv = new ModelAndView("/filemanagement/customer/customer");
        String path="/filemanagement/customer/customer ::#table_paging";
        PagingUtil.paging("allCustomer",mv,pageNum,onlyData,path,()->customerServices.getAllCustomer());
        mv.addObject("customerList",customerList);
        return mv;
    }
}
