
package com.ait.corrigan.models.shop;

public class Category {
	private int cateID;
	private String cate_name;

	public Category() {
		super();
	}

	public Category(int cateID, String cate_name) {
		super();
		this.cateID = cateID;
		this.cate_name = cate_name;
	}
	
	public Category(String cate_name) {
		super();
		this.cate_name = cate_name;
	}


	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cateID;
		result = prime * result + ((cate_name == null) ? 0 : cate_name.hashCode());
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
		Category other = (Category) obj;
		if (cateID != other.cateID)
			return false;
		if (cate_name == null) {
			if (other.cate_name != null)
				return false;
		} else if (!cate_name.equals(other.cate_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return cateID + ": " + cate_name;
	}

	
	
}
/*
package com.ait.corrigan.models.shop;

public class Category {
	private int cateID;
	private String cate_name;

	public Category() {
		super();
	}

	public Category(int cateID, String cate_name) {
		super();
		this.cateID = cateID;
		this.cate_name = cate_name;
	}
	
	public Category(String cate_name) {
		super();
		this.cate_name = cate_name;
	}

	public String getCate_name() {
		return cate_name;
	}

	public int getCateID() {
		return cateID;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cateID;
		result = prime * result + ((cate_name == null) ? 0 : cate_name.hashCode());
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
		Category other = (Category) obj;
		if (cateID != other.cateID)
			return false;
		if (cate_name == null) {
			if (other.cate_name != null)
				return false;
		} else if (!cate_name.equals(other.cate_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return cateID + ": " + cate_name;
	}

	
	
}
*/
