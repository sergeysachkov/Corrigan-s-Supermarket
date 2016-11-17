package com.ait.corrigan.dao;

import com.ait.corrigan.models.shop.Item;

import java.util.List;

public interface ItemDao {
    long addItem(Item item);
    long updateItem(Item item);
    long deleteItem(long itemId);

    Item getItem(long itemId);
    List<Item> getAllItems();
    List<Item> getItemsByCategory(String category);
}
