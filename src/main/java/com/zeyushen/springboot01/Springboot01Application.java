package com.zeyushen.springboot01;

import com.zeyushen.springboot01.app.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
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

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@SpringBootApplication
@MapperScan("com.zeyushen.springboot01.app.mapper")
@Controller
public class Springboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

    @RequestMapping("/")
    public ModelAndView index(Principal user, HttpServletRequest request, @RequestHeader Map map){
       if(user == null){
           return new ModelAndView("redirect:/login");
       }
       else{

           return new ModelAndView("/index");
       }
    }
}
