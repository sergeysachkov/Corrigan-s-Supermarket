package com.ait.corrigan.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.services.CategoryService;
import com.ait.corrigan.services.CategoryServicesImpl;
import com.ait.corrigan.services.ItemService;
import com.ait.corrigan.services.ItemServiceImpl;


@ManagedBean(name = "categoryList")
@RequestScoped
public class ListCategoryBean {
	private List<Category> categorys = null;
	@ManagedProperty(value = "#{param.cateId}")
	 private long cateId;
     private Category category = null;
    
     @PostConstruct
     public void populateCategory() {
         CategoryService csrv = new CategoryServicesImpl();
         this.category = csrv.getCategory(cateId);
     }
     
     private void updateDb() {
    	 CategoryService csrv = new CategoryServicesImpl();
    	  csrv.updateCategory(category);
    	  this.category = csrv.getCategory(cateId);
     }
     public List<Category> getCategoryList() {
         CategoryService csrv = new CategoryServicesImpl();
         return csrv.getAllCategories();
         
     }
   
     public long getCateId() {
    	 return cateId;
     }
     public void setCateId(long cateId) {
         this.cateId = cateId;

     }
     public String getName() {
    	 CategoryService cserv = new CategoryServicesImpl();
         this.category = cserv.getCategory(cateId);
         return category.getCate_name();
     }

     public void setName(String name) {
    	 category.setCate_name(name);
     }
     public String deleteCategory(long id2Del){
    	 CategoryService csery = new CategoryServicesImpl();
    	 csery.deleteCategory(id2Del);
    	 return "/listCategory.xhtml?faces-redirect=true";
    	 
     }
     
     
     public String doUpdate() {

         System.out.println("CATEGORY:" + category);
         updateDb();
         return "listCategory?faces-redirect=true";
     }
}
