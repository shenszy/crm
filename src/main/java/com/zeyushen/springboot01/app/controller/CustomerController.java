package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.AddressPojo;
import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.model.DepInfoPojo;
import com.zeyushen.springboot01.app.model.StaffPojo;
import com.zeyushen.springboot01.app.services.AddressServices;
import com.zeyushen.springboot01.app.services.CustomerServices;
import com.zeyushen.springboot01.app.services.FileServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    public CustomerServices customerServices;
    @Autowired
    private AddressServices addressServices;
    @Autowired
    private FileServices fileServices;

    @RequestMapping("/customer.html")
    public ModelAndView getAllCustomer(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                       @RequestParam(required = true,defaultValue = "false") Boolean onlyData,
                                       @RequestParam(required = true,defaultValue = "") String cName,
                                       @RequestParam(required = true,defaultValue = "")String cDegree,
                                       @RequestParam(required = true,defaultValue = "")String cLevel){
        ModelAndView mv = new ModelAndView("/filemanagement/customer/customer");
        PagingUtil.paging("allCustomer",mv,pageNum,onlyData,()->customerServices.getCustomerByTerm(cName,cName,cDegree,cLevel));
        return mv;
    }

    @RequestMapping("/address")
    public ModelAndView getDepAndAdress(String parentID,@RequestParam(required = true,defaultValue = "/filemanagement/customer/addCustomer.html") String path){
        //三级联动
        List<AddressPojo> address=addressServices.getArea(parentID);
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("addresses",address);
        return mv;
    }


    @PostMapping("/insert.html")
    public String insertSelective(CustomerInfoPojo customerInfoPojo,@RequestParam("fileForPhoto") MultipartFile fileForPhoto){
        String path="";
        if(!fileForPhoto.isEmpty()){
            try {
               path= fileServices.upload(fileForPhoto,"");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        customerInfoPojo.setcPhoto(path);
        customerServices.insertOneCustomer(customerInfoPojo);
        return "forward:/customer/customer.html";
    }


    /*
    删除
     */
    @RequestMapping("/delete.html")
    @ResponseBody
    public boolean deleteBySId(Integer id){
        return customerServices.deleteById(id);
    }



    /**
     * 通过id查询一条数据
     */
    @RequestMapping("/getOneForAlter")
    public ModelAndView getOneCustomer(Integer id,String parentID,@RequestParam(required = true,defaultValue = "/filemanagement/customer/alterCustomer.html") String path){
        CustomerInfoPojo oneCustomer=customerServices.getOneCustomer(id);
        List<AddressPojo> address=addressServices.getArea(parentID);
        ModelAndView mv = new ModelAndView(path);
        mv.addObject("oneCustomer",oneCustomer);
        mv.addObject("addresses",address);
        return mv;
    }

    /**
     * 通过id值修改一条数据
     */
    @RequestMapping("/alter.html")
    public String alterOneCustomer(CustomerInfoPojo customerInfoPojo,@RequestParam("fileForPhoto") MultipartFile fileForPhoto){
        String path="";
        if(!fileForPhoto.isEmpty()){
            try {
                path= fileServices.upload(fileForPhoto,"");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        customerInfoPojo.setcPhoto(path);
        customerServices.updateById(customerInfoPojo);
        return "forward:/customer/customer.html";
    }
}
