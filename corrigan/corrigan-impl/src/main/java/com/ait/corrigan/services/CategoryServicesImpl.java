package com.ait.corrigan.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ait.corrigan.dao.CategoryDAOImpl;
import com.ait.corrigan.dao.CategoryDao;
import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.shop.Category;

public class CategoryServicesImpl implements CategoryService {
	private CategoryDao categoryDao;
	 public CategoryServicesImpl() {
	        categoryDao = new CategoryDAOImpl();
	    }
	 public CategoryServicesImpl(CategoryDao categoryDao) {
	        this.categoryDao = categoryDao;
	    }
	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub

	}
	public void addCategory(long id, String name) {
        try {
			categoryDao.addCategory(id, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CorriganException(e.getMessage());
		};

	}

	
	@Override
	public void deleteCategory(int categoryId) {
		 try {
			categoryDao.deleteCategory(categoryId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CorriganException(e.getMessage());
		}

	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub

	}

	public void updateCategory(long id, String name) {
		try {
			categoryDao.updateCategory(id, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CorriganException(e.getMessage());
		}

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
