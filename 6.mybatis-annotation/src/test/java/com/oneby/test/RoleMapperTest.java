package com.oneby.test;

import com.oneby.dao.OrderMapper;
import com.oneby.dao.RoleMapper;
import com.oneby.domain.Order;
import com.oneby.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName RoleMapperTest
 * @Description TODO
 * @Author Oneby
 * @Date 2021/4/2 8:07
 * @Version 1.0
 */
public class RoleMapperTest {

    private SqlSession sqlSession;

    private RoleMapper roleMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    @Test
    public void testFindByUid() {
        List<Role> roles = roleMapper.findByUid(1);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }

}
