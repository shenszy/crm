package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 董文强
 * @Time 2018/5/3 14:15
 */
@Service
public class UserServices implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServices.class);
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("用户登录： {}",username);
        User user = new User();
        user.setuName(username);
        user.setuPassword(passwordEncoder.encode("123"));
        user.setuRole("大王");
        return user;
    }
}
