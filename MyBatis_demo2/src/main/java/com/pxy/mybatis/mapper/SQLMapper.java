package com.pxy.mybatis.mapper;

import com.pxy.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {
    /**
     * SQL模糊查询
     */
    List<Student> getStudentByLike(@Param("name") String name);

    /**
     * 批量删除
     */
    Integer deleteMore(@Param("ids") String ids);
    /**
     * 查询指定表中的数据
     * 动态设置表名
     */
    List<Student> getStudentByTableName(@Param("tableName") String tableName);
    /**
     * Insert Studnet
     * insert into student
     *         values (null, #{name}, #{gender}, #{age})
     */
    void insertStudent(Student student);
}
