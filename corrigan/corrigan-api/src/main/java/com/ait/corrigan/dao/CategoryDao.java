package com.ait.corrigan.dao;

import com.ait.corrigan.models.shop.Category;
import java.sql.SQLException;

public interface CategoryDao {
	void addCategory(Category category) throws SQLException;
	void deleteCategory(int categoryId) throws SQLException;
	void updateCategory(Category category) throws SQLException;
	Category getCategory(int categoryId) throws SQLException;
	
}
