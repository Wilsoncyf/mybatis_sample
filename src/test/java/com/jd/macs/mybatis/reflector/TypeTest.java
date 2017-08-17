package com.jd.macs.mybatis.reflector;

import com.jd.macs.mybatis.po.Student;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * Created by machangsheng on 17/8/3.
 */
public class TypeTest {

    @Test
    public void testStringMap() throws Exception{

        Class cls1 = Class.forName("java.lang.Integer");

        Class cls2 = Integer.class;

        Integer num1 = Integer.valueOf("1");
        Class cls3 = num1.getClass();

        System.out.println(cls1.equals(cls2));
        System.out.println(cls1 == cls2);


        System.out.println(cls1.equals(cls3));
        System.out.println(cls1 == cls3);

        System.out.println(cls1 instanceof Type);
    }

    @Test
    public void testStudentClass() throws NoSuchFieldException, IllegalAccessException {
        Student stu = new Student();
        Class clsForStu = stu.getClass();

        //1. get Fields
        Field[] fields = clsForStu.getFields();
        for(Field field : fields){
            System.out.println("field:" + field.getName());
            System.out.println("type:" + field.getGenericType());
        }

        //Field field = clsForStu.getField("id");
        Field field2 = clsForStu.getDeclaredField("id");

        field2.setAccessible(true);
        field2.set(stu, 1L);

        System.out.println(field2);

        System.out.println(stu.getId());


        Method[] methods = clsForStu.getDeclaredMethods();

        for(Method method : methods) {
            System.out.println(method.getName() +
            ":" + method.getGenericReturnType());

            if(method.getParameterTypes().length > 0){
                System.out.println(method.getParameterTypes()[0]);
            }
        }
    }

    @Test
    public void testData(){
        System.out.println(DataV2.class.getGenericSuperclass());
       //displayClass(DataV2.class);
       displayClass(Data.class);
    }

    private void displayClass(Class dataClass){
        Method[] methods = dataClass.getDeclaredMethods();

        for(Method method : methods) {

            System.out.println("\n----------------");
            System.out.println("method Name:" +method.getName() + "|\tmethod returnType:"
                    + method.getReturnType() +"|\tgeneric return type: "
                    + method.getGenericReturnType());

            Type type = method.getGenericReturnType();

            if(type instanceof Class) {
                System.out.println(((Class) type).getSimpleName()
                        + " is a class");
            }else if(type instanceof ParameterizedType) {
                System.out.println( type + " is a ParameterizedType");
                System.out.println("getRawType():" + ((ParameterizedType) type).getRawType());
                Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();

                System.out.println("getActualTypeArguments():");
                for(Type arg : arguments) {
                    System.out.println("\targ--" + arg);

                    if (arg instanceof WildcardType) {
                        System.out.println(arg + " is a WildcardType");
                    }
                }

                System.out.println("getOwnerType():" + ((ParameterizedType) type).getOwnerType());

            }else if (type instanceof TypeVariable) {
                System.out.println( ((TypeVariable) type).getName() + " is a TypeVariable");

                Type[] bounds = ((TypeVariable) type).getBounds();

                System.out.println("getBounds()");
                if(bounds != null && bounds.length > 0) {
                    for(Type bound : bounds) {
                        System.out.println("bound is " + bound);
                    }
                }

                System.out.println("getGenericDeclaration():"
                    + ((TypeVariable) type).getGenericDeclaration());
                System.out.println("getName():" + ((TypeVariable) type).getName());

            }else if (type instanceof GenericArrayType) {
                System.out.println(type + " is a GenericArrayType");

                Type paramType = ((GenericArrayType) type).getGenericComponentType();

                System.out.println("getGenericComponentType:" + paramType);


            }else if (type instanceof WildcardType) {
                System.out.println(type + " is a WildcardType");
            }else {
                System.out.println(type + " is unknown type");
            }

            if(method.isBridge()) {
                System.out.println("this method is a bridge method");
            }
        }
    }
}
