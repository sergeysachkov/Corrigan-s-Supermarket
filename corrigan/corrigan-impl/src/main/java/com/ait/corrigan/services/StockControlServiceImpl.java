package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.dao.StockControlDao;
import com.ait.corrigan.dao.StockControlDaoImpl;

public class StockControlServiceImpl implements StockControlService {
	private StockControlDao stockControlDao;
	   public StockControlServiceImpl() {
		   stockControlDao = new StockControlDaoImpl();
	    }

	    public StockControlServiceImpl(StockControlDao stockControlDao) {
	        this.stockControlDao = stockControlDao;
	    }
	    public void SClogin(String username, String password){
	        if(StockControlDao.checkStockControl(username, password)){
	            throw new SecurityException("User name or Password incorrect ");
	        }
	    }

}
