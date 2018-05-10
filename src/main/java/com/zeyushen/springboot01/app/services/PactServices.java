package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.ContractTemplatePojoMapper;
import com.zeyushen.springboot01.app.mapper.CustomerInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.PactInfoPojoMapper;
import com.zeyushen.springboot01.app.mapper.PactMapper;
import com.zeyushen.springboot01.app.model.ContractTemplatePojo;
import com.zeyushen.springboot01.app.model.CustomerInfoPojo;
import com.zeyushen.springboot01.app.model.PactInfoPojo;
import com.zeyushen.springboot01.app.model.PactPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("/pactServices")
public class PactServices {
    @Autowired
    private PactInfoPojoMapper pactInfoPojoMapper;
    @Autowired
    private PactMapper pactMapper;
    @Autowired
    private CustomerInfoPojoMapper customerInfoPojoMapper;
    @Autowired
    private ContractTemplatePojoMapper templatePojoMapper;

    public List<PactPojo> getPactByTerm(String pTitle,String execStatus){
        if(pTitle==null||pTitle.isEmpty()){
            pTitle="";
        }
        if(execStatus==null||execStatus.isEmpty()){
            execStatus=null;
        }
        return pactMapper.getPactByTerm(pTitle,pTitle,execStatus);
    }

    public boolean insert(PactInfoPojo pactInfoPojo){return pactInfoPojoMapper.insert(pactInfoPojo)==1;}

    public List<CustomerInfoPojo> getCustomer(){return customerInfoPojoMapper.getAllCustomer();}

    public List<ContractTemplatePojo> getTemplate(){return templatePojoMapper.getTemplateByTerm("","");}

    public PactInfoPojo selectById(Integer id){return pactInfoPojoMapper.selectById(id);}

    public boolean updateById(PactInfoPojo pactInfoPojo){return pactInfoPojoMapper.updateById(pactInfoPojo)==1;}
}
