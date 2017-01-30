package com.ait.corrigan.services;

import com.ait.corrigan.models.shop.Item;

import java.util.List;

public interface ItemService {
    void addItem(Item item);
    void updateItem(Item item);
    void deleteItem(long itemId);
    Item getItem(long itemId);

    List<Item> getCatalogue();
    List<Item> getCategory(String category);
}
