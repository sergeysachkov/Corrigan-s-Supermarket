package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Basket;

public interface BasketDao {
	long addBasket(Basket basket);
	Basket updateBasket(long basketId,Basket basket);
	boolean deleteBasket(long basketId);
	Basket getBasket(long basketId);

	public boolean addItem(long basketId, long itemId, int quantity);
	public boolean updateItem(long basketId, long itemId, int quantity);
	public boolean deleteItem(long basketId, long itemId);
}
