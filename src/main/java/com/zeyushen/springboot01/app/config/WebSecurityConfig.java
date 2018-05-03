package com.zeyushen.springboot01.app.config;

import com.zeyushen.springboot01.app.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.security.provider.MD5;

/**
 * @author 董文强
 * @Time 2018/5/3 14:12
 */
@Configuration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    UserServices userService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("登录拦截设置");
        http.authorizeRequests()
                .antMatchers(
                        /*不拦截的页面*/
                        "/file/img/**", "/fonts/**.**", "error/**",
                        "/css/**", "/js/**",
                         "/favicon.ico"
                ).permitAll()
                .anyRequest().authenticated()
                .and().formLogin()/*.loginPage("/login.html")*/
                .loginProcessingUrl("/login").passwordParameter("password").usernameParameter("username")
                .permitAll()
                .defaultSuccessUrl("/").permitAll()
                .and().logout().logoutSuccessUrl("/").permitAll().and();
        http.csrf().disable();


    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    //设置登录规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder).init(auth );


    }
}
