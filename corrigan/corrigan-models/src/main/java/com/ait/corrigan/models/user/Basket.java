package com.ait.corrigan.models.user;

import java.util.Map;

import com.ait.corrigan.models.shop.Item;

public class Basket {
	private long basketID;
	private Customer customer;
	private Map<Item, Integer> basketItems;
	
	public Basket() {
		super();
	}

	public Basket(long basketID, Customer customer, Map<Item, Integer> basketItems) {
		super();
		this.basketID = basketID;
		this.customer = customer;
		this.basketItems = basketItems;
	}

	public Basket(Customer customer, Map<Item, Integer> basketItems) {
		super();
		this.customer = customer;
		this.basketItems = basketItems;
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

	public Map<Item, Integer> getBasketItems() {
		return basketItems;
	}

	public void setBasketItems(Map<Item, Integer> basketItems) {
		this.basketItems = basketItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (basketID ^ (basketID >>> 32));
		result = prime * result + ((basketItems == null) ? 0 : basketItems.hashCode());
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
		if (basketItems == null) {
			if (other.basketItems != null)
				return false;
		} else if (!basketItems.equals(other.basketItems))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
	
}