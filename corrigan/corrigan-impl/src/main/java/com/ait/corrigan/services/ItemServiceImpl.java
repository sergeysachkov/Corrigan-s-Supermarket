package com.ait.corrigan.services;

import com.ait.corrigan.dao.ItemDao;
import com.ait.corrigan.dao.ItemDaoImpl;
import com.ait.corrigan.models.shop.Item;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemServiceImpl implements ItemService{

    public long addItem(Item item){
        return 0;
    }

    public long updateItem(Item item){
        return 0;
    }
    public long deleteItem(long itemId){
        return 0;
    }

    public Item getItem(long itemId) {
        Item item=null;
        ItemDao c=new ItemDaoImpl();
        try {
            item = c.getItem(itemId);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, "Fail to get item "+itemId+" from db", ex);
        }
        return item;
    }

    //===========ADRIAN============
    public List<Item> getCatalogue() {
       ItemDaoImpl c=new ItemDaoImpl();
       return c.getAllItems();
    }

    public List<Item> getCategory(String category) {
        return null;
    }
}
