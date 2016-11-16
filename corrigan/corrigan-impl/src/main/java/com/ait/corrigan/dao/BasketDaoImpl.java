package com.ait.corrigan.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		String sql="INSERT INTO `basket` (`userID`, `itemID`, `quantity`) VALUES ( ?, ?, ?)";
		PreparedStatement pstmt=null;
//		List<Map<Item, Integer>> itemsMap=basket.getBasketItem();
		// TODO Auto-generated method stub
		try {
			
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, basket.getCustomer().getCustomerId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Basket updateBasket(Basket basket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBasket(long basketId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Basket getBasket(long basketId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addItem(long basketId, long itemId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(long basketId, long itemId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(long basketId, long itemId) {
		// TODO Auto-generated method stub
		
	}

	

}
