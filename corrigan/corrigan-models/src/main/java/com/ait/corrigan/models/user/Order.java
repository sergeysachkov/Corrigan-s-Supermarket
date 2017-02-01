package com.ait.corrigan.models.user;

public class Order {
	private long orderId;
	private long userId;
	private long basketId;

    public Order() {
    }

    public Order(long orderId, long userId, long basketId) {
        this.orderId = orderId;
        this.userId = userId;
        this.basketId = basketId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
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
        final Order other = (Order) obj;
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.basketId != other.basketId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", userId=" + userId + ", basketId=" + basketId + '}';
    }


}
