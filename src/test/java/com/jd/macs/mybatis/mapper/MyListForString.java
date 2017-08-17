package com.jd.macs.mybatis.mapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by machangsheng on 17/8/11.
 */
public class MyListForString implements MyList<String> {
    public void add(String data) {

    }

    public int getLength() {
        return 0;
    }

    public String get(int index) {
        return null;
    }

    @Resource
    private Map<String, Integer>  map = new HashMap<String, Integer>();
    private Integer id = 1;

    public boolean isClass = true;

    private static String NAME = "myString";

    public int getId(){
        return id;
    }
}
