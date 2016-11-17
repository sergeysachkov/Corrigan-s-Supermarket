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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (itemID ^ (itemID >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stock_q;
		result = prime * result + ((unit_of_measure == null) ? 0 : unit_of_measure.hashCode());
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
		Item other = (Item) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (itemID != other.itemID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stock_q != other.stock_q)
			return false;
		if (unit_of_measure == null) {
			if (other.unit_of_measure != null)
				return false;
		} else if (!unit_of_measure.equals(other.unit_of_measure))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item {itemID=" + itemID + 
				", name=" + name + 
				", stock_q=" + stock_q + 
				", unit_of_measure=" + unit_of_measure + 
				", description=" + description + 
				", category=" + category + 
				"}";
	}
	
}
