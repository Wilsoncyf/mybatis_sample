package com.jd.macs.mybatis.database;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by machangsheng on 17/7/24.
 */
public class DbcpDataSourceFactory implements DataSourceFactory{

    private Properties properties;

    public void setProperties(Properties props) {
        this.properties = props;
    }

    public DataSource getDataSource() {

        System.out.println("create a new database start");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);

            System.out.println("create a new database finished");
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return dataSource;
    }
}
