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

    @Test
    public void testCheckLoginByParam() {
        //@Param传参数
        //获得SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //获取mapper接口对象
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Student student = mapper.checkLoginByParam(1, "张三");
        if(student != null){
            System.out.println("已找到，可以进行登录");
        }else {
            System.out.println("未找到");
        }
        System.out.println(student);
    }
    //实体类类型
    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        //mapper接口的实体类类型的参数
        int result = mapper.insertStudent(new Student(0, "赵六", '女', 19));
        System.out.println(result);
    }

    //单参数
    @Test
    public void testGetStudentByName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Student student = mapper.getStudentByName("赵六");
        System.out.println(student);
    }

    //多参数arg0 arg1 param1 param2
    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Student student = mapper.checkLogin(1, "张三");
        System.out.println(student);
    }

    //自定义map传值
    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        //map传参数
        //利用map时 键值对中的键要和mapper.xml标签中的#{键}一致
        map.put("id", 1);
        map.put("name", "张三");
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
        //PreparedStatement preparedStatement = connection.prepareStatement("");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student where id = ?");
        String id = "2";
        preparedStatement.setString(1, id);
    }
}
