import com.pxy.mybatis.mapper.DynamicSQLMapper;
import com.pxy.mybatis.pojo.Emp;
import com.pxy.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DynamicSQLMapperTest {
    /**
     * 动态SQL:
     * 1.if:根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL
     * 2.where:
     * 当where标签中有内容时，会自动生成where关键字，并且将内容前多余关键字去掉
     * 当where标签中没有内容时，此时where标签没有任何效果
     * 注意：where标签不能将其中内容后多余的and或or去掉
     * 3.trim：
     * 若标签中有内容时：
     * prefix|suffix:将trim标签中内容前面或后面添加内容
     * suffixOverrides|prefixOverrides:将trim标签中内容后面或前面去掉指定内容
     * 若标签中没有内容时，trim标签也没有任何效果
     * 4.choose、when、otherwise,相当于java中的if .... else if .... else
     * when至少要有一个，otherwise至多要有一个
     * 5.foreach
     */
    @Test
    public void testInsertMoreByList() {
        Emp emp = new Emp(null, "test", 18, "男", "123");
        Emp emp1 = new Emp(null, "test", 18, "男", "123");
        Emp emp2 = new Emp(null, "test", 18, "男", "123");
        ArrayList<Emp> list = new ArrayList<>();
        list.add(emp);
        list.add(emp1);
        list.add(emp2);
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = mapper.insertMoreByList(list);
        System.out.println(i);
    }
    @Test
    public void testDeleteMoreByArray() {
        Integer arr[] = {5,6,7,8};
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int deleteMoreByArray = mapper.deleteMoreByArray(arr);
        System.out.println(deleteMoreByArray);
    }
    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emp = mapper.getEmpByChoose(new Emp(null, "张三", 13, "男", ""));
        System.out.println(emp);
    }


    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emp = mapper.getEmpByCondition(new Emp(null, null, null, null, ""));
        System.out.println(emp);
    }
}
