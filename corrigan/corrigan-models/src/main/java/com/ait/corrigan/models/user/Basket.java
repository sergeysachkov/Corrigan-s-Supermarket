package com.ait.corrigan.models.user;

import java.util.List;
import java.util.Map;

import com.ait.corrigan.models.shop.Item;

public class Basket {
	private long basketID;
	private Customer customer;
	// Will it be better to have itemID in the Map
	// instead of the whole Item object?
	private List<Map<Item, Integer>> basketItem;

	public Basket() {
		super();
	}

	public Basket(long basketID, Customer customer, List<Map<Item, Integer>> basketItem) {
		super();
		this.basketID = basketID;
		this.customer = customer;
		this.basketItem = basketItem;
	}
}
