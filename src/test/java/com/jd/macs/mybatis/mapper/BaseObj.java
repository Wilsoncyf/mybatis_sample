package com.jd.macs.mybatis.mapper;

import org.apache.ibatis.type.Alias;

/**
 * Created by machangsheng on 17/8/11.
 */
@Alias("baseObj")
public class BaseObj {

    public interface I3 {

    }

    public int fd = 2;
    public int getFd(){
        return fd;
    }

    private BaseObj(){
        System.out.println("Instance created");
    }


    public BaseObj(int fd){
        this.fd = fd;
    }
}
