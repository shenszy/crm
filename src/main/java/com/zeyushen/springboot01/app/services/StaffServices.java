package com.zeyushen.springboot01.app.services;

import com.zeyushen.springboot01.app.mapper.StaffPojoMapper;
import com.zeyushen.springboot01.app.model.StaffPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staffServices")
public class StaffServices {
    @Autowired
    private StaffPojoMapper staffPojoMapper;

    public List<StaffPojo> getAllStaff(){return staffPojoMapper.getAllStaff();}

    public int insertSelective(StaffPojo staffPojo){return staffPojoMapper.insertSelective(staffPojo);}

    public int deleteBySId(Integer sId){return staffPojoMapper.deleteBySId(sId);}

    public StaffPojo selectBySId(Integer sId){return staffPojoMapper.selectBySId(sId);}

    public int updateBySId(StaffPojo staffPojo){return staffPojoMapper.updateBySId(staffPojo);}

    public List<StaffPojo> getStaffByTerm(String sName,String spell,Integer dId){return staffPojoMapper.getStaffByTerm(sName,spell,dId);}
}
