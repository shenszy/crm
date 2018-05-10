package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.model.PactInfoPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("/pactServices")
public class PactServices {
    @Autowired
    public PactInfoPojo pactInfoPojo;
}
