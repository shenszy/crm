package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.AddressPojo;
import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.services.AddressServices;
import com.zeyushen.springboot01.app.services.CustomerServices;
import com.zeyushen.springboot01.app.util.FileUtil;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    public CustomerServices customerServices;
    @Autowired
    private AddressServices addressServices;

    @RequestMapping("/allCustomer.html")
    public ModelAndView getAllCustomer(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = true,defaultValue = "false") Boolean onlyData){
        List<CustomerInfoPojo> customerList=customerServices.getAllCustomer();
        ModelAndView mv = new ModelAndView("/filemanagement/customer/customer");
        String path="/filemanagement/customer/customer ::#table_paging";
        PagingUtil.paging("allCustomer",mv,pageNum,onlyData,path,()->customerServices.getAllCustomer());
        mv.addObject("customerList",customerList);
        return mv;
    }

    @RequestMapping("/adress")
    public ModelAndView getDepAndAdress(String parentID,@RequestParam(required = true,defaultValue = "/filemanagement/customer/addCustomer.html") String path){
        //三级联动
        List<AddressPojo> address=addressServices.getArea(parentID);
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("addresses",address);
        return mv;
    }


    @PostMapping("/insert.html")
    public String insertSelective(CustomerInfoPojo customerInfoPojo,@RequestParam("fileForPhoto") MultipartFile fileForPhoto, HttpServletRequest request){
        String path="";
        if(!fileForPhoto.isEmpty()){
            String fileName=fileForPhoto.getOriginalFilename();
            String filePath="/photo/";
            try {
               path= FileUtil.uploadFile(fileForPhoto.getBytes(),filePath,fileName);
               customerInfoPojo.setcPhoto(path);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
       customerServices.insertOneCustomer(customerInfoPojo);
        return "forward:/customer/allCustomer.html";
    }
}
