package com.oneby.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName DateTypeHandler
 * @Description TODO
 * @Author Oneby
 * @Date 2021/3/14 13:18
 * @Version 1.0
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {
    // 将java类型转换成数据库需要的类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long milliseconds = date.getTime();
        preparedStatement.setLong(i, milliseconds);
    }

    // 将数据库中类型转换成java类型：ResultSet resultSet 是查询出的结果集；String s为要转换的字段名称
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //获得结果集中需要的数据(long) 转换成Date类型 返回
        long milliseconds = resultSet.getLong(s);
        Date date = new Date(milliseconds);
        return date;
    }

    // 将数据库中类型转换成java类型
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long milliseconds = resultSet.getLong(i);
        Date date = new Date(milliseconds);
        return date;
    }

    //将数据库中类型转换成java类型
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long milliseconds = callableStatement.getLong(i);
        Date date = new Date(milliseconds);
        return date;
    }
}

