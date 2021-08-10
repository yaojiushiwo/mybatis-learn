package com.oneby.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    // 测试自定义类型转换器
    public void testTypeHandler() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 UserMapper 接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 测试 add() 方法是否能成功将 java 中的 Date 类型转换为 MySQL 中的 bigint 类型
        User user = new User();
        user.setUsername("OnebyWang");
        user.setPassword("root");
        user.setBirthday(new Date());
        userMapper.add(user);
        //手动提交事务
        sqlSession.commit();
        // 测试 findAll() 方法是否能成功将 MySQL 中的 bigint 类型转换为 java 中的 Date 类型
        List<User> all = userMapper.findAll();
        System.out.println(all);
        sqlSession.close();
    }

    @Test
    @Ignore
    // 测试 PageHelper 分页助手
    public void testPageHelper() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得 MyBatis 框架生成的 UserMapper 接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数：当前页+每页显示的条数
        PageHelper.startPage(2, 2);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示条数：" + pageInfo.getPageSize());
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("上一页：" + pageInfo.getPrePage());
        System.out.println("下一页：" + pageInfo.getNextPage());
        System.out.println("是否是第一个：" + pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个：" + pageInfo.isIsLastPage());

        sqlSession.close();
    }

}
