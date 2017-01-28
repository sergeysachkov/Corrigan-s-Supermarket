/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.models.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.util.Pair;

/**
 *
 * @author kfbb
 */
public class Basket {
   private long basketId;
   private long userId;
   // Pair<Item ID, Quantitiy of item>
   private List<Pair<Long, Integer>> items;
   
   public void addItem(long itemId, int quantity){
       Pair<Long,Integer> p=new Pair<>(itemId,quantity);
       this.items.add(p);
   }

    public Basket() {
        items=new ArrayList<>();
    }

    public Basket(long basketId, long userId, List<Pair<Long, Integer>> items) {
        this.basketId = basketId;
        this.userId = userId;
        this.items = items;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Pair<Long, Integer>> getItems() {
        return items;
    }

    public void setItems(List<Pair<Long, Integer>> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (int) (this.basketId ^ (this.basketId >>> 32));
        hash = 31 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 31 * hash + Objects.hashCode(this.items);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Basket other = (Basket) obj;
        if (this.basketId != other.basketId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Basket{" + "basketId=" + basketId + ", userId=" + userId + ", items=" + items + '}';
    }
   
}

