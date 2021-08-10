package com.oneby.test;

import com.oneby.dao.UserMapper;
import com.oneby.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    // 测试动态 SQL 之 <if>
    public void testIf() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 UserMapper 接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 测试 findByCondition() 方法
        User condition = new User();
        condition.setId(1);
        condition.setUsername("张三");
        List<User> usersByCondition = userMapper.findByCondition(condition);
        System.out.println(usersByCondition);
        // 测试 findByCondition() 方法
        condition = new User();
        condition.setUsername("Heygo");
        condition.setPassword("Heygogo");
        usersByCondition = userMapper.findByCondition(condition);
        System.out.println(usersByCondition);
        // 测试 findByCondition() 方法
        condition = new User();
        usersByCondition = userMapper.findByCondition(condition);
        System.out.println(usersByCondition);
        sqlSession.close();
    }

    @Test
    @Ignore
    // 测试动态 SQL 之 <foreach>
    public void testForeach() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 UserMapper 接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 测试 findByIds() 方法
        List<User> usersByIds = userMapper.findByIds(Arrays.asList(1, 2, 5));
        System.out.println(usersByIds);
        // 测试 findByCondition() 方法
        usersByIds = userMapper.findByIds(Arrays.asList(3, 4));
        System.out.println(usersByIds);
        // 测试 findByCondition() 方法
        usersByIds = userMapper.findByIds(Arrays.<Integer>asList());
        System.out.println(usersByIds);
        sqlSession.close();
    }


}
