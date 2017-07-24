package com.jd.macs.mybatis.typehandler;

import com.jd.macs.mybatis.enums.Sex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by machangsheng on 17/7/23.
 */
public class MyEnumTypeHandler implements TypeHandler<Sex> {

    private Logger log = Logger.getLogger(MyEnumTypeHandler.class.getName());


    public void setParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        log.info("setting parameter ");
        preparedStatement.setInt(i, sex.getId());
    }

    public Sex getResult(ResultSet resultSet, String s) throws SQLException {

        int val = resultSet.getInt(s);
        return Sex.getSex(val);
    }

    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        int val = resultSet.getInt(i);
        return Sex.getSex(val);
    }

    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        int val = callableStatement.getInt(i);
        return Sex.getSex(val);
    }
}
