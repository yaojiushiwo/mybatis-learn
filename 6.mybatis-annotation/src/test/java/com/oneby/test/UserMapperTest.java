package com.oneby.test;

import com.oneby.dao.OrderMapper;
import com.oneby.dao.UserMapper;
import com.oneby.domain.Order;
import com.oneby.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/31 22:47
 * @Version 1.0
 */
public class UserMapperTest {

    private SqlSession sqlSession;

    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    @Ignore
    public void testFindById() {
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    @Test
    @Ignore
    public void findUserAndOrderAll() {
        List<User> users = userMapper.findUserAndOrderAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    @Ignore
    public void findUserAndRoleAll() {
        List<User> users = userMapper.findUserAndRoleAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    @After
    public void after(){
        sqlSession.close();
    }

}
