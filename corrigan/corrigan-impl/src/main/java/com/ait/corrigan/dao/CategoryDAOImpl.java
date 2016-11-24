package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.models.shop.Item;

public class CategoryDAOImpl implements CategoryDao {

	@Override
	public void addCategory(Category category) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCategory(int categoryId) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCategory(Category category) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Category getCategory(int categoryId) throws SQLException {
		return null;
	}

	/*
	@Override
	public List<Category> getAllCategories() throws SQLException {
		
		 List<Category> allCategories = new ArrayList<Category>();
		 Category cat = null;

	        try {
	            Connection con = DaoUtil.getConnection();
	            String sql = "select cate_name from Categories";
	           
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	cat = new Category(rs.getString(1));
	            	allCategories.add(cat);
	            }

	        } catch (SQLException e) {

	            e.printStackTrace();
	        }
	        return allCategories;

	}
*/

	
	@Override
	public List<Category> getAllCategories() throws SQLException {
		
		 List<Category> allCategories = new ArrayList<Category>();
		 Category cat = null;

	        try {
	            Connection con = DaoUtil.getConnection();
	            String sql = "select cate_name from Categories";
	           
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	cat = new Category(rs.getString(1));
	            	allCategories.add(cat);
	            }

	        } catch (SQLException e) {

	            e.printStackTrace();
	        }
	        return allCategories;

	}


}
