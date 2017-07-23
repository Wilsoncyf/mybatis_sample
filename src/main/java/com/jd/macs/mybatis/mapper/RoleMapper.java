package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.po.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by machangsheng on 17/7/23.
 */
public interface RoleMapper {

    Role getRole(Long id);
    int deleteRole(Long id);
    int insertRole(Role role);

    @Select("select id, role_name as roleName, note from t_role where id = 7")
    List<Role> getAllRoles();

    Role findRole(String roleName);
}
