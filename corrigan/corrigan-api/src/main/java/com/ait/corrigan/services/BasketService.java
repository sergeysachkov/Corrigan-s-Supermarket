package com.ait.corrigan.services;

import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.models.user.BasketItem;
import java.util.List;
import java.util.Map;

/**
 * This interface declarers the CURD methods on a single basket item or the 
 * complete basket.
 * @author Joshua <iyezi@hotmail.com>
 */
public interface BasketService {
    public BasketItem createBasket(long customerId);
    public void addItemToBasket(BasketItem basket);
    public void deleteItemFromBasket(BasketItem basket);
    public void updateItemInBasket(long basketIdOld,long itemIdOld, BasketItem basketNew);
    public void addItemsToBasket(BasketItem basket, Map<Long,Integer> basketItems);
//    public Map<Item,Integer> getItemsFromBasket(Basket basket);
    public List<BasketItem> getCompleteBasket(BasketItem basket);
    public void deleteBasketById(long basketId);
}
