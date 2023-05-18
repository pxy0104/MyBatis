package com.pxy.mybatis.mapper;

import com.pxy.mybatis.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 按id查询
     */
    Student getStudentById(@Param("id") int id);
    /**
     * 查询所有人员 利用集合
     */
    List<Student> getAllStudent();

    /**
     *  查询结果数量count
     */
    int getCount();

    /**
     * 查询Student 返回map集合
     */
    Map<String,Object> getStudentByIdToMap(@Param("id") int id);
    /**
     * 查询所有Student 返回map集合
     */
    //List<Map<String,Object>> getAllStudentToMap();
    @MapKey("id")
    List<Map<String,Object>> getAllStudentToMap();
}
