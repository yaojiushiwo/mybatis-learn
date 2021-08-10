package com.oneby.domain;

import java.util.Date;
import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/13 10:05
 * @Version 1.0
 */
public class User {

    private int id;

    private String username;

    private String password;

    // 当前用户存在哪些订单
    private List<Order> orderList;

    // 当前用户拥有哪些角色信息
    private List<Role> roleList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orderList=" + orderList +
                ", roleList=" + roleList +
                '}';
    }
}
