package com.oneby.dao;

import com.oneby.domain.Order;
import com.oneby.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/16 23:24
 * @Version 1.0
 */
public interface OrderMapper {

    @Select("select * from t_order where uid=#{uid}")
    public List<Order> findByUid(int uid);

    /*@Select("select *, o.id oid from t_order o, t_user u where o.uid = u.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            // 通过级联属性的方式为 private User user 字段赋值
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password")
    })
    public List<Order> findAll();*/

    @Select("select * from t_order") // 首先查询 t_order 表
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    column = "uid", // 根据哪个字段去查询 user 表的数据
                    property = "user", // 要封装的属性名称
                    javaType = User.class, // 要封装的实体类型
                    //select属性代表查询哪个接口的方法获得数据
                    one = @One(select = "com.oneby.dao.UserMapper.findById")
            )
    })
    public List<Order> findAll();

}
