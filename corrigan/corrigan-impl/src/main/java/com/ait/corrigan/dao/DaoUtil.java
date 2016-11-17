package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by root on 11/17/2016.
 */
public class DaoUtil {
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/corrigan","admin","admin");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }

    }
}
