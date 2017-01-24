package com.ait.corrigan.services;

import com.ait.corrigan.dao.BasketDaoImpl;
import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Basket;
import com.ait.corrigan.models.user.BasketItem;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author Joshua <iyezi@hotmail.com>
 */
public class BasketServiceImpl implements BasketService {

    BasketDaoImpl basketDao = new BasketDaoImpl();
    private static final Logger LOG
            = Logger.getLogger(BasketServiceImpl.class.getName());

//    @Override
//    public BasketItem createBasket(long customerId) {
//        return new BasketItem(DaoUtil.getUniqueId(), customerId, 0, 0);
//    }
//
//    /**
//     * add an item to shopping basket
//     *
//     * @param basket only used as a source of basketId and userId
//     * @param item the actual item to insert
//     * @param quantity the actual quantity of item to insert
//     */
//    @Override
//    public void addItemToBasket(BasketItem basket) {
//        //TODO add verification of quantity
//        long basketId = basket.getBasketId();
//        long itemId = basket.getItemId();
//        int quantity = basket.getQuantity();
//        try {
//            BasketItem tmpBasket = basketDao.getBasket(basketId, itemId);
//            if (tmpBasket != null) {
//                tmpBasket.setQuantity(tmpBasket.getQuantity() + quantity);
//                basketDao.updateBasket(basketId, itemId, basket);
//            } else {
//                basketDao.addBasket(basket);
//            }
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Fail to add item into basket", ex);
//            throw new CorriganException("Fail to add item into basket.");
//        }
//
//    }
//
//    @Override
//    public void deleteItemFromBasket(BasketItem basket) {
//        try {
//            basketDao.deleteBasket(basket.getBasketId(), basket.getItemId());
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Fail to delete item:" + basket.getBasketId() + " from basket:" + basket.getBasketId(), ex);
//            throw new CorriganException("Fail to delete item from database.");
//        }
//    }
//
//    @Override
//    public void updateItemInBasket(long basketIdOld, long itemIdOld, BasketItem basketNew) {
//        try {
//            basketDao.updateBasket(basketIdOld, itemIdOld, basketNew);
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Fail to update" + basketNew.toString(), ex);
//            throw new CorriganException("Fail to update item in shopping basket.");
//        }
//    }
//
//    @Override
//    public void addItemsToBasket(BasketItem basket, Map<Long, Integer> basketItems) {
//        Iterator<Long> it = basketItems.keySet().iterator();
//        while (it.hasNext()) {
//            long itemId = it.next();
//            int quantity = basketItems.get(itemId);
//            basket.setItemId(itemId);
//            basket.setQuantity(quantity);
//            addItemToBasket(basket);
//        }
//    }
//
//    @Override
//    public void deleteBasketById(long basketId) {
//        try {
//            basketDao.deleteOneCompleteBasket(basketId);
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Fail to delete basket, id=" + basketId, ex);
//            throw new CorriganException("Fail to delete basket.");
//        }
//    }
//
//    @Override
//    public List<BasketItem> getCompleteBasket(BasketItem basket) {
//        long basketId = basket.getBasketId();
//
//        List<BasketItem> completeBasket = null;
//        try {
//            completeBasket = basketDao.getCompleteBasket(basketId);
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "fail to get complete basket, id=" + basketId, ex);
//        }
//        return completeBasket;
//    }
    public static void main(String[] args) {
        BasketServiceImpl bservice = new BasketServiceImpl();
//        long bid = bservice.getNewBasketId();
//        System.out.println("bid=" + bid);
//        bservice.addItem(bid, 1, 1, 114);
//        bservice.addItem(bid, 1, 2, 514);
//        bservice.addItem(bid, 1, 3, 893);
//        bservice.addItem(bid, 1, 4, 810);
//        Basket b = bservice.getBasket(bid);
//        System.out.println(b);
        bservice.deleteBasket(148522124440l);

    }

    @Override
    public long getNewBasketId() {
        return DaoUtil.getUniqueId();
    }

    @Override
    public void addItem(long basketId, long userId, long itemId, int quantity) {
        try {
            BasketItem tmpBasket = basketDao.getBasket(basketId, itemId);
            if (tmpBasket != null) {
                tmpBasket.setQuantity(tmpBasket.getQuantity() + quantity);
                basketDao.updateBasket(basketId, itemId, tmpBasket);
            } else {
                basketDao.addBasket(new BasketItem(basketId, userId, itemId, quantity));
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to add item into basket", ex);
            throw new CorriganException("Fail to add item into basket.");
        }
    }

    @Override
    public void deleteItem(long basketId, long itemId) {
        try {
            basketDao.deleteBasket(basketId, itemId);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to delete item:" + basketId + " from basket:" + itemId, ex);
            throw new CorriganException("Fail to delete item from database.");
        }
    }

    @Override
    public void updateItem(long basketId, long itemId, int quantity) {
        BasketItem basket2upd = null;
        try {
            basket2upd = basketDao.getBasket(basketId, itemId);
            if (basket2upd == null) {
                throw new CorriganException("Fail to update item: the item does not exist.");
            } else {
                basket2upd.setQuantity(quantity);
                basketDao.updateBasket(basketId, itemId, basket2upd);
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Fail to update" + basket2upd.toString(), ex);
            throw new CorriganException("Fail to update item in shopping basket.");
        }
    }

    @Override
    public Basket getBasket(long basketId) {
        Basket b = new Basket();
        b.setBasketId(basketId);
        List<BasketItem> basketItems;
        try {
            basketItems = basketDao.getCompleteBasket(basketId);
            if (basketItems.isEmpty()) {
                throw new CorriganException("Invalid basket id.");
            } else {
                long userId = basketItems.get(0).getUserId();
                b.setUserId(userId);
                for (BasketItem i : basketItems) {
                    b.addItem(i.getItemId(), i.getQuantity());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BasketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new CorriganException("Invalid basket id.");
        }

        return b;
    }
    @Override
    public void deleteBasket(long basketId) {
        try {
            basketDao.deleteOneCompleteBasket(basketId);
        } catch (SQLException ex) {
            Logger.getLogger(BasketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new CorriganException("Fail to delete basket.");
        }
    }
}
