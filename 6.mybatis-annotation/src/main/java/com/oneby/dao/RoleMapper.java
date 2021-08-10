package com.oneby.dao;

import com.oneby.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName RoleMapper
 * @Description TODO
 * @Author Oneby
 * @Date 2021/4/2 8:05
 * @Version 1.0
 */
public interface RoleMapper {

    @Select("SELECT * FROM t_user_role ur,t_role r WHERE ur.roleId=r.id AND ur.userId=#{uid}")
    public List<Role> findByUid(int uid);

}
