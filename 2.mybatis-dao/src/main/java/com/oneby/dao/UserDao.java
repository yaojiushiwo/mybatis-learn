package com.oneby.dao;

import com.oneby.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @InterfaceName UserDao
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/14 10:01
 * @Version 1.0
 */
public interface UserDao {

    List<User> findAll() throws IOException;

}
