package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.model.GoodsPojo;
import com.zeyushen.springboot01.app.model.PactInfoPojo;
import com.zeyushen.springboot01.app.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServices orderServices;

    @RequestMapping("/add.html")
    public ModelAndView addOrder(@RequestParam(required = true,defaultValue = "") String gId,
                                 @RequestParam(required = true,defaultValue = "") String cId){
        ModelAndView mv=new ModelAndView("/order/add");
        List<GoodsPojo> product=orderServices.getProduct();
        mv.addObject("product",product);
        List<CustomerInfoPojo> customer=orderServices.getCustomer();
        mv.addObject("customer",customer);
        List<PactInfoPojo> pact=orderServices.getPact();
        mv.addObject("pact",pact);
        mv.addObject("gId",gId);
        mv.addObject("cId",cId);
        return mv;
    }

}
