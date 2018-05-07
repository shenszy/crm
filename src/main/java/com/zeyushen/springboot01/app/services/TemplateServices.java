package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.ContractTemplatePojoMapper;
import com.zeyushen.springboot01.app.model.ContractTemplatePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("templateServices")
public class TemplateServices {
    @Autowired
    public ContractTemplatePojoMapper templatePojoMapper;

    public List<ContractTemplatePojo> getTemplateByTerm(String ctName){
        if(ctName==null||ctName.isEmpty()){
            ctName="";
        }
        return templatePojoMapper.getTemplateByTerm(ctName,ctName);
    }

    public boolean insertSelective(ContractTemplatePojo templatePojo){return templatePojoMapper.insertSelective(templatePojo)==1;}

    public boolean deleteById(Integer id){return templatePojoMapper.deleteById(id)==1;}
}
