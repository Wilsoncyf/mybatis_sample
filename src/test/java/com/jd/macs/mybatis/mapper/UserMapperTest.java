package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.enums.Sex;
import com.jd.macs.mybatis.po.Role;
import com.jd.macs.mybatis.po.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by machangsheng on 17/7/23.
 */
public class UserMapperTest extends BaseTest {

    @Test
    public void testInsert(){
        User user = new User();

        user.setUserName("tangxu");
        user.setCnname("唐旭");
        user.setBirthday("2012-01-01");
        user.setEmail("macs524@qq.com");
        user.setMobile("13611269541");
        user.setNote("to test enum type handler");
        user.setSex(Sex.FEMALE);

        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);

        userMapper.insertUser(user);
    }

    @Test
    public void testGetUser(){
        UserMapper userMapper = getSqlSession().getMapper(UserMapper.class);

        User user = userMapper.getUser(3L);

        Assert.assertEquals("tangxu", user.getUserName());
        Assert.assertEquals(Sex.FEMALE, user.getSex());
    }

}
