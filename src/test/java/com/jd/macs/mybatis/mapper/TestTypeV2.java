package com.jd.macs.mybatis.mapper;

import org.apache.ibatis.reflection.TypeParameterResolver;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by machangsheng on 17/8/12.
 */
public class TestTypeV2 {

    /**
     * @param args the params
     **/
    public static void main(String args[]) throws Exception{
        Field map = SubClassB.class.getField("map");
        System.out.println(map.getGenericType());

        Type type = TypeParameterResolver.resolveFieldType(map,
                ClassA.class);

        System.out.println(type.getClass());
        ParameterizedType p = (ParameterizedType) type;
        System.out.println(p.getRawType());

        System.out.println(p.getOwnerType());

        for(Type t : p.getActualTypeArguments()){
            System.out.println(t);
        }
    }
}
