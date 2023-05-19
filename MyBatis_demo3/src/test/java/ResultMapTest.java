import com.pxy.mybatis.mapper.DeptMapper;
import com.pxy.mybatis.mapper.EmpMapper;
import com.pxy.mybatis.pojo.Dept;
import com.pxy.mybatis.pojo.Emp;
import com.pxy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    //字段与属性 名字不一致
    //1.通过起别名的方式,来保持和属性名一致  emp_name empName
    //2.设置全局配置,将下划线_自动映射为驼峰,emp_name:empName
    //3.通过resultMap设置自定义映射关系

    /**
     * 查询多对一处理方式
     * 1.级联属性赋值
     * 2.association标签来处理
     * 3.分步查询（特点：延迟加载lazyLoadingEnabled，提高代码复用性）
     */

    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
    }

    //多对一：分步查询
    @Test
    public void testGetEmpAndDeptByStepOne() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(empAndDept.getEmpName());
        System.out.println(empAndDept.getDept().toString());
    }



    /**
     * 处理一对多的映射关系：
     * 1.collection:
     *   ofType:表示该属性所对应的集合中存储数据的类型
     */
    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }
    //分步查询
    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(2);
        System.out.println(dept);
        //System.out.println(dept.getDeptName());
    }
}
