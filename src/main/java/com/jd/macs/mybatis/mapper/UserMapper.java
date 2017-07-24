package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.po.Role;
import com.jd.macs.mybatis.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by machangsheng on 17/7/23.
 */
public interface UserMapper {

    User getUser(Long id);
    int insertUser(User user);
}
