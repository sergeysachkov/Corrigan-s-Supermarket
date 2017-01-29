package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Basket;

/**
 * This interface declarers the CURD methods on a single basket item or the
 * complete basket.
 *
 * @author Joshua <iyezi@hotmail.com>
 */
public interface BasketService {
//    public BasketItem createBasket(long customerId);
//    public void addItemToBasket(BasketItem basket);
//    public void deleteItemFromBasket(BasketItem basket);
//    public void updateItemInBasket(long basketIdOld,long itemIdOld, BasketItem basketNew);
//    public void addItemsToBasket(BasketItem basket, Map<Long,Integer> basketItems);
//    public List<BasketItem> getCompleteBasket(BasketItem basket);
//    public void deleteBasketById(long basketId);

    public long getNewBasketId();

    public void addItem(long basketId, long userId, long itemId, int quantity);

    public void deleteItem(long basketId, long itemId);

    public void updateItem(long basketId, long itemId, int quantity);

    public Basket getBasket(long basketId);

    public void deleteBasket(long basketId);
}
