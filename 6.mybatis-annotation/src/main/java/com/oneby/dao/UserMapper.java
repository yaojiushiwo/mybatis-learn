package com.oneby.dao;

import com.oneby.domain.User;
import org.apache.ibatis.annotations.*;

import java.io.IOException;
import java.util.List;

/**
 * @InterfaceName UserMapper
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/14 10:06
 * @Version 1.0
 */
public interface UserMapper {

    @Insert("insert into t_user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("update t_user set username=#{username},password=#{password} where id=#{id}")
    public void update(User user);

    @Delete("delete from t_user where id=#{id}")
    public void delete(int id);

    @Select("select * from t_user where id=#{id}")
    public User findById(int id);

    @Select("select * from t_user")
    public List<User> findAll();

    @Select("select * from t_user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    column = "id",
                    property = "orderList",
                    javaType = List.class,
                    many = @Many(select = "com.oneby.dao.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrderAll();


    @Select("SELECT * FROM t_user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.oneby.dao.RoleMapper.findByUid")
            )
    })
    public List<User> findUserAndRoleAll();

}
