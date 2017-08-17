package com.jd.macs.mybatis.mapper;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by machangsheng on 17/8/11.
 */
public class ClassTest {

    /**
     * @param args the params
     **/
    public static void main(String args[]) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Class cls = MyListImpl.class;


        //1. print name
        print(cls.getCanonicalName());
        print(cls.getName());
        print(cls.getSimpleName());
        print(cls.toString());

        print(cls.isInstance(cls.newInstance()));

        int a = 0;
        print(int.class.isInstance(a));

        Object objArr[] = new Object[0];
        print(objArr.getClass().isInstance(new Object[]{}));


        print(BaseObj.class.isAssignableFrom(cls));
        print(Object.class.isAssignableFrom(objArr.getClass()));

        print(MyList.class.isInterface());
        print(cls.isArray());
        print(void.class.isPrimitive());

        print(Deprecated.class.isAnnotation());

        print(cls.isSynthetic());

        print(int.class.getName());
        print(Integer.class.getName());

        print(Integer.class.equals(int.class));

        print(new boolean[]{}.getClass().getName());
        print(cls.getClassLoader());


        Map<String, Integer> map = new HashMap<String, Integer>();
        TypeVariable<?> typeVariable [] = map.getClass().getTypeParameters();
        for(TypeVariable typeVariable1 : typeVariable) {
            System.out.println(typeVariable1);
        }

        print("------getSuperClass----------");
        print(cls.getSuperclass());
        print(map.getClass().getSuperclass());//Object

        print("------getGenericSuperclass----------");
        print(cls.getGenericSuperclass());
        print(map.getClass().getGenericSuperclass());//Object

        //如果不考虑泛型,这两者应该是一样的.
        Type theType = map.getClass().getGenericSuperclass();
        print(theType instanceof GenericArrayType);
        print(theType instanceof ParameterizedType);
        print(theType instanceof TypeVariable);
        print(theType instanceof WildcardType);


        print(cls.getClass().getPackage().getName());

        print("------getInterface()------------");
        Class interfaces[] = cls.getInterfaces();
        for(Class face : interfaces) {
            print(face.getName());
        }
        print("------getGenericInterfaces()------------");
        Type types[] = cls.getGenericInterfaces(); //两者也是差在泛型.

        print(types.getClass().getComponentType());
        for(Type type : types) {
            print(type);

            if(type instanceof ParameterizedType) {
                print(((ParameterizedType) type).getOwnerType());
                print(((ParameterizedType) type).getRawType());

                for(Type type1 : ((ParameterizedType) type).getActualTypeArguments()) {
                    print(type1);
                }
            }
        }




        print(Modifier.isPublic(cls.getModifiers()));
        print(Modifier.isFinal(cls.getModifiers()));
       // Object[] signers = cls.getSigners();

        //System.out.println("signer len is " + signers.length);
       /* for(Object sign : signers) {
            print(sign);
        }*/

        MyListImpl myList = new MyListImpl(2);
        Runnable r = myList.getRunnable();
        r.run();
        print("enclosing" + r.getClass().getEnclosingClass());

        print(myList.getR2().getDeclaringClass());
        print(myList.getR2().getEnclosingClass());


        print("member or anonymous");
        print(myList.getR2().isMemberClass());
        print(r.getClass().isAnonymousClass());

        print("is local");
        print(myList.getR2().isLocalClass());
        print(r.getClass().isLocalClass());


        testLocalClass();

        // 这个类内部定义的所有public的类和接口.
        // 包括其父类
        Class[] classes = myList.getClass().getClasses();
        System.out.println(classes.length);

        //这个方法返回的必须是public的field
        Field[] fields = myList.getClass().getFields();

        for(Field field : fields) {
            print(field.getName());
        }

        print(cls.getField("r2").getName());

        //同样,这个返回的是public method, 包括父类
        Method[] methods = myList.getClass().getMethods();
        for(Method method : methods) {
            print(method.getName());
        }

        print("---------constructors--------------");
        Constructor[] constructors = myList.getClass().getConstructors();
        for(Constructor constructor : constructors) {
            print(constructor.getName());
        }

        print("--------method or field search----------");
        // 同名字段,如果当前类没有,先找父接口
        Field field = cls.getField("fd");
        print("field:" + field.getDeclaringClass().getName());

        // 同名方法,如果当前类没有,则先找父类
        Method method = cls.getMethod("getFd");
        print("method:" + method.getDeclaringClass().getName());



        print("----------declared---------------");
        fields = cls.getDeclaredFields();
        for(Field field1 : fields) {
            print(field1);
        }
        methods = cls.getDeclaredMethods();
        for(Method method1 : methods) {
            print(method1 + " is bridge ? " + method1.isBridge());
        }
        constructors = cls.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            print(constructor);
        }


        print("-----annotation----------");
        Annotation[] annotations = cls.getAnnotations();
        for(Annotation annotation : annotations){
            print(annotation);
        }
        annotations = cls.getDeclaredAnnotations();
        for(Annotation annotation : annotations){
            print(annotation);
        }

        Annotation annotation = cls.getAnnotation(Resource.class);

        print(cls.isAnnotationPresent(Resource.class));



        // 整个class 的结构就算是测试完了, 目前来看比较重要的有这样一些部分

        //1. 获取名称, 简单名称,全称
        //2. 获取接口,父类,这个主要分普通和带Generic 这两种形式, 后者返回的是Type, 而前者返回的是class.
        // 如果要解析泛型的话,需要用到后者.

        //3. 获取方法,字段和构造函数, 都有两个版本,一个是获取所有public的(包括父类), 另一类以Declared开头
        // 获取当前类定义的所有(不分修饰符)

        //4. 获取注解, 目前来看这个比较简单, 虽然有两个版本,但结果是一样的.

        //5. 获取定义的内部class. 即成员方法, 戓者如果当前类是内部类的话,获取其外部类.


        methods = MyListForString.class.getDeclaredMethods();
        for(Method method1 : methods) {
            print(method1 + " is bridge ? " + method1.isBridge());
        }
    }

    private static void print(Object obj) {

        System.out.println(obj);
    }

    private static void testLocalClass(){
        class LocalClass {
            void display(){
                print(getClass().getName() +
                        " is a local class ? "
                        + getClass().isLocalClass());
            }
        };

        LocalClass localClass = new LocalClass();
        localClass.display();
    }
}
