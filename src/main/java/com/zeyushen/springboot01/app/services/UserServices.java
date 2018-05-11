package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.UserMapper;
import com.zeyushen.springboot01.app.model.StaffPojo;
import com.zeyushen.springboot01.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private StaffServices staffServices;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("用户登录： {}", username);
        User user;
        try {
            user = userMapper.selectByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("用户登录异常");
            }
            if (user.getuName() == null || user.getuName().isEmpty()) {
                throw new UsernameNotFoundException("用户登录异常");
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("用户名不正确");
        }
        return user;
    }


    public String getName(String userName) {
        User user = userMapper.selectByUserName(userName);
        if (user == null) return null;
        return staffServices.selectBySId(user.getsId()).getsTname();
    }

    public Integer getSId(String userName){
        User user = userMapper.selectByUserName(userName);
        return user.getsId();
    }

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        List<User> users = userMapper.getAll();
        users.forEach(user -> {
            Map<String, Object> u = new HashMap<>();
            mapList.add(u);

            u.put("userName", user.getuName());
            u.put("uId", user.getuId());
            u.put("userRole", user.getuRole());
            StaffPojo staffPojo = staffServices.selectBySId(user.getsId());
            u.put("name", staffPojo.getsTname());
            u.put("address", staffPojo.gettAddress());
            u.put("phone", staffPojo.gettPhone());

        });

        return mapList;
    }

    public boolean addUser(User user) {
        if (user == null) {
            return false;
        }
        if (user.getuName() == null || user.getuName().isEmpty()) {
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty() || user.getPassword().length() < 4) {
            return false;
        }
        if (user.getsId() == null || user.getuRole() == null || user.getuRole().isEmpty()) {
            return false;
        }
        user.setuPassword(passwordEncoder.encode(user.getPassword()));
        try {
            if (userMapper.insert(user) == 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public User getUser(Integer id) {
        return  userMapper.selectByPrimaryKey(id);
    }

    public boolean alert(User user) {
        if (user == null || user.getuId() == null) {
            return false;
        }
        if (user.getuName() == null || user.getuName().isEmpty()) {
            return false;
        }
        if (user.getPassword() == null || user.getPassword().isEmpty() || user.getPassword().length() < 3) {
            return false;
        }
        if (user.getsId() == null || user.getuRole() == null || user.getuRole().isEmpty()) {
            return false;
        }
        user.setuPassword(passwordEncoder.encode(user.getPassword()));
        try {
            if(userMapper.updateByPrimaryKeySelective(user) == 1){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
