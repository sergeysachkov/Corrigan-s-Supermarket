
package com.ait.corrigan.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ait.corrigan.dao.CategoryDAOImpl;
import com.ait.corrigan.dao.CategoryDao;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.dao.ItemDao;
import com.ait.corrigan.dao.ItemDaoImpl;


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
    public Category getCategory(long categoryId) {
    	Category category = null;
    	CategoryDao c =  new CategoryDAOImpl();
        try {
        	category = c.getCategory(categoryId);
           // return categoryDao.getCategory(categoryId);
        } catch (SQLException e) {
        	Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, "Fail to get category " + categoryId + " from db", e);
            //throw new CorriganException(e.getMessage());
        }
        return category;
    }
    
    private static final Logger LOG = Logger.getLogger(CategoryDAOImpl.class.getName());
    
   /* public long addCategory(String name) {


    @Override
    public long addCategory(String name) {

        long newId = 0;
        try {
            newId = categoryDao.getNewId();
            categoryDao.addCategory(newId, name);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new CorriganException(e.getMessage());
        }
        return newId;
    }*/

    @Override
    public void deleteCategory(long categoryId) {
        try {
            categoryDao.deleteCategory(categoryId);
        } catch (SQLException e) {
        	 LOG.log(Level.SEVERE, "Fail to delete category, id=" + categoryId, e);
            // TODO Auto-generated catch block
            throw new CorriganException(e.getMessage());
        }

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
    public List<Category> getAllCategories() {
        CategoryDAOImpl c = new CategoryDAOImpl();
        List<Category> allCat = new ArrayList<Category>();

        try {
            allCat = c.getAllCategories();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCat;
    }

	@Override
	public void addCategory(Category category) {
		
		CategoryDao cdao = new CategoryDAOImpl();
	        try {
	            cdao.addCategory(category);;
	        } catch (SQLException e) {
	           // LOG.log(Level.SEVERE, "Fail to add item, " + category, e);
	            throw new CorriganException("Fail to add category, " + category, e);
	        }
		
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		   try {
	            categoryDao.updateCategory(category);;
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	         LOG.log(Level.SEVERE, "Fail to update category, " + category, e);
	         throw new CorriganException("Fail to update category, " + category, e);
	        	//  throw new CorriganException(e.getMessage());
	        }
	}


	

}
/*
package com.ait.corrigan.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ait.corrigan.dao.CategoryDAOImpl;
import com.ait.corrigan.dao.CategoryDao;
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
    public long addCategory(String name) {
        long newId = 0;
        try {
            newId = categoryDao.getNewId();
            categoryDao.addCategory(newId, name);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new CorriganException(e.getMessage());
        }
        return newId;
    }

    @Override
    public void deleteCategory(long categoryId) {
        try {
            categoryDao.deleteCategory(categoryId);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new CorriganException(e.getMessage());
        }

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
    public Category getCategory(long categoryId) {
        try {
            return categoryDao.getCategory(categoryId);
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }

    @Override
    public List<Category> getAllCategories() {
        CategoryDAOImpl c = new CategoryDAOImpl();
        List<Category> allCat = new ArrayList<Category>();

        try {
            allCat = c.getAllCategories();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCat;
    }

}
*/
