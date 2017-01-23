package com.ait.corrigan.services;

import com.ait.corrigan.dao.BasketDaoImpl;
import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.BasketItem;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joshua <iyezi@hotmail.com>
 */
public class BasketServiceImpl implements BasketService {

    BasketDaoImpl basketDao = new BasketDaoImpl();
    private static final Logger LOG
            = Logger.getLogger(BasketServiceImpl.class.getName());

    @Override
    public BasketItem createBasket(long customerId) {
        return new BasketItem(DaoUtil.getUniqueId(), customerId, 0, 0);
    }

    /**
     * add an item to shopping basket
     *
     * @param basket only used as a source of basketId and userId
     * @param item the actual item to insert
     * @param quantity the actual quantity of item to insert
     */
    @Override
    public void addItemToBasket(BasketItem basket) {
        //TODO add verification of quantity
        long basketId = basket.getBasketId();
        long itemId = basket.getItemId();
        int quantity = basket.getQuantity();
        try {
            BasketItem tmpBasket = basketDao.getBasket(basketId, itemId);
            if (tmpBasket != null) {
                tmpBasket.setQuantity(tmpBasket.getQuantity() + quantity);
                basketDao.updateBasket(basketId, itemId, basket);
            } else {
                basketDao.addBasket(basket);
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to add item into basket", ex);
            throw new CorriganException("Fail to add item into basket.");
        }

    }

    @Override
    public void deleteItemFromBasket(BasketItem basket) {
        try {
            basketDao.deleteBasket(basket.getBasketId(), basket.getItemId());
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to delete item:" + basket.getBasketId() + " from basket:" + basket.getBasketId(), ex);
            throw new CorriganException("Fail to delete item from database.");
        }
    }

    @Override
    public void updateItemInBasket(long basketIdOld, long itemIdOld, BasketItem basketNew) {
        try {
            basketDao.updateBasket(basketIdOld, itemIdOld, basketNew);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to update" + basketNew.toString(), ex);
            throw new CorriganException("Fail to update item in shopping basket.");
        }
    }

    @Override
    public void addItemsToBasket(BasketItem basket, Map<Long, Integer> basketItems) {
        Iterator<Long> it = basketItems.keySet().iterator();
        while (it.hasNext()) {
            long itemId = it.next();
            int quantity = basketItems.get(itemId);
            basket.setItemId(itemId);
            basket.setQuantity(quantity);
            addItemToBasket(basket);
        }
    }

    @Override
    public void deleteBasketById(long basketId) {
        try {
            basketDao.deleteOneCompleteBasket(basketId);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to delete basket, id=" + basketId, ex);
            throw new CorriganException("Fail to delete basket.");
        }
    }

    @Override
    public List<BasketItem> getCompleteBasket(BasketItem basket) {
        long basketId = basket.getBasketId();

        List<BasketItem> completeBasket = null;
        try {
            completeBasket = basketDao.getCompleteBasket(basketId);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "fail to get complete basket, id=" + basketId, ex);
        }
        return completeBasket;
    }

    public static void main(String[] args) {
        BasketServiceImpl bservice = new BasketServiceImpl();
        BasketItem basket = bservice.createBasket(2);
        long basketId = basket.getBasketId();
        long itemId1 = 99990001;
        long itemId2 = 99990002;
        System.out.println(basketId);
        basket.setItemId(itemId1);
        basket.setQuantity(114514);
        bservice.addItemToBasket(basket);
        
        bservice.addItemsToBasket(basket, new HashMap<Long, Integer>() {
            {
                put(itemId1, 114);
                put(itemId2, 514);
            }
        });
    }
}
