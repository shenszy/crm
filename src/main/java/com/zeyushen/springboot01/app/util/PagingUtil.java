package com.zeyushen.springboot01.app.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class PagingUtil {

    public static Boolean paging(String resultName, ModelAndView mv,Integer pageNum,Boolean onlyData,String path,SelectList selectList){
        if (pageNum <= 0) {
            pageNum = 1;
        }
        try {
            Page page = PageHelper.startPage(pageNum, 10);
            List list = selectList.run();
            if (pageNum > page.getPages()) {
                pageNum = page.getPages();
                page = PageHelper.startPage(pageNum, 10);
                list = selectList.run();
            }
            if (onlyData) {
                mv.setViewName(path);
            }
            mv.addObject(resultName, list);
            mv.addObject("total", page.getTotal());
            mv.addObject("pages", page.getPages());
            mv.addObject("pageNum", pageNum);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @FunctionalInterface
    public interface SelectList {
        List run();
    }
}
