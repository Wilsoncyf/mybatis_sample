package com.jd.macs.mybatis.mapper;

import org.apache.ibatis.type.Alias;

import javax.annotation.Resource;
import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * Created by machangsheng on 17/8/11.
 */
public class FieldTest {
    /**
     * @param args the params
     **/
    public static void main(String args[]) throws Exception {
            //testMethod(MyListForString.class);
            testMethod(MyListImpl.class);
            //testField();

        //testConstructor(BaseObj.class);
    }

    public static boolean isParamterizedType(Type type){
        return type instanceof ParameterizedType;
    }

    public static boolean isTypeVar(Type type) {
        return type instanceof TypeVariable;
    }

    public static boolean isGenericArrayType(Type type) {
        return type instanceof GenericArrayType;
    }

    public static String getTypeStr(Type t){
        if(isParamterizedType(t)){
            return "ParameterizedType: " + ((ParameterizedType) t).getRawType();
        } else if(isTypeVar(t)){
            return "TypeVariable:" + ((TypeVariable) t).getName();
        }else if(isGenericArrayType(t)){
            return "GenericArrayType" + ((GenericArrayType) t).getGenericComponentType();
        }else if(t instanceof Class) {
            return "Class : " + ((Class) t).getSimpleName();
        }
        return "unknown";
    }

    public static void testMethod(Class cls) throws Exception {
        Method[] methods = cls.getDeclaredMethods();

        for(Method method : methods) {
            print(method.toGenericString());

            Type returnType = method.getGenericReturnType();

            if(returnType instanceof ParameterizedType) {
                print("\tParameterizedType");
                print("\t" + ((ParameterizedType) returnType).getRawType());

                for(Type realType : ((ParameterizedType) returnType).getActualTypeArguments()){
                    print("\t\t" + getTypeStr(realType));
                }
                //print("\t" + ((ParameterizedType) returnType).getActualTypeArguments());
            } else if (isTypeVar(returnType)) {
                TypeVariable typeVariable = (TypeVariable) returnType;
                print("\t" + returnType.getClass() + ":" + typeVariable.getName());
            }
        }

        // 对于Method 类, 主要用到的方法如下:
        // 1. 查询方法的修饰符, 比如是否public, 是否static, 是否为final
        // 2. 方法的返回值(分class和type)
        // 3. 方法的参数(同样分class[]和type[])
        // 4. 方法的异常声明
        // 5. 方法调用
        // 6. 方法上的注解, 方法参数上的注解.
    }

    public static void testField() throws Exception {
        Field field = MyListForString.class.getDeclaredField("map");

        print("-------type---------");
        print(field.getType());
        print(field.getGenericType());

        print("-----toString-------");
        print(field.toString());
        print(field.toGenericString());

        print("------get&set-------");
        MyListForString obj = new MyListForString();

        Field idField = MyListForString.class.getDeclaredField("id");
        idField.setAccessible(true);
        Integer val = (Integer)idField.get(obj);
        System.out.println(val);

        Field booleanField = MyListForString.class.getDeclaredField("isClass");
        print(booleanField.getBoolean(obj));

        Field staticStrField = MyListForString.class.getDeclaredField("NAME");
        staticStrField.setAccessible(true);
        print(staticStrField.get(null));

        idField.set(obj, 20);

        print(obj.getId());

        print("------------annotation---------");
        Annotation annotation = field.getAnnotation(Resource.class);
        print(annotation == null);

        /*
        * field还是比较好理解的, 在反射时主要用到以下几个方法
        *
        * 1) 获取所有字段,或者是根据字段名获取某个字段
        * 2) 设置或者获取实例的某个字段的值, 如果字段不可访问,可以强行修改
        * 3) 获取字段上的注解.
        *
        * */

    }


    public static void testConstructor(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor[] constructors = cls.getDeclaredConstructors();

        for(Constructor constructor : constructors) {
            //构造函数也算是一个特殊的方法, 但其特点是没有返回值, 所以不用考虑returnType
            // 另外这个方法重载的可能性比较大
            print(constructor);
        }

        if(Point.class.equals(cls)){

            Constructor<Point> constructor = cls.getDeclaredConstructor(
                    int.class,
                    int.class
            );

            //method1: use constructor
            Point point = constructor.newInstance(3, 5);
            print(point);

            //method2: use class
            Point point1 = (Point)cls.newInstance();
            print(point1);
        }

        if(BaseObj.class.equals(cls)) {

            //
            Annotation annotation = cls.getAnnotation(Alias.class);
            if(annotation != null) {
                print(((Alias)annotation).value());
            }

            // 即使把构造函数定义为私有, 我们也还是有办法使用其来创建一个实例.
            Constructor constructor = cls.getDeclaredConstructor(null);
            print(Modifier.isPrivate(constructor.getModifiers()));
            print(constructor.isAccessible());

            constructor.setAccessible(true);
            BaseObj baseObj = (BaseObj)constructor.newInstance();
            print(baseObj.getFd());
        }

        // 构造函数还是比较简单的, 和Method有共同点,但限制要多一些.
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}
