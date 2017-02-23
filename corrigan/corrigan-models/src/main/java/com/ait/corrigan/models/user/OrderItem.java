package com.ait.corrigan.models.user;

/**
 *
 * @author Joshua<iyezi@hotmail.com>
 */
public class OrderItem {
    long orderId;
    long itemId;
    int quantity;

    public OrderItem(long orderId, long itemId, int quantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public OrderItem() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
        int hash = 3;
        hash = 47 * hash + (int) (this.orderId ^ (this.orderId >>> 32));
        hash = 47 * hash + (int) (this.itemId ^ (this.itemId >>> 32));
        hash = 47 * hash + this.quantity;
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
        final OrderItem other = (OrderItem) obj;
        if (this.orderId != other.orderId) {
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
        return "OrderItem{" + "orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + '}';
    }
    
}

