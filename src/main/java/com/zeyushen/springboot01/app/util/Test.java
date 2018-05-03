package com.zeyushen.springboot01.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

/**
 * @author 董文强
 * @Time 2018/5/3 15:10
 */
public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(7);
        String password = passwordEncoder.encode("12121223");
        System.out.println(password);
        password = passwordEncoder.encode("123");
        System.out.println(password);
        System.err.println(passwordEncoder.matches("123",password));
        password = passwordEncoder.encode("asbcwdfweifw");
        System.out.println(password);
        password = passwordEncoder.encode("dongwenqiang19951018");
        System.out.println(password);
    }
}
