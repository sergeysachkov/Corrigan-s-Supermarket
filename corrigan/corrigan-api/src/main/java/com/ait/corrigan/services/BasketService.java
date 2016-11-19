package com.ait.corrigan.services;

import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.models.user.Basket;
import java.util.List;
import java.util.Map;

/**
 * This interface declarers the CURD methods on a single basket item or the 
 * complete basket.
 * @author Joshua <iyezi@hotmail.com>
 */
public interface BasketService {
    public Basket createBasket(long customerId);
    public void addItemToBasket(Basket basket,Item item,int quantity);
    public void deleteItemFromBasket(Basket basket);
    public void updateItemInBasket(Basket basket);
    public void addItemsToBasket(Basket basket,Map<Item,Integer> basketItems);
//    public Map<Item,Integer> getItemsFromBasket(Basket basket);
    public List<Basket> getCompleteBasket(Basket basket);
    public void deleteBasketById(long basketId);
}
