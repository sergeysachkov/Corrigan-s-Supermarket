package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.Manager;

public class ManagerDaoImpl implements ManagerDAO {
	
	public long addManager(Manager manager) { 
    	
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("INSERT INTO manager (idmanager, manager_name , manager_surname, manager_login, password) " +
                    "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, manager.getManagerID());
            stmt.setString(2, manager.getManagerName());
            stmt.setString(3, manager.getManagerSurname());
            stmt.setString (4, manager.getManagerLogin());
            stmt.setString(5, manager.getManagerPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 1;
		}
	
	
	public long updateManager(Manager manager) { 
    	
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("UPDATE manager set idmanager=?, manager_name=?, manager_surname=?, manager_login=?, password=? where manager_login=?) " +
                    "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, manager.getManagerID());
            stmt.setString(2, manager.getManagerName());
            stmt.setString(3, manager.getManagerSurname());
            stmt.setString (4, manager.getManagerLogin());
            stmt.setString(5, manager.getManagerPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 1;
		}
	
	public void deleteManager(){};
	
    public Manager getManager(long managerId) throws SQLException {
        Manager manager = new Manager();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from manager where idmanager=?")) {
            stmt.setLong(1, managerId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                manager.setManagerID(resultSet.getLong("idmanager"));
                manager.setManagerName(resultSet.getString("manager_name"));
                manager.setManagerSurname(resultSet.getString("manager_surname"));
                manager.setManagerLogin(resultSet.getString("manager_login"));
                manager.setManagerPassword(resultSet.getString("password"));


            }
        }
        return manager;
    }
	
    public List<Manager> getManagers() throws SQLException {
        List<Manager> managers = new ArrayList<>();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from manager")) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Manager manager = new Manager();
                manager.setManagerID(resultSet.getLong("idmanager"));
                manager.setManagerName(resultSet.getString("manager_name"));
                manager.setManagerSurname(resultSet.getString("manager_surname"));
                manager.setManagerLogin(resultSet.getString("manager_login"));
                manager.setManagerPassword(resultSet.getString("password"));
                managers.add(manager);
            }
        }
        return managers;
    }
    
  
    public  boolean checkManager (String login, String password) throws SQLException{
    	try(Connection connection = DaoUtil.getConnection();
    	 PreparedStatement stmt=connection.prepareStatement("SELECT * FROM manager WHERE manager_login = ? AND password = ?")){
    		 stmt.setString(1, login);
             stmt.setString(2, password);
             System.out.println(stmt);
             ResultSet result = stmt.executeQuery();
             if(result.next()){
            	 return true;
             }
    	 }
    	catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		      }
	 return false;
	 }
    
    public Manager getManagerByUsername(String login) throws SQLException {
        Manager manager = new Manager();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from manager where manager_login =?"))
            		{
            stmt.setString(1, login);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
            	manager.setManagerID(resultSet.getLong("idstaff"));
            	manager.setManagerLogin(resultSet.getString("username"));
            	manager.setManagerPassword(resultSet.getString("password"));
            	manager.setManagerName(resultSet.getString("firstName"));
            	manager.setManagerSurname(resultSet.getString("lastName"));
            }
        }
        return manager;
}
    
	

}
