package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Basket;
import java.sql.SQLException;

public interface BasketDao {
	void addBasket(Basket basket) throws SQLException;
	void updateBasket(Basket basket) throws SQLException;
	void deleteBasket(long basketId,long itemId) throws SQLException;
	Basket getBasket(long basketId,long itemId) throws SQLException;
}
