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

	public Basket getBasket() {
		return basket;
	}

	public Customer getCustomer() {
		return customer;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
}
