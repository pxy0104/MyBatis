package com.pxy.mybatis.test;

import com.pxy.mybatis.mapper.SQLMapper;
import com.pxy.mybatis.pojo.Student;
import com.pxy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {
    @Test
    public void testGetStudentByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<Student> list = mapper.getStudentByLike("a");
        System.out.println(list);
    }

    @Test
    public void testDeleteMore() {
        //批量删除时,要用${}
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        Integer result = mapper.deleteMore("6,8,9");
        System.out.println(result);
    }

    //动态表名查询
    @Test
    public void testGetStudentByTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<Student> list = mapper.getStudentByTableName("student");
        System.out.println(list);
        list.forEach(System.out::println);
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        Student student = new Student(0, "LiMing", '女', 17);
        mapper.insertStudent(student);
    }
}