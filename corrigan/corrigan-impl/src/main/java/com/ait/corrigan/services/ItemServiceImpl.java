package com.ait.corrigan.services;

import com.ait.corrigan.dao.ItemDao;
import com.ait.corrigan.dao.ItemDaoImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.shop.Item;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemServiceImpl implements ItemService {

    public Item getItem(long itemId) {
        Item item = null;
        ItemDao c = new ItemDaoImpl();
        try {
            item = c.getItem(itemId);
        } catch (SQLException ex) {
            Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, "Fail to get item " + itemId + " from db", ex);
        }
        return item;
    }
    private static final Logger LOG = Logger.getLogger(ItemServiceImpl.class.getName());

    //===========ADRIAN============
    public List<Item> getCatalogue() {
        ItemDaoImpl c = new ItemDaoImpl();
        return c.getAllItems();
    }

    //===========ADRIAN============
    public List<Item> getCategory(String category) {
        ItemDaoImpl c = new ItemDaoImpl();
        return c.getItemsByCategory(category);
    }

    @Override
    public void addItem(Item item) {
        ItemDao idao = new ItemDaoImpl();
        try {
            idao.addItem(item);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Fail to add item, " + item, e);
            throw new CorriganException("Fail to add item, " + item, e);
        }
    }

    @Override
    public void updateItem(Item item) {
        ItemDao idao = new ItemDaoImpl();
        try {
            idao.updateItem(item);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Fail to update item, " + item, e);
            throw new CorriganException("Fail to update item, " + item, e);
        }
    }

    @Override
    public void deleteItem(long itemId) {
        ItemDao idao = new ItemDaoImpl();
        try {
            idao.deleteItem(itemId);
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "Fail to delete item, id=" + itemId, e);
            throw new CorriganException("Fail to delete item, id=" + itemId, e);
        }
    }
    
}
