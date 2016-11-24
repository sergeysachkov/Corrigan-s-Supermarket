package com.ait.corrigan.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.services.CategoryServicesImpl;
import com.ait.corrigan.services.ItemServiceImpl;

@ManagedBean(name="catalog")
@ApplicationScoped

public class CatalogBean {
	
	@ManagedProperty(value="#{items}")
	private List<Item> items=null;
	
	@ManagedProperty(value="#{categories}")
	private List<Category> categories=null;
	
	@ManagedProperty(value="#{name}")
	private String name="all";

	 
	 @PostConstruct
	 public void getAllItems(){
		 ItemServiceImpl c=new ItemServiceImpl();
		 this.items= c.getCatalogue();
	 }

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	 @PostConstruct
	public void getAllCat(){
		CategoryServicesImpl c= new CategoryServicesImpl();
		this.categories=c.getAllCategories();
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	 
}
