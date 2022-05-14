package com.pxy.mybatis.mapper;

import com.pxy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 查询所有员工信息
     */
    List<Emp> getAllEmp();
    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询员工及员工对应的部门信息(第一步)
     * 查询部门信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);


    /**
     * 一对多分步查询第二步：
     * 通过did查询部门中所有的员工
     *
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);

}
