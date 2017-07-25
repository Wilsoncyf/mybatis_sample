package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.po.User;

/**
 * Created by machangsheng on 17/7/23.
 */
public interface UserMapper {

    //@Select("select id, user_name as userName, sex from t_user where id = #{id}")
    User getUser(Long id);
    int insertUser(User user);
}
