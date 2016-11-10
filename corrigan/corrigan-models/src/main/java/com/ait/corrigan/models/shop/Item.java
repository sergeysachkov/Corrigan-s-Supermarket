package com.ait.corrigan.models.shop;

public class Item {
	private long itemID;
	private String name;
	private int stock_q;
	private String unit_of_measure;
	private String description;
	private Category category;
	public Item() {
		super();
	}
	public Item(long itemID, String name, int stock_q, String unit_of_measure, String description, Category category) {
		super();
		this.itemID = itemID;
		this.name = name;
		this.stock_q = stock_q;
		this.unit_of_measure = unit_of_measure;
		this.description = description;
		this.category = category;
	}
	public long getItemID() {
		return itemID;
	}
	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock_q() {
		return stock_q;
	}
	public void setStock_q(int stock_q) {
		this.stock_q = stock_q;
	}
	public String getUnit_of_measure() {
		return unit_of_measure;
	}
	public void setUnit_of_measure(String unit_of_measure) {
		this.unit_of_measure = unit_of_measure;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
