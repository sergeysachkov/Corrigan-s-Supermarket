package com.ait.corrigan.services;

import com.ait.corrigan.models.shop.Item;

import java.util.List;

public interface ItemService {
    long addItem(Item item);
    long updateItem(Item item);
    long deleteItem(long itemId);
    Item getItem(long itemId);

    List<Item> getCatalogue();
    List<Item> getCategory(String category);
}
