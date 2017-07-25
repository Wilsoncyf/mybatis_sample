package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by machangsheng on 17/7/23.
 */
public class BaseTest {

    private SqlSession sqlSession;
    @Before
    public void before(){
        sqlSession = SqlSessionFactoryUtil.openSqlSession();
    }

    @After
    public void after(){
        if(sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void testDatabaseId(){
        String databaseId = sqlSession.getConfiguration().getDatabaseId();

        Assert.assertEquals("mysql", databaseId);
    }

    protected  SqlSession getSqlSession(){
        return sqlSession;
    }
}
