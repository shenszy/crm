package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.model.DepInfoPojo;
import com.zeyushen.springboot01.app.model.GoodsPojo;
import com.zeyushen.springboot01.app.services.GoodsService;
import com.zeyushen.springboot01.app.util.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/goods")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class GoodsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods.html")
    public ModelAndView getGoodsAll(@RequestParam(required = true, defaultValue = "1") Integer pageNum,
                                    @RequestParam(required = true,defaultValue = "false") Boolean onlyData) {


        ModelAndView mv = new ModelAndView("/filemanagement/goods/goods");
        PagingUtil.paging("allGoods",mv,pageNum,onlyData,goodsService::getAllGoods);

        return mv;
    }

    @RequestMapping("/addGoods.html")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView("/filemanagement/goods/addGoods");
        return mv;
    }


    @RequestMapping("/addGoods")
    @ResponseBody
    public boolean add(GoodsPojo goodsPojo) {
        return  goodsService.add(goodsPojo);
    }


    @PostMapping("/elsedeGoods")
    @ResponseBody
    public boolean delete(String gId) {

        return  goodsService.delete(gId);
    }

    @GetMapping("/update.html")
    public ModelAndView update(String id) {
        ModelAndView mv = new ModelAndView("/filemanagement/goods/update");
        GoodsPojo goodsPojo= goodsService.getById(id);
        mv.addObject("goods",goodsPojo);
        return mv;
    }
    @PostMapping("/update")
    @ResponseBody
    public boolean update(GoodsPojo goodsPojo) {

        return  goodsService.update(goodsPojo);
        //return  false;
    }

}
