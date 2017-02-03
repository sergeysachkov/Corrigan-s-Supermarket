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
