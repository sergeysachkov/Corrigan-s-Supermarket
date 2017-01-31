package com.ait.corrigan.beans;

import com.ait.corrigan.dao.CategoryDAOImpl;
import com.ait.corrigan.dao.CategoryDao;
import com.ait.corrigan.models.shop.Category;
import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.services.CategoryService;
import com.ait.corrigan.services.CategoryServicesImpl;
import com.ait.corrigan.services.ItemService;
import com.ait.corrigan.services.ItemServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author joshua
 *
 * provides CRUD operations for items in stock
 *
 */
@ManagedBean(name = "stockManageBean")
@RequestScoped
public class StockManageBean {

    private List<Item> items = null;
    @ManagedProperty(value = "#{param.itemId}")
    private long itemId;
    private Item item = null;
    private Category category=null;
    
//    private String name=null;
//    private int quantity=0;
//    private String unit=null;
//    private String description=null;
//    private double price=0;
//    private String category=null;

    private void updateDb() {
        ItemService isrv = new ItemServiceImpl();
        isrv.updateItem(item);
        this.item = isrv.getItem(itemId);
    }
    public List<Category> getCategoryList(){
        CategoryService csrv=new CategoryServicesImpl();
        return csrv.getAllCategories();
    }

    public Category getCategory() {
        ItemService isrv=new ItemServiceImpl();
        long cateId=isrv.getItem(itemId).getCateID();
        CategoryService cserv=new CategoryServicesImpl();
        category=cserv.getCategory(cateId);
        System.out.println("Category:"+ category);
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Item> getItems() {
        ItemService isrv = new ItemServiceImpl();
        items = isrv.getCatalogue();
        return items;
    }

    public String editItem(long itemId) {
        String editUrl = "editItem?faces-redirect=true";
        setItemId(itemId);
        return editUrl;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
        ItemService isrv = new ItemServiceImpl();
        this.item = isrv.getItem(itemId);
    }

    public String getName() {
        return item.getName();
    }

    public void setName(String name) {
        item.setName(name);
        updateDb();
    }

    public int getQuantity() {
        return item.getStock_q();
    }

    public void setQuantity(int quantity) {
        this.item.setStock_q(quantity);
        updateDb();
    }

    public String getUnit() {
        return item.getUnit_of_measure();
    }

    public void setUnit(String unit) {
        this.item.setUnit_of_measure(unit);
        updateDb();
    }

    public String getDescription() {
        return this.item.getDescription();
    }

    public void setDescription(String description) {
        this.item.setDescription(description);
        updateDb();
    }

    public double getPrice() {
        return this.item.getPrice();
    }

    public void setPrice(double price) {
        this.item.setPrice(price);
        updateDb();
    }

}
