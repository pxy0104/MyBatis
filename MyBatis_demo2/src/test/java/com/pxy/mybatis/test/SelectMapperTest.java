package com.pxy.mybatis.test;

import com.pxy.mybatis.mapper.SelectMapper;
import com.pxy.mybatis.pojo.Student;
import com.pxy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * SelectMapper接口测试
 */
public class SelectMapperTest {

    @Test
    public void testGetStudentById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Student student = mapper.getStudentById(2);
        System.out.println(student);
    }

    //查询所有Student
    @Test
    public void testGetAllStudent() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List list = mapper.getAllStudent();
        list.forEach(student -> System.out.println(student));
    }

    //int
    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetStudentByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map student= mapper.getStudentByIdToMap(2);
        System.out.println(student);
    }
    @Test
    public void testGetAllStudentToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        List<Map<String,Object>> list = mapper.getAllStudentToMap();

        System.out.println(mapper.getAllStudentToMap());
//        for (Map<String, Object> stringObjectMap : list) {
//            System.out.println(stringObjectMap);
//        }
//        list.forEach(System.out::println);
    }
}
