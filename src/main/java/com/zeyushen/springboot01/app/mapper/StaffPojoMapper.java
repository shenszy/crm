package com.zeyushen.springboot01.app.mapper;

import com.zeyushen.springboot01.app.model.StaffPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffPojoMapper {
    public int insert(StaffPojo record);

    public int updateByPrimaryKey(StaffPojo record);

    //用到的方法
    public List<StaffPojo> getAllStaff();

    public int insertSelective(StaffPojo staffPojo);

    public int deleteBySId(Integer sId);

    public StaffPojo selectBySId(Integer sId);

    public int updateBySId(StaffPojo record);

    public List<StaffPojo> getStaffByTerm(@Param("sName") String sName, @Param("spell") String spell, @Param("dId") Integer dId);
}