package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.model.GoodsPojo;
import com.zeyushen.springboot01.app.model.OrderInfoPojo;
import com.zeyushen.springboot01.app.model.PactInfoPojo;
import com.zeyushen.springboot01.app.services.GoodsService;
import com.zeyushen.springboot01.app.services.OrderServices;
import com.zeyushen.springboot01.app.services.UserServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderServices orderServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/add.html")
    public ModelAndView addOrder(@RequestParam(required = true, defaultValue = "") String gId,
                                 @RequestParam(required = true, defaultValue = "") String cId, Principal user) {

        ModelAndView mv = new ModelAndView("/order/add");
        List<GoodsPojo> product = orderServices.getProduct();
        mv.addObject("product", product);
        List<CustomerInfoPojo> customer = orderServices.getCustomer();
        mv.addObject("customer", customer);
        List<PactInfoPojo> pact = orderServices.getPact();
        mv.addObject("pact", pact);
        mv.addObject("gId", gId);
        mv.addObject("cId", cId);
        mv.addObject("orderCreator", userServices.getName(user.getName()));
        mv.addObject("sId",userServices.getSId(user.getName()));
        return mv;
    }

    @PostMapping("/add")
    @ResponseBody
    public boolean addOrder(OrderInfoPojo order, @RequestParam("addTime") String addTime,@RequestParam("executeTime") String executeTime) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date addToDate=null;
        Date execToDate=null;
        try {
            addToDate=sdf.parse(addTime);
            execToDate=sdf.parse(executeTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setoAddtime(addToDate);
        order.setoExecutetime(execToDate);
        return  orderServices.insert(order);

    }

    @GetMapping("/selectPrice")
    @ResponseBody
    public GoodsPojo selectPrice(String gId) {
        LOGGER.info(gId);
        GoodsPojo goodsPojo = goodsService.getById(gId);
        return goodsPojo;
        // return;
    }

    @RequestMapping("/order.html")
    public ModelAndView getMyOrder(Principal user,
                                   @RequestParam(defaultValue = "false") Boolean onlyData,
                                   @RequestParam(defaultValue = "1") Integer pageNum){
        ModelAndView mv=new ModelAndView("/order/order");
        PagingUtil.paging("myOrder", mv, pageNum, onlyData, () ->orderServices.getMyOrder(user));
        return mv;
    }

}
