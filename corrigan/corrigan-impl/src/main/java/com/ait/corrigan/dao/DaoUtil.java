package com.ait.corrigan.dao;

import com.ait.corrigan.utils.DBPropertyUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by root on 11/17/2016.
 */
public class DaoUtil {

    public static final AtomicLong LAST_TIME=new AtomicLong();

    public static Connection getConnection() throws SQLException{
        try {
            DBPropertyUtil propertyUtil = new DBPropertyUtil();
            Class.forName(propertyUtil.getProperty("db.driver"));
            return DriverManager.getConnection(propertyUtil.getProperty("db.connection"),
                    propertyUtil.getProperty("db.user"),propertyUtil.getProperty("db.pass"));
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new SQLException(e);
        }
    }
    
    
   
     /**
     * Get a unique id that is close to current time in milliseconds
     *
     * @return a unique long integer
     */
    public static long getUniqueId() {
        long now = System.currentTimeMillis();
        while (true) {
            long lastTime = LAST_TIME.get();
            if (lastTime >= now) {
                now = lastTime + 1;
            }
            if (LAST_TIME.compareAndSet(lastTime, now)) {
                return now;
            }
        }
    }
    
    public static void main(String [] str) throws IOException {
        System.out.print(new DBPropertyUtil().getProperty("db.connection"));
    }
    
}
