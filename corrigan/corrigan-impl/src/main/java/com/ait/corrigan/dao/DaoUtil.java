package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by root on 11/17/2016.
 */
public class DaoUtil {
    public static final AtomicLong LAST_TIME=new AtomicLong();
    
    public static Connection getConnection() throws SQLException{
        try {
//            Class.forName("com.mysql.jdbc.Driver");
        	Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/corrigan?serverTimezone=UTC","root","admin");
        } catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
    }
    /**
     * Get a unique id that is close to current time in milliseconds
     * @return a unique long integer
     */
    public static long getUniqueId(){
        long now=System.currentTimeMillis();
        while(true)
        {
            long lastTime=LAST_TIME.get();
            if(lastTime>=now){
                now=lastTime+1;
            }
            if(LAST_TIME.compareAndSet(lastTime, now)){
                return now;
            }
        }
    }
    
    
    
}
