package com.pxy.mybatis.mapper;

import com.pxy.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分步查询员工及员工对应的部门信息(第二步)
     *通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);
    /**
     * 获取部门以及部门中所有员工信息
     */
   Dept getDeptAndEmp(@Param("did") Integer did);


    /**
     *一对多查询  部门：员工
     * 通过分步查询部门及部门员工的信息
     * 第一步：查部门信息
     * @param did
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

}
