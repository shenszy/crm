package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.services.GoodsService;
import com.zeyushen.springboot01.app.services.OrderServices;
import com.zeyushen.springboot01.app.services.StaffServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/orderChart")
public class OrderChartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderChartController.class);

    @Autowired
    private OrderServices orderServices;
    @Autowired
    private StaffServices staffServices;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/productChart.html")
    public ModelAndView productChart() {
        ModelAndView mv = new ModelAndView("/orderChartStatistics/productChart");
        mv.addObject("goodsList", goodsService.getGoodeByTerm(null, null, null));
        return mv;
    }

    @RequestMapping("/staffChart.html")
    public ModelAndView staffChart() {
        ModelAndView mv = new ModelAndView("/orderChartStatistics/staffChart");
        mv.addObject("staffList", staffServices.getAllStaff());
        return mv;
    }

    /**
     * 获取所有元工的销售数据
     */
    @GetMapping("/getAllStaffSale")
    @ResponseBody
    public List<List<Object>> getAllStaffSale(Integer year) {
        List<List<Object>> mapList = new ArrayList<>();
        orderServices.getAllStaffSale(year).forEach(v->{
            List<Object> l = new ArrayList<>();
            l.add(v.get("s_tname"));
            l.add(v.get("money"));
            mapList.add(l);
        });
        return  mapList;
    }
    /**
     * 获取所有元工的每月销售数据
     */
    @GetMapping("/getStaffSale")
    @ResponseBody
    public  List<Map> getStaffSale(Integer year) {
        Map<String,Double[]> stringMap = orderServices.getAllSaleEveryMonth(year);
        List<Map> mapArrayList= new ArrayList<>();
        stringMap.forEach((k,v)->{
            Map<String,Object> m  = new HashMap<>();
            mapArrayList.add(m);
            m.put("name",k);
            m.put("data",v);
        });
        return  mapArrayList;
    }

   /* *//**
     * 根据员工ID获取销售数据
     *//*
    @GetMapping("/getAllSaleByStaff")
    @ResponseBody
    public List<Map<String, Object>> getAllSaleByStaff(Integer id) {
        //TODO
        return orderServices.getAllSaleByStaff(id);
    }


    */
    /**
     * 获取所有产品销售数据
     */
    @GetMapping("/getAllProductSale")
    @ResponseBody
    public List<List<Object>> getAllProductSale(Integer year) {
        List<List<Object>> mapList = new ArrayList<>();
        orderServices.getAllProductSale(year).forEach(v->{
            List<Object> l = new ArrayList<>();
            l.add(v.get("name"));
            l.add(v.get("money"));
            mapList.add(l);
        });
        return  mapList;
    }

    /**
     * 获取所有产品每月销售数据
     */
    @GetMapping("/getAllProductMonthSale")
    @ResponseBody
    public List<Map>  getAllProductMonthSale(Integer year) {
        Map<String,Double[]> stringMap = orderServices.getAllProductEveryMonth(year);
        List<Map> productData= new ArrayList<>();
        stringMap.forEach((k,v)->{
            Map<String,Object> m  = new HashMap<>();
            productData.add(m);
            m.put("name",k);
            m.put("data",v);
        });
        return  productData;

    }

}
