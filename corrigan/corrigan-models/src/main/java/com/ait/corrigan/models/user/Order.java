package com.ait.corrigan.models.user;

public class Order {
	private long orderId;
	private long userId;
	private long basketId;
        private double price;

    public Order() {
    }

    public Order(long orderId, long userId, long basketId, double price) {
        this.orderId = orderId;
        this.userId = userId;
        this.basketId = basketId;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.orderId ^ (this.orderId >>> 32));
        hash = 17 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 17 * hash + (int) (this.basketId ^ (this.basketId >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", userId=" + userId + ", basketId=" + basketId + ", price=" + price + '}';
    }



}
