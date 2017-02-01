package com.ait.corrigan.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.services.CategoryService;
import com.ait.corrigan.services.CategoryServicesImpl;
import com.ait.corrigan.services.ItemService;
import com.ait.corrigan.services.ItemServiceImpl;
@ManagedBean(name = "addCategoryBean")
@RequestScoped

public class AddCategoryBean {
	 private Category category;
	    @PostConstruct
	    public Category getCategory() {
	     return new Category(this.category.getCateID(), this.category.getCate_name());
	    }

	    public void setCategory(Category c) {
	        this.category.setCateID(c.getCateID());
	        this.category.setCate_name(c.getCate_name());
	    }

	    public long getCateId() {
	        return this.category.getCateID();
	    }

	    public void setCateId(int cateID) {
	        this.category.setCateID(cateID);
	    }

	    public String getName() {
	        return this.category.getCate_name();
	    }

	    public void setName(String cate_name) {
	    	this.category.setCate_name(cate_name);
	    }
	    public List<Category> getCategoryList() {
	        CategoryService csrv = new CategoryServicesImpl();
	        return csrv.getAllCategories();	
        }
	    public String submit() {
	        System.out.println("Submit INVOKED! "+category);
	        CategoryService csrv= new CategoryServicesImpl();
	     
	        csrv.addCategory(category);
	        return "manageStock?faces-redirect=true";
	    }

}
