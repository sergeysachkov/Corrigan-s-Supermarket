package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.BasketItem;
import java.sql.SQLException;
import java.util.List;

public interface BasketDao {
	void addBasket(BasketItem basket) throws SQLException;
	void updateBasket(long basketIdOld,long itemIdOld, BasketItem basketNew) throws SQLException;
	void deleteBasket(long basketId,long itemId) throws SQLException;
	BasketItem getBasket(long basketId,long itemId) throws SQLException;
        List<BasketItem> getCompleteBasket(long basketId) throws SQLException;
        void deleteOneCompleteBasket(long basketId) throws SQLException;
}
