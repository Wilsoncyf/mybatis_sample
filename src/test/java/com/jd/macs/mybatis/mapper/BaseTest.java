package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

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

    protected  SqlSession getSqlSession(){
        return sqlSession;
    }
}
