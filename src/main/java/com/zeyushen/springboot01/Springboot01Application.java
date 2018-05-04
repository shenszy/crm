package com.zeyushen.springboot01;

import com.zeyushen.springboot01.app.config.WebSecurityConfig;
import com.zeyushen.springboot01.app.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.zeyushen.springboot01.app.mapper")
@Controller
public class Springboot01Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Springboot01Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

    @RequestMapping("/")
    public ModelAndView index(UsernamePasswordAuthenticationToken user, HttpSession session){
       if(user == null){
           LOGGER.info("用户未登录，无法访问主页");
           return new ModelAndView("redirect:/login.html");
       }
       else{
           ModelAndView mv =  new ModelAndView("/index");
           mv.addObject("username",user.getName());
           User a = (User) user.getPrincipal();
           session.setAttribute("sId",a.getsId());
           session.setAttribute("uId",a.getuId());
           return mv;
       }
    }
    @RequestMapping("/login.html")
    public String login(){
        return "/login";

    }
}
