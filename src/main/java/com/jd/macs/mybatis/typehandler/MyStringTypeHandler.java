package com.jd.macs.mybatis.typehandler;

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
@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyStringTypeHandler implements TypeHandler<String> {

    private Logger log = Logger.getLogger(MyStringTypeHandler.class.getName());

    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        log.info("use my TypeHandler");
        ps.setString(i, parameter);
    }

    public String getResult(ResultSet rs, String columnName) throws SQLException {

        log.info("use my TypeHandler, get result by column name of resultset");
        return rs.getString(columnName);
    }

    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        log.info("use my TypeHandler, get result by column index of resultset");
        return rs.getString(columnIndex);
    }

    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        log.info("use my TypeHandler, get result by column index of callable statement");
        return cs.getString(columnIndex);
    }
}
