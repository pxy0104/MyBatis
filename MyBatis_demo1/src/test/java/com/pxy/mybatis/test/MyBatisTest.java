package com.pxy.mybatis.test;

import com.ibatis.common.resources.Resources;
import com.pxy.mybatis.mapper.StudentMapper;
import com.pxy.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

//        import org.apache.ibatis.io.Resources;

public class MyBatisTest {
    @Test
    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int result = mapper.insertStudent();
//        sqlSession.commit();
        System.out.println("result" + result);


    }

    @Test
    public void testSelect() throws IOException {
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");

//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int result = mapper.updateStudent(6, "Zhao6");
        System.out.println(result);
//        mapper.deleteStudent();
//        Student student = mapper.getUserById();
//        System.out.println(student);
//        List<Student> allStudent = mapper.getAllStudent();
//        allStudent.forEach(student -> System.out.println(student));
    }

    /**
     * 修改Update数据库
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");

//      SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.updateStudent(9,"裴旭阳");
    }

    /**
     * 按id查询数据库信息
     * @throws IOException
     */
    @Test
    public void testGetbyId() throws IOException {
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");

//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getUserById();
        System.out.println(student);
    }

}
