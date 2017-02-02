package com.ait.corrigan.services;

import java.sql.SQLException;
import java.util.List;

import com.ait.corrigan.models.shop.Category;

public interface CategoryService {

	void addCategory(Category category); 
	void updateCategory(Category category);
	void deleteCategory(long categoryId); 
	void updateCategory(long id,String name);
	Category getCategory(long categoryId);
	List<Category> getAllCategories();
}
