package com.ait.corrigan.models.user;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Order {
	private long orderId;
	private long customerId;
        private double price;
        private String status;
        private Timestamp time;
        private List<OrderItem> OrderItems;
    public Order() {
    }

    public Order(long orderId, long customerId, double price, String status, Timestamp time) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.price = price;
        this.status = status;
        this.time = time;
    }

    public Order(long orderId, long customerId, double price, String status, Timestamp time, List<OrderItem> OrderItems) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.price = price;
        this.status = status;
        this.time = time;
        this.OrderItems = OrderItems;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

    public List<OrderItem> getOrderItems() {
        return OrderItems;
    }

    public void setOrderItems(List<OrderItem> OrderItems) {
        this.OrderItems = OrderItems;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.orderId ^ (this.orderId >>> 32));
        hash = 13 * hash + (int) (this.customerId ^ (this.customerId >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.status);
        hash = 13 * hash + Objects.hashCode(this.time);
        hash = 13 * hash + Objects.hashCode(this.OrderItems);
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
        if (this.customerId != other.customerId) {
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
        if (!Objects.equals(this.OrderItems, other.OrderItems)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", price=" + price + ", status=" + status + ", time=" + time + ", OrderItems=" + OrderItems + '}';
    }
    
    
}
