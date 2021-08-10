package com.oneby.dao;

import com.oneby.domain.User;

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

    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);

}
