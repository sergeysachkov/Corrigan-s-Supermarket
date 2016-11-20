package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Basket;
import java.sql.SQLException;
import java.util.List;

public interface BasketDao {
	void addBasket(Basket basket) throws SQLException;
	void updateBasket(long basketIdOld,long itemIdOld, Basket basketNew) throws SQLException;
	void deleteBasket(long basketId,long itemId) throws SQLException;
	Basket getBasket(long basketId,long itemId) throws SQLException;
        List<Basket> getCompleteBasket(long basketId) throws SQLException;
        void deleteOneCompleteBasket(long basketId) throws SQLException;
}
