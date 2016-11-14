package com.ait.corrigan.dao;

import com.ait.corrigan.models.shop.Category;

public interface CategoryDao {
	long addCategory(Category category);
	void deleteCategory(int categoryId);
	void updateCategory(Category category);
	Category getCategory(int categoryId);
	
}
