package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.DepInfoPojo;
import com.zeyushen.springboot01.app.services.GoodsService;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods.html")
    public ModelAndView getGoodsAll(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = true,defaultValue = "false") Boolean onlyData) {


        ModelAndView mv = new ModelAndView("/filemanagement/goods/goods");
        String path="/filemanagement/goods/goods ::#table_paging";
        PagingUtil.paging("allGoods",mv,pageNum,onlyData,path, goodsService::getAllGoods);

        return mv;
    }

    @RequestMapping("/addGoods.html")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("/filemanagement/goods/addGoods");
        return mv;
    }


}
