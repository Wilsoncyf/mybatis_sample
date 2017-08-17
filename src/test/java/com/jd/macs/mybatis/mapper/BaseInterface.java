package com.jd.macs.mybatis.mapper;

import java.io.Serializable;

/**
 * Created by machangsheng on 17/8/11.
 */
@Deprecated
public interface BaseInterface extends Serializable, Cloneable {

    int fd = 1;
    int getFd();
}
