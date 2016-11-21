package com.ait.corrigan.models.user;

import java.util.Map;

import com.ait.corrigan.models.shop.Item;

public class Basket {
	private long basketId;
	private long userId;
	private long itemId;
        private int quantity;
	
	public Basket() {
		super();
	}

    public Basket(long basketId, long userId, long itemId, int quantity) {
        this.basketId = basketId;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
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

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Basket{" + "basketId=" + basketId + ", userId=" + userId + ", itemId=" + itemId + ", quantity=" + quantity + '}';
    }
}