package com.jd.macs.mybatis.databaseIdprovider;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by machangsheng on 17/7/24.
 */
public class MydatabaseIdProvider implements DatabaseIdProvider {
    private Properties properties;
    public void setProperties(Properties p) {
        this.properties = p;
    }

    public String getDatabaseId(DataSource dataSource) throws SQLException {
        String dbName = dataSource.getConnection()
                .getMetaData().getDatabaseProductName();

        System.out.println("The databse name is " + dbName);


        return properties.getProperty(dbName.toUpperCase());
    }
}
