package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Manager;
import java.sql.SQLException;
import java.util.List;

public interface ManagerDAO {
	
	    long addManager(Manager manager);
	    long updateManager(Manager manager);
	    void deleteManager();
	    Manager getManager(long Id) throws SQLException;
	    List<Manager> getManagers() throws SQLException;
	    static boolean checkManager(String login, String password){
			return true;};
	
}
