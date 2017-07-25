package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.params.RoleParam;
import com.jd.macs.mybatis.po.Role;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Assert.assertNotNull(role.getId());
        System.out.println("the new id is " + role.getId());
    }

    @Test
    public void testDelete(){
        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);
       int count =  roleMapper.delete("t_role", 13L);

        Assert.assertEquals(1, count);
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

    @Test
    public void testFindRole(){
        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);

        Role role = roleMapper.findRole("admin");
        Assert.assertNotNull(role);
        Assert.assertEquals("super role", role.getNote());
        Assert.assertEquals(1L, role.getId().longValue());
    }


    @Test
    public void testFindRoleByParams(){
        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("roleName", "admin");
        paramMap.put("note", "role");

        List<Role> roleList = roleMapper.findRoleByMap(paramMap);

        Assert.assertEquals(1, roleList.size());
        Assert.assertEquals("super role", roleList.get(0).getNote());

        roleList = roleMapper.findRoleByAnnotation("admin", "role");
        Assert.assertEquals(1, roleList.size());
        Assert.assertEquals("super role", roleList.get(0).getNote());

        RoleParam roleParam = new RoleParam();
        roleParam.setRoleName("admin");
        roleParam.setNote("role");

        roleList = roleMapper.findRoleByParams(roleParam);
        Assert.assertEquals(1, roleList.size());
        Assert.assertEquals("super role", roleList.get(0).getNote());

    }


    @Test
    public void testUpdateRole(){
        Role role = new Role();
        role.setId(15L);
        role.setNote("new note");
        role.setRoleName("Ma haoyang");

        RoleMapper roleMapper = getSqlSession().getMapper(RoleMapper.class);

        roleMapper.updateRole(role);
    }
}
