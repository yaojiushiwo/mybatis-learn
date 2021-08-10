package com.oneby.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oneby.dao.OrderMapper;
import com.oneby.dao.UserMapper;
import com.oneby.domain.Order;
import com.oneby.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/13 10:09
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    @Ignore
    public void testOne2One() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 OrderMapper 接口的实现类
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        // 测试 findAll() 方法
        List<Order> all = orderMapper.findAll();
        for (Order order : all) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void testOne2Many() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 UserMapper 接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 测试 findAll() 方法
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    @Ignore
    public void testMany2Many() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 UserMapper 接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 测试 findUserAndRoleAll() 方法
        List<User> all = userMapper.findUserAndRoleAll();
        for (User user : all) {
            System.out.println(user);
        }
        sqlSession.close();
    }

}
