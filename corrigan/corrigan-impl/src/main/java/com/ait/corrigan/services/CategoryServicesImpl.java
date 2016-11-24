package com.ait.corrigan.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ait.corrigan.dao.CategoryDAOImpl;
import com.ait.corrigan.models.shop.Category;

public class CategoryServicesImpl implements CategoryService {

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub

		
	}

	
/*	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category getCategory(int categoryId) {
	
		return null;
	}
	
	@Override
	public List<Category> getAllCategories() {
		CategoryDAOImpl c=new CategoryDAOImpl();
		List<Category> allCat=new ArrayList<Category>();
		
		try {
			allCat=c.getAllCategories();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return allCat;
	}*/







	@Override
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public Category getCategory(int categoryId) {
	
		return null;
	}
	
	@Override
	public List<Category> getAllCategories() {
		CategoryDAOImpl c=new CategoryDAOImpl();
		List<Category> allCat=new ArrayList<Category>();
		
		try {
			allCat=c.getAllCategories();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return allCat;
	}

}

