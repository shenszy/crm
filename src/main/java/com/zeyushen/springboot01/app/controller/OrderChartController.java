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

import java.util.List;
import java.util.Map;

/**
 * @author 董文强
 * @Time 2018/5/11 14:46
 */
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
    @GetMapping
    @ResponseBody
    public List<Map<String, Object>> getAllStaffSale() {
        //TODO
        /*
        SELECT t.`s_id`,s_tname,mpney , profit ,num
	        FROM ( SELECT s_id ,SUM(o_money) AS mpney ,SUM(o_gprofit)  AS profit,COUNT(*)
		        AS num FROM t_orderinfo GROUP BY s_id) AS o ,
	        t_staff AS t
        WHERE o.s_id=t.s_id

        * */
        return null;
    }


    /**
     * 根据员工ID获取销售数据
     */
    @GetMapping
    @ResponseBody
    public List<Map<String, Object>> getAllSaleByStaff(Integer id) {
        //TODO
        return null;
    }


    /**
     * 获取所有产品销售数据
     */
    @GetMapping
    @ResponseBody
    public List<Map<String, Object>> getAllProductSale() {
        //TODO
        return null;
    }

    /**
     * 根据产品ID获取销售数据
     */
    @GetMapping
    @ResponseBody
    public List<Map<String, Object>> getAllSaleByProduct(Integer id) {
        //TODO
        return null;
    }
}
