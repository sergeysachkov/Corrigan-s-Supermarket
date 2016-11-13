package com.ait.corrigan.models.user;

import java.util.List;
import java.util.Map;

import com.ait.corrigan.models.shop.Item;

public class Basket {
	private long basketID;
	private Customer customer;
	private List<Map<Item, Integer>> basketItem;
	private int quantity;

	public Basket() {
		super();
	}

	public Basket(long basketID, Customer customer, List<Map<Item, Integer>> basketItem, int quantity) {
		super();
		this.basketID = basketID;
		this.customer = customer;
		this.basketItem = basketItem;
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
