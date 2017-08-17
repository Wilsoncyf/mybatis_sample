package com.jd.macs.mybatis.mapper;

import org.apache.ibatis.reflection.Reflector;

import java.util.List;

/**
 * Created by machangsheng on 17/8/12.
 */
public class TestType {

    /**
     * @param args the params
     **/
    public static void main(String args[]) throws Exception{

//        // 这个字段本来是泛型K, V
//        Field f = ClassA.class.getDeclaredField("map"); // F
//
//        System.out.println(f.getGenericType());
//        System.out.println(f.getGenericType() instanceof ParameterizedType);
//
//
//        System.out.println("-----未解析之前的类型信息--------");
//        Type formalType = f.getGenericType();
//        System.out.println(formalType.getClass());
//        ParameterizedType fp = (ParameterizedType) formalType;
//        System.out.println(fp.getRawType());
//
//        System.out.println(fp.getOwnerType());
//
//        for(Type t : fp.getActualTypeArguments()){
//            System.out.println(t);
//        }
//        //System.out.println(f2.getDeclaringClass());
//
//        Type type = TypeParameterResolver.resolveFieldType(f,
//                TestType.class.getDeclaredField("sa").getGenericType());
//
//        //此时, f 是父类中的字段, 而srcType是子类.
//        System.out.println("-------------解析之后的类型信息-----------");
//
//        // 经过解析后,变成了实际类型Long. 这个原因是因为子类的实际类型是Long.
//        System.out.println(type.getClass());
//        ParameterizedType p = (ParameterizedType) type;
//        System.out.println(p.getRawType());
//
//        System.out.println(p.getOwnerType());
//
//        for(Type t : p.getActualTypeArguments()){
//            System.out.println(t.getClass());
//        }

        Reflector r2 = new Reflector(TestType.class);

        System.out.println(r2.hasGetter("sa"));

    }

    SubClassA<List<Long>> sa = new SubClassA<List<Long>>();


}
