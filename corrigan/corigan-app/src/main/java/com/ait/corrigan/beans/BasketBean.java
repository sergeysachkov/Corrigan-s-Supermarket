/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.beans;

import com.ait.corrigan.models.shop.Item;
import com.ait.corrigan.models.user.Basket;
import com.ait.corrigan.services.BasketService;
import com.ait.corrigan.services.BasketServiceImpl;
import com.ait.corrigan.services.ItemService;
import com.ait.corrigan.services.ItemServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
    private long basketId = 0;
    private List<Basket> basketItems;
    private double total;

    private BasketService bsktService;
    private static final Logger LOG = Logger.getLogger(BasketBean.class.getName());

    public BasketBean() {
//        LOG.log(Level.INFO, "constructor called.");
        bsktService = new BasketServiceImpl();
        basketId = bsktService.createBasket(0).getBasketId();
        basketItems=new ArrayList<>();
    }

    public long getBasketId() {
        return basketId;
    }


    public String addToBasket(Item item) {
        //TODO validate fields of Basket item2Add
        for (Basket b : basketItems) {
            if (b.getItemId() == item.getItemID()) {
                // already in the basket   
                b.setQuantity(b.getQuantity() + 1);
                return "basket?faces-redirect=true";
            }
        }
        //TODO user id
        Basket tmpBasket=new Basket(basketId, 0, item.getItemID(), 1);
        LOG.log(Level.INFO,tmpBasket.toString());
        basketItems.add(tmpBasket);
                return "basket?faces-redirect=true";
    }
    public String deleteFromBasket(Basket basket){
        basketItems.remove(basket);
        return "basket";
        
    }
    public List<Basket> getBasketItems() {
        return basketItems;
    }

    public String getItemName(long itemId) {
        ItemService iservice = new ItemServiceImpl();
        return iservice.getItem(itemId).getName();
    }

    public double getItemPrice(long itemId) {
        //unfortunately for now we're selling everything for free

        return 0;
    }
    public void update(){
        
    }
    public static void main(String[] args) {
        BasketBean bb = new BasketBean();
        System.out.println("basket uuid=" + bb.getBasketId());
    }
}
