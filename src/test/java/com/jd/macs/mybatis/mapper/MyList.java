package com.jd.macs.mybatis.mapper;

/**
 * Created by machangsheng on 17/8/11.
 */
public interface MyList<T> {

    void add(T data);
    int getLength();
    T get(int index);
}
