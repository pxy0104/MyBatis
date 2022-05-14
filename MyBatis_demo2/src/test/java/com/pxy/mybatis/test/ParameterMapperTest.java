package com.pxy.mybatis.test;

import com.pxy.mybatis.mapper.ParameterMapper;
import com.pxy.mybatis.pojo.Student;
import com.pxy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {
    /**
     * MyBatis获取参数的两种方式 ${}  #{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     */
//    单参数   多参数arg0 arg1 param1 param2    map传参数   mapper接口的实体类类型的参数   @Param传参数

    /**
     * 使用@Param注解参数
     * @Param("值") 注解的值 通过#{} ${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 以注解的值为键，以参数为值
     * 以param1，param2...为键，以参数为值
     * 注解传参数
     * @param
     */
    @Test
    public void testCheckLoginByParam() {
//        @Param传参数
        //获得SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        Student student = mapper.checkLoginByParam(11, "熊广兴");
        if(student != null){

            System.out.println("已找到，可以进行登录");
        }else {
            System.out.println("未找到");

        }

        System.out.println(student);
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
//        mapper接口的实体类类型的参数
        int result = mapper.insertStudent(new Student(0, "JiJi", '女', 19));
        System.out.println(result);
    }

    //    单参数
    @Test
    public void testGetStudentByStudentname() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Student student = mapper.getStudentByStudentname("李白");
        System.out.println(student);
    }

    //    多参数arg0 arg1 param1 param2
    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Student student = mapper.checkLogin(1, "张飞");
        System.out.println(student);
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
//        map传参数
//        利用map时 键值对中的键要和mapper.xml标签中的#{键}一致
        map.put("id", 1);
        map.put("studentname", "张飞");
        Student student = mapper.checkLoginByMap(map);
        System.out.println(student);
    }

    @Test
    public void testGetAllStudent() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<Student> list = mapper.getAllStudent();

        list.forEach(student -> System.out.println(student));

    }

    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
        //字符串拼接
//        PreparedStatement preparedStatement = connection.prepareStatement("");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?");
        String id = "2";
        preparedStatement.setString(1, id);
    }



}
