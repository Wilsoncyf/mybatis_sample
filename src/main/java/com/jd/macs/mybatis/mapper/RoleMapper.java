package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.params.RoleParam;
import com.jd.macs.mybatis.po.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    List<Role> findRoleByMap(Map<String, String> map);
    List<Role> findRoleByAnnotation(@Param("roleName") String rolename,
                                    @Param("note") String note);
    List<Role> findRoleByParams(RoleParam roleParam);

    int delete(@Param("tableName")String tableName,
               @Param("id")Long id);
    void updateRole(Role role);
}
