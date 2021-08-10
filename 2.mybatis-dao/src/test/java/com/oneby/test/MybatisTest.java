package com.oneby.test;

import com.oneby.dao.UserMapper;
import com.oneby.dao.impl.UserDaoImpl;
import com.oneby.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/13 10:09
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    // 测试传统开发方式
    public void testTradition() throws IOException {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        System.out.println(all);
    }

    @Test
    // 测试代理开发方式
    public void testProxy() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 UserMapper 接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 测试 findAll() 方法
        List<User> all = userMapper.findAll();
        System.out.println(all);
        // 测试 findAll() 方法
        User user = userMapper.findById(1);
        System.out.println(user);
        sqlSession.close();
    }

}
