package com.ait.corrigan.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ait.corrigan.models.user.Basket;
import com.mysql.jdbc.Connection;

public class BasketDaoImpl implements BasketDao {
	private Connection con = null;

	public BasketDaoImpl() {
		Logger.getLogger(BasketDaoImpl.class.getName()).log(Level.INFO, "Loading db driver...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			Logger.getLogger(BasketDaoImpl.class.getName()).log(Level.SEVERE, "Fail to load db driver.",e);
		}
	}

	@Override
	public long addBasket(Basket basket) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Basket updateBasket(long basketId, Basket basket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBasket(long basketId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Basket getBasket(long basketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(long basketId, long itemId, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(long basketId, long itemId, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(long basketId, long itemId) {
		// TODO Auto-generated method stub
		return false;
	}

}
