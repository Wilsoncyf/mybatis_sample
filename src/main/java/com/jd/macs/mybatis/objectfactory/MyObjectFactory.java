package com.jd.macs.mybatis.objectfactory;

import com.jd.macs.mybatis.typehandler.MyEnumTypeHandler;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by cdmachangsheng on 2017/7/24.
 */
public class MyObjectFactory extends DefaultObjectFactory {

    private Logger log = Logger.getLogger(MyObjectFactory.class.getName());

    public void setProperties(Properties properties) {
        log.info("setProperties:" + properties);
        super.setProperties(properties);
    }

    public <T> T create(Class<T> aClass) {
        log.info("create with aClass :" + aClass.getName());
        return super.create(aClass);
    }

    public <T> T create(Class<T> aClass, List<Class<?>> list, List<Object> list1) {
        log.info("create with three parameter");
        return super.create(aClass, list, list1);
    }

    public <T> boolean isCollection(Class<T> aClass) {
        log.info("isCollection : " + aClass.getName());
        return isCollection(aClass);
    }
}
