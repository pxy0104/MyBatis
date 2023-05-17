package com.pxy.mybatis.mapper;

import com.pxy.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     * 添加用户信息
     */
    int insertStudent();

    /**
     * 删除一个用户信息
     */
    int deleteStudent();

    /**
     * 修改用户信息
     */
    int updateStudent(@Param("id") int id,@Param("name") String name);
    /**
     * 根据ID查询
     */
    Student getStudentById(@Param("id") int id);

    /**
     * 查询所有用户信息
     */
    List<Student> getAllStudent();
}
