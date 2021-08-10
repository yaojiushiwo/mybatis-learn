package com.oneby.test;

import com.oneby.dao.OrderMapper;
import com.oneby.dao.UserMapper;
import com.oneby.domain.Order;
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
 * @ClassName OrderMapperTest
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/31 22:34
 * @Version 1.0
 */
public class OrderMapperTest {

    private SqlSession sqlSession;

    private OrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void testFindByUid() {
        List<Order> orders = orderMapper.findByUid(3);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    @Ignore
    public void testFindAll() {
        List<Order> all = orderMapper.findAll();
        for (Order order : all) {
            System.out.println(order);
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }

}
