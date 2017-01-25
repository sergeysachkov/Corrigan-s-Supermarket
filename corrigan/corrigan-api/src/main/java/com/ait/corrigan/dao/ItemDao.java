package com.ait.corrigan.dao;

import com.ait.corrigan.models.shop.Item;
import java.sql.SQLException;

import java.util.List;

public interface ItemDao {
    void addItem(Item item) throws SQLException;
    void updateItem(Item item)throws SQLException;
    void deleteItem(long itemId)throws SQLException;

    Item getItem(long itemId)throws SQLException;
    List<Item> getAllItems()throws SQLException;
    List<Item> getItemsByCategory(String category)throws SQLException;
}
