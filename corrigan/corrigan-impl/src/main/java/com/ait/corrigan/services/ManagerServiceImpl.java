package com.ait.corrigan.services;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ait.corrigan.dao.ManagerDaoImpl;
import com.ait.corrigan.dao.ManagerDAO;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Manager;

public class ManagerServiceImpl implements ManagerService{
    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private ManagerDAO managerDAO;
    
    public ManagerServiceImpl() {
        managerDAO = new ManagerDaoImpl();
    }

    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public long addManager(Manager manager){

        return managerDAO.addManager(manager);
    
    }

    public long updateManager(Manager manager){
        return managerDAO.updateManager(manager);
    }
    public void deleteManager(){

    }

    public Manager getManager(long managerId){
        try {
            return managerDAO.getManager(managerId);
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }
    
    
    public List<Manager> getManagers(){
        try {
            return managerDAO.getManagers();
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }
    
    public Manager getManagerByUsername(String managerUsername){
        try {
            return managerDAO.getManagerByUsername(managerUsername);
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }
    
    
}
