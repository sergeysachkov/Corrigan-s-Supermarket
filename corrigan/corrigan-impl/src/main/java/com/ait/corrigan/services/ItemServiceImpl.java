package com.ait.corrigan.services;

import com.ait.corrigan.dao.ItemDaoImpl;
import com.ait.corrigan.models.shop.Item;

import java.util.List;

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
        return null;
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
