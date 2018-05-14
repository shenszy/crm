package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.services.OrderServices;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/order/auditOrder")
public class AuditOrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditOrderController.class);

    @Autowired
    OrderServices orderServices;

    @RequestMapping("/audited.html")
    public ModelAndView audited(@RequestParam(defaultValue = "1") Integer pageNum,
                                @RequestParam(defaultValue = "false") Boolean onlyData) {

        ModelAndView mv = new ModelAndView("/order/auditOrder/audited.html");

        PagingUtil.paging("allGoods", mv, pageNum, onlyData, null);

        return mv;
    }

    @RequestMapping("/unaudited.html")
    public ModelAndView unaudited(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "false") Boolean onlyData) {

        ModelAndView mv = new ModelAndView("/order/auditOrder/unaudited.html");

        PagingUtil.paging("allGoods", mv, pageNum, onlyData, null);

        return mv;
    }

}
