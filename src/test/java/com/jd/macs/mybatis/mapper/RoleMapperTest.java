package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.po.Role;
import org.junit.Test;

/**
 * Created by machangsheng on 17/7/23.
 */
public class RoleMapperTest extends BaseTest {

    @Test
    public void testInsert(){
        Role role = new Role();
        role.setRoleName("admin");
        role.setNote("super role");

        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);

        roleMapper.insertRole(role);
    }
}
