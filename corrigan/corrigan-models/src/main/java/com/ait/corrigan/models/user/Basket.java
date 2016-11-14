package com.ait.corrigan.models.user;

import java.util.List;
import java.util.Map;

import com.ait.corrigan.models.shop.Item;

public class Basket {
	private long basketID;
	private Customer customer;
	private List<Map<Item, Integer>> basketItem;
	
	public Basket() {
		super();
	}
	public Basket(Customer customer, List<Map<Item, Integer>> basketItem) {
		super();
		this.customer = customer;
		this.basketItem = basketItem;
	}
	public Basket(long basketID, Customer customer, List<Map<Item, Integer>> basketItem) {
		super();
		this.basketID = basketID;
		this.customer = customer;
		this.basketItem = basketItem;
	}
	public long getBasketID() {
		return basketID;
	}
	public void setBasketID(long basketID) {
		this.basketID = basketID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Map<Item, Integer>> getBasketItem() {
		return basketItem;
	}
	public void setBasketItem(List<Map<Item, Integer>> basketItem) {
		this.basketItem = basketItem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (basketID ^ (basketID >>> 32));
		result = prime * result + ((basketItem == null) ? 0 : basketItem.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Basket other = (Basket) obj;
		if (basketID != other.basketID)
			return false;
		if (basketItem == null) {
			if (other.basketItem != null)
				return false;
		} else if (!basketItem.equals(other.basketItem))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Basket [basketID=" + basketID + ", customer=" + customer + ", basketItem=" + basketItem + "]";
	}
	


}
