package com.zeyushen.springboot01;

import com.zeyushen.springboot01.app.mapper.DepInfoPojoMapper;
import com.zeyushen.springboot01.app.model.DepInfoPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01ApplicationTests {



    @Test
    public void contextLoads() {
        System.out.println("spring boot 测试");
    }


}
