package com.ait.corrigan.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
	 public void initCategory(){
		 category=new Category();
		 category.setCateID((int) DaoUtil.getUniqueId());
	    }
	 //@ManagedProperty(value = "#{param.cateId}")
	 // private long cateId;
	    
	    public Category getCategory() {
	        return new Category(this.category.getCateID(), this.category.getCate_name());
	    }

	    public void setCategory(Category c) {
	        this.category.setCateID(c.getCateID());
	        this.category.setCate_name(c.getCate_name());
	    }
	    public List<Category> getCategoryList() {
	        CategoryService csrv = new CategoryServicesImpl();
	       return csrv.getAllCategories();	
        }
	    
	    	 
	    
	     public int getcateId() {
	       return this.category.getCateID();
	    }
	  
	     public void setcateId(int cateId) {
		       this.category.setCateID(cateId);
		   }
      

	    public String getName() {
	        return this.category.getCate_name();
	    }
	    
	    public void setName(String name) {
	       this.category.setCate_name(name);}
	   
	   
	    public String submit() {
	        System.out.println("Submit INVOKED! "+category);
	        CategoryService csrv= new CategoryServicesImpl();
	     
	        csrv.addCategory(category);
	        return "manageStock?faces-redirect=true";
	    }

}
