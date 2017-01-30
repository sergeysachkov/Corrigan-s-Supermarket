package com.ait.corrigan.models.user;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {
	private long orderId;
	private long userId;
	private long basketId;
        private double price;
        private String status;
        private Timestamp time;

    public Order() {
    }

    public Order(long orderId, long userId, long basketId, double price, String status, Timestamp time) {
        this.orderId = orderId;
        this.userId = userId;
        this.basketId = basketId;
        this.price = price;
        this.status = status;
        this.time = time;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.orderId ^ (this.orderId >>> 32));
        hash = 59 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 59 * hash + (int) (this.basketId ^ (this.basketId >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.time);
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
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", userId=" + userId + ", basketId=" + basketId + ", price=" + price + ", status=" + status + ", time=" + time + '}';
    }
}
