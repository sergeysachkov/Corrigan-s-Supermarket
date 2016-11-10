package com.ait.corrigan.models.shop;

public class Category {
	private int cateID;
	private int cate_name;
	public Category() {
		super();
	}
	public Category(int cateID, int cate_name) {
		super();
		this.cateID = cateID;
		this.cate_name = cate_name;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public int getCate_name() {
		return cate_name;
	}
	public void setCate_name(int cate_name) {
		this.cate_name = cate_name;
	}
}
