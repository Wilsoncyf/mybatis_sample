package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.po.Role;

/**
 * Created by machangsheng on 17/7/23.
 */
public interface RoleMapper {

    Role getRole(Long id);
    int deleteRole(Long id);
    int insertRole(Role role);
}
