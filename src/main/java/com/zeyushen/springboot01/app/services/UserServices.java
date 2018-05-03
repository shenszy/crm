package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.UserMapper;
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
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("用户登录： {}",username);
        User user ;
        try {
            user =userMapper.selectByUserName(username);
            if(user == null){
                throw new UsernameNotFoundException("用户登录异常");
            }
            if(user.getuName()==null||user.getuName().isEmpty()){
                throw new UsernameNotFoundException("用户登录异常");
            }
        }catch (Exception e){
            throw new UsernameNotFoundException("用户名不正确");
        }
        return user;
    }
}
