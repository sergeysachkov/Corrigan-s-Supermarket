package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Basket;

public interface BasketDao {
	long addBasket(Basket basket);
	Basket updateBasket(Basket basket);
	void deleteBasket(long basketId);
	Basket getBasket(long basketId);

	public void addItem(long basketId, long itemId, int quantity);
	public void updateItem(long basketId, long itemId, int quantity);
	public void deleteItem(long basketId, long itemId);
}
