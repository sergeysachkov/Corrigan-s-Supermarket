/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.beans;

import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.services.CategoryService;
import com.ait.corrigan.services.CategoryServicesImpl;
import com.ait.corrigan.services.ItemService;
import com.ait.corrigan.services.ItemServiceImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kfbb
 */
@ManagedBean(name = "addItemBean")
@RequestScoped
public class AddItemBean {

    private Item item;
    @PostConstruct
    public void initItem(){
        item=new Item();
        item.setItemID(DaoUtil.getUniqueId());
    }
    public Category getCategory() {
        return new Category(this.item.getCateID(), this.item.getCate_name());
    }

    public void setCategory(Category c) {
        this.item.setCateID(c.getCateID());
        this.item.setCate_name(c.getCate_name());
    }

    public List<Category> getCategoryList() {
        CategoryService csrv = new CategoryServicesImpl();
        return csrv.getAllCategories();
    }

    public long getItemId() {
        return this.item.getItemID();
    }

    public void setItemId(long itemId) {
        this.item.setItemID(itemId);
    }

    public String getName() {
        return this.item.getName();
    }

    public void setName(String name) {
        this.item.setName(name);
    }
    
    public int getQuantity(){
        return this.item.getStock_q();
    }
    public void setQuantity(int q){
        this.item.setStock_q(q);
    }
    public String getUnit(){
        return this.item.getUnit_of_measure();
    }
    public void setUnit(String u){
        this.item.setUnit_of_measure(u);
    } 
    public String getDescription(){
        return this.item.getDescription();
    }
    public void setDescription(String d){
        this.item.setDescription(d);
    }
    public double getPrice(){
        return this.item.getPrice();
    }
    public void setPrice(double p){
        this.item.setPrice(p);
    }
    public String submit() {
        System.out.println("Submit INVOKED! "+item);
        ItemService isrv=new ItemServiceImpl();
        isrv.addItem(item);
        return "manageStock?faces-redirect=true";
    }
}
