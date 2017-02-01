package com.ait.corrigan.services;

import java.sql.SQLException;
import java.util.List;

import com.ait.corrigan.models.shop.Category;

public interface CategoryService {

	void addCategory(Category category); 
	void deleteCategory(int categoryId); 
	void updateCategory(Category category);
	Category getCategory(int categoryId);
	List<Category> getAllCategories();
}
