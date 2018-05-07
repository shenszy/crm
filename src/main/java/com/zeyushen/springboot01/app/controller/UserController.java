package com.zeyushen.springboot01.app.controller;

import com.zeyushen.springboot01.app.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.security.Principal;

/**
 * @author 董文强
 * @Time 2018/5/3 14:09
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServices userServices;


    @RequestMapping("/test")
    public ModelAndView lll(HttpServletRequest request, HttpSession session) {
        //request.
        ModelAndView mv = new ModelAndView("/");
        Principal user =  request.getUserPrincipal();
       LOGGER.info(request.getUserPrincipal().toString());
       LOGGER.info(user.getName());
        //request.getUserPrincipal()
        //   request.getUserPrincipal().getName(
        
        //userServices.loadUserByUsername();
        return mv;
    }
}
