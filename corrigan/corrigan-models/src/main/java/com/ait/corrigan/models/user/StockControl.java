package com.ait.corrigan.models.user;

public class StockControl {
	private long stockCID;
	private String userName;
	private String password;
	private String phoneNumber;
	public long getStockCID() {
		return stockCID;
	}
	public void setStockCID(long stockCID) {
		this.stockCID = stockCID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "StockControl [stockCID=" + stockCID + ", userName=" + userName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	

}
