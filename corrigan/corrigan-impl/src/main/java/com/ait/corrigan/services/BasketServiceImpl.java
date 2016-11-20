package com.ait.corrigan.services;

import com.ait.corrigan.dao.BasketDaoImpl;
import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Basket;
import java.sql.SQLException;
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
    private static final Logger LOG = 
            Logger.getLogger(BasketServiceImpl.class.getName());

    @Override
    public Basket createBasket(long customerId) {
        return new Basket(DaoUtil.getUniqueId(), customerId, 0, 0);
    }

    /**
     * add an item to shopping basket
     *
     * @param basket only used as a source of basketId and userId
     * @param item the actual item to insert
     * @param quantity the actual quantity of item to insert
     */
    @Override
    public void addItemToBasket(Basket basket, long itemId, int quantity) {
        //TODO add verification of quantity
        basket.setItemId(itemId);
        basket.setQuantity(quantity);
        try {
            basketDao.addBasket(basket);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to add item into basket", ex);
            throw new CorriganException("Fail to add item into basket.");
        }

    }

    @Override
    public void deleteItemFromBasket(Basket basket) {
        try {
            basketDao.deleteBasket(basket.getBasketId(), basket.getItemId());
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to delete item:" + basket.getBasketId() + " from basket:" + basket.getBasketId(), ex);
            throw new CorriganException("Fail to delete item from database.");
        }
    }

    @Override
    public void updateItemInBasket(long basketIdOld,long itemIdOld, Basket basketNew) {
        try {
            basketDao.updateBasket(basketIdOld,itemIdOld,basketNew);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to update" + basketNew.toString(),ex);
            throw new CorriganException("Fail to update item in shopping basket.");
        }
    }

    @Override
    public void addItemsToBasket(Basket basket, Map<Long, Integer> basketItems) {
        Iterator<Long> it = basketItems.keySet().iterator();
        while (it.hasNext()) {
            long itemId = it.next();
            int quantity = basketItems.get(itemId);
            addItemToBasket(basket, itemId, quantity);
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

    //==== couldn't be done because of heavy reliance on Item dao ====
//    @Override
//    public Map<Item, Integer> getItemsFromBasket(Basket basket) {
//        long basketId = basket.getBasketId();
//        Map<Item, Integer> resultMap = new HashMap<>();
//        List<Basket> completeBasket = null;
//        try {
//            completeBasket = basketDao.getCompleteBasket(basketId);
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Fail to get complete basket, id=" + basketId, ex);
//            throw new CorriganException("Fail to get basket from database.");
//        }
//        Iterator<Basket> it=completeBasket.iterator();
//        while(it.hasNext()){
//            Basket curBasket=it.next();
//            resultMap.put(curBasket.getItemId(), curBasket.getQuantity());
//        }
//        return resultMap;
//    }

    @Override
    public List<Basket> getCompleteBasket(Basket basket) {
        long basketId=basket.getBasketId();
        
        List<Basket> completeBasket=null;
        try {
            completeBasket=basketDao.getCompleteBasket(basketId);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "fail to get complete basket, id="+basketId, ex);
        }
        return completeBasket;
    }

}
