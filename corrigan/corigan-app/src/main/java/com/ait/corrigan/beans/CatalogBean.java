package com.ait.corrigan.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.services.ItemServiceImpl;

@ManagedBean(name="catalog")
@ApplicationScoped

public class CatalogBean {
	
	@ManagedProperty(value="#{items}")
	private List<Item> items=null;

	 
	 @PostConstruct
	 public void getAllItems(){
		 ItemServiceImpl c=new ItemServiceImpl();
		 items= c.getCatalogue();
	 }

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
