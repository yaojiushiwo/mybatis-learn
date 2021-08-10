package com.oneby.test;

import com.oneby.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    @Ignore
    //查询操作
    public void Select() throws IOException {
        //加载 Mybatis 核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得 SqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询操作，参数为 namespace.id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();

        System.out.println("master test...");
    }

    @Test
    @Ignore
    //插入操作
    public void Insert() throws IOException {
        //加载 Mybatis 核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得 SqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行插入操作，参数为 namespace.id
        User user = new User();
        user.setId(1);
        user.setUsername("OnebyWang");
        user.setPassword("root");
        int insert = sqlSession.insert("userMapper.add", user);
        //手动提交事务
        sqlSession.commit();
        //打印数据
        System.out.println(insert);
        //释放资源
        sqlSession.close();
    }

    @Test
    @Ignore
    //插入操作
    public void Delete() throws IOException {
        //加载 Mybatis 核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得 SqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行删除操作，参数为 namespace.id
        int delete = sqlSession.delete("userMapper.delete", 333);
        //手动提交事务
        sqlSession.commit();
        //打印数据
        System.out.println(delete);
        //释放资源
        sqlSession.close();
    }

    @Test
    @Ignore
    //插入操作
    public void Update() throws IOException {
        //加载 Mybatis 核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获得 SqlSession 工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得 SqlSession 会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行更新操作，参数为 namespace.id
        User user = new User();
        user.setId(222);
        user.setUsername("yaozz");
        user.setPassword("yaozz");
        int update = sqlSession.update("userMapper.update", user);
        //手动提交事务
        sqlSession.commit();
        //打印数据
        System.out.println(update);
        //释放资源
        sqlSession.close();
    }


}
