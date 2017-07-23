package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.po.Role;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void testDelete(){
        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);
        roleMapper.deleteRole(3L);
    }

    @Test
    public void testGetRole(){
        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(7L);

        Assert.assertEquals("admin", role.getRoleName());
        Assert.assertEquals("super role", role.getNote());
    }

    @Test
    public void testGetAllRoles(){
        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);
        List<Role> roleList = roleMapper.getAllRoles();

        Assert.assertEquals(1, roleList.size());
        Assert.assertEquals("admin", roleList.get(0).getRoleName());
    }
}
