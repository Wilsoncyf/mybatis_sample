package com.jd.macs.mybatis.mapper;

import java.util.Map;

/**
 * Created by machangsheng on 17/8/12.
 */
public class ClassA<K, V> {

    public Map<K, V> getMap() {
        return map;
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    public Map<K, V> map;
}
