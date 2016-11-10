package com.ait.corrigan.models.user;

public class Order {
	private long orderID;
	private Customer customer;
	private Basket basket;

	public Order() {
		super();
	}

	public Order(long orderID, Customer customer, Basket basket) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.basket = basket;
	}
}
