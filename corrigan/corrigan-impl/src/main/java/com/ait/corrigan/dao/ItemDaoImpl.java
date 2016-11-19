package com.ait.corrigan.dao;

import com.ait.corrigan.models.shop.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

	public long addItem(Item item) {
		return 0;
	}

	public long updateItem(Item item) {
		return 0;
	}

	public long deleteItem(long itemId) {
		return 0;
	}

	//=======ADRIAN=======
	public List<Item> getAllItems() {
		List<Item> allItems=new ArrayList<Item>();
		Item item=null;
		
		try {
			Connection con = DaoUtil.getConnection();

			String sql = "SELECT * FROM ITEMS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				item = new Item(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
				allItems.add(item);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return allItems;
	
	}

	public List<Item> getItemsByCategory(String category) {
		return null;
	}

	// ========Adrian========
	@Override
	public Item getItem(long itemId) {
		Item item=null;
		try {
			Connection con = DaoUtil.getConnection();

			String sql = "SELECT * FROM ITEMS WHERE itemID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, itemId);
			ResultSet rs = pstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			 item = new Item(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6));

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return item;
	}
}
