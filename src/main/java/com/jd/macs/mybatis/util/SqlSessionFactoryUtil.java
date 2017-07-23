package com.jd.macs.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by machangsheng on 17/7/23.
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    private static final Class CLASS_LOCK =
            SqlSessionFactoryUtil.class;

    private SqlSessionFactoryUtil(){}

    public static SqlSessionFactory initSqlSessionFatory(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException ex) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        synchronized (CLASS_LOCK) {
            if(sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }

        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession(){
        if(sqlSessionFactory == null) {
            initSqlSessionFatory();
        }

        return sqlSessionFactory.openSession();
    }
}
