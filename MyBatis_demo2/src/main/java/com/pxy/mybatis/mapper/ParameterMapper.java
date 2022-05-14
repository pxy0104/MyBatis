package com.pxy.mybatis.mapper;

import com.pxy.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ParameterMapper {
    /**
     * 添加学生信息
     */
    int insertStudent(Student student);

    /**
     * 验证登录使用@param 传参数
     * 只需要id和学生姓名
     */
    Student checkLoginByParam(@Param("id") int id, @Param("studentname") String studentname);

    /**
     * 验证登录 map参数
     */
    Student checkLoginByMap(Map<String, Object> map);

    /**
     * 验证登录
     */
    Student checkLogin(int id, String studentname);

    /**
     * 根据名字查询信息
     */
    Student getStudentByStudentname(String studentname);

    /**
     * 查询所有员工
     */
    List<Student> getAllStudent();


}
