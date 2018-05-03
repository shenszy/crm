package com.zeyushen.springboot01;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@SpringBootApplication
@MapperScan("com.zeyushen.springboot01.app.mapper")
@Controller
public class Springboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, Principal user){
       if(user == null){
           return new ModelAndView("redirect:/login");
       }
       else{
           return new ModelAndView("/index");
       }
    }
}
