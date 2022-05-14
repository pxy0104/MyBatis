package com.pxy.mybatis.mapper;

import com.pxy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * 动态查询（if）
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose、when、otherwise
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);
    /**
     * 通过数组实现批量删除
     *
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);
}
