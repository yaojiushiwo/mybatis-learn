package com.oneby.dao;

import com.oneby.domain.Order;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/16 23:24
 * @Version 1.0
 */
public interface OrderMapper {

    //查询全部的方法
    public List<Order> findAll();

}
