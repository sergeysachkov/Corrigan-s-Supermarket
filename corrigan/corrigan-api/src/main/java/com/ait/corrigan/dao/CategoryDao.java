
package com.ait.corrigan.dao;

import com.ait.corrigan.models.shop.Category;
import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
	void addCategory(Category category) throws SQLException;
	void addCategory(long id, String name) throws SQLException;
	void deleteCategory(long categoryId) throws SQLException;   
	void updateCategory(long id, String name) throws SQLException;
	void updateCategory(Category category)throws SQLException;  
	
	public long getNewId() throws SQLException;
	Category getCategory(long categoryId) throws SQLException;
	List<Category> getAllCategories() throws SQLException;
	
	
}

