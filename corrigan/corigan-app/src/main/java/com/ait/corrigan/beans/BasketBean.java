/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.beans;

import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.models.user.BasketItem;
import com.ait.corrigan.services.BasketService;
import com.ait.corrigan.services.BasketServiceImpl;
import com.ait.corrigan.services.ItemService;
import com.ait.corrigan.services.ItemServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Joshua <iyezi@hotmail.com>
 */
@ManagedBean(name = "basketBean")
@SessionScoped
public class BasketBean {

    /**
     * Creates a new instance of basketBean
     */
    private static final long ID_UNASSIGNED = -1l;
    private long basketId = ID_UNASSIGNED;
    private List<BasketItem> basketItems;
    private double total;

    private BasketService bsktService;
    private static final Logger LOG = Logger.getLogger(BasketBean.class.getName());

    public BasketBean() {
        bsktService = new BasketServiceImpl();
        basketId = bsktService.getNewBasketId();
        basketItems = new ArrayList<>();
    }

    public long getBasketId() {
        return basketId;
    }

    public String addToBasket(Item item) {
        String basketUrl = "basket?faces-redirect=true";
        //TODO validate fields of Basket item2Add
        for (BasketItem b : basketItems) {
            if (b.getItemId() == item.getItemID()) {
                // already in the basket   
                b.setQuantity(b.getQuantity() + 1);
                return basketUrl;
            }
        }
        //TODO user id
        BasketItem tmpBasket = new BasketItem(basketId, 0, item.getItemID(), 1);
        LOG.log(Level.INFO, tmpBasket.toString());
        basketItems.add(tmpBasket);
        return basketUrl;
    }

    public String deleteFromBasket(BasketItem basket) {
        String basketUrl = "basket?faces-redirect=true";
        basketItems.remove(basket);
        return basketUrl;

    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public String getItemName(long itemId) {
        ItemService iservice = new ItemServiceImpl();
        return iservice.getItem(itemId).getName();
    }

    public double getItemPrice(long itemId) {
        ItemService iservice = new ItemServiceImpl();
        return iservice.getItem(itemId).getPrice();
    }

    public double getTotal() {
        total = 0;
        for (BasketItem b : basketItems) {
            long id = b.getItemId();
            if (id == ID_UNASSIGNED) {
                total += 0;
            } else {
                total += getItemPrice(id) * b.getQuantity();
            }
        }
        return total;
    }

    public void update() {
        // just leave this method blank
        // it refreshes the page
    }
    
    public void clearBasket(){
        this.basketItems.removeAll(basketItems);
    }

}
