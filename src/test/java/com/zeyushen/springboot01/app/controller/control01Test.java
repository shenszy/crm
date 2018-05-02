package com.zeyushen.springboot01.app.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest

public class control01Test {

    private MockMvc mockMvc;
    //初始化工作
    @Before
    public void setUp() throws Exception {
        //独立安装测试
       // mockMvc=MockMvcBuilders.standaloneSetup(new control01()).build();
    }

    @Test
    public void method01() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/method01").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("Hello World!")));
    }
}