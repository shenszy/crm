package com.zeyushen.springboot01.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 董文强
 * @Time 2018/5/11 14:46
 */
@Controller
@RequestMapping("/orderChart")
public class OrderChartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderChartController.class);


    @RequestMapping("/productChart.html")
    public ModelAndView productChart(){
        ModelAndView mv = new ModelAndView("/orderChartStatistics/productChart");

        return mv;
    }
    @RequestMapping("/staffChart.html")
    public ModelAndView staffChart(){
        ModelAndView mv = new ModelAndView("/orderChartStatistics/staffChart");
        return mv;
    }

  /*  @GetMapping
    @ResponseBody*/


}
