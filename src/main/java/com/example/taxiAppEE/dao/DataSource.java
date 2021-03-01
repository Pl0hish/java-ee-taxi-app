package com.example.taxiAppEE.dao;

import com.example.taxiAppEE.dao.mapper.OrderMapper;
import com.example.taxiAppEE.dao.mapper.UserMapper;
import com.example.taxiAppEE.model.Order;
import com.example.taxiAppEE.model.User;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataSource {

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl(YOUR DATA);
        config.setUsername(YOUR DATA);
        config.setPassword(YOUR DATA);
        config.addDataSourceProperty("cachePrepStmts" , "true");
        config.addDataSourceProperty("prepStmtCacheSize" , "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit" , "2048");
        config.setDriverClassName("com.mysql.jdbc.Driver");
        config.setMaximumPoolSize(20);
        config.setConnectionTimeout(20000);
        config.setIdleTimeout(20000);
        config.setMaxLifetime(20000);

        ds = new HikariDataSource(config);
    }

    private DataSource() {}

    public static synchronized Connection getConnection() {
        Connection connection=null;
        try {
            connection = ds.getConnection();
        } catch (SQLException ex) {
            //TODO LOGGER
//            LOG.error(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                //TODO LOGGER
//                LOG.error(Messages.ERR_CANNOT_CLOSE_CONNECTION, ex);
            }
        }
    }

}
