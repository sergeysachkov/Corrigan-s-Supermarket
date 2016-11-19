package com.ait.corrigan.models.shop;

public class Item {
	private long itemID;
	private String name;
	private int stock_q;
	private String unit_of_measure;
	private String description;
	private int cateID;
	public Item() {
		super();
	}

    public Item(long itemID, String name, int stock_q, String unit_of_measure, String description, int cateID) {
        this.itemID = itemID;
        this.name = name;
        this.stock_q = stock_q;
        this.unit_of_measure = unit_of_measure;
        this.description = description;
        this.cateID = cateID;
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

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.itemID ^ (this.itemID >>> 32));
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + this.stock_q;
        hash = 97 * hash + (this.unit_of_measure != null ? this.unit_of_measure.hashCode() : 0);
        hash = 97 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 97 * hash + this.cateID;
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
        final Item other = (Item) obj;
        if (this.itemID != other.itemID) {
            return false;
        }
        if (this.stock_q != other.stock_q) {
            return false;
        }
        if (this.cateID != other.cateID) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.unit_of_measure == null) ? (other.unit_of_measure != null) : !this.unit_of_measure.equals(other.unit_of_measure)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }
        
}