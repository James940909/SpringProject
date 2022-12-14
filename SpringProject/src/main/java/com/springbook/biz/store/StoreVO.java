package com.springbook.biz.store;


public class StoreVO {
	
	private int storeNum;
	private String storeId;
	private String storePw;
	private String storeName;
	private String storeCategory;
	private String storePhone;
	private String storeAddress;
	private String signUpDate;
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStorePw() {
		return storePw;
	}
	public void setStorePw(String storePw) {
		this.storePw = storePw;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreCategory() {
		return storeCategory;
	}
	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public String getSignUpDate() {
		return signUpDate;
	}
	public void setSignUpDate(String signUpDate) {
		this.signUpDate = signUpDate;
	}
	@Override
	public String toString() {
		return "StoreVO [storeNum=" + storeNum + ", storeId=" + storeId + ", storePw=" + storePw + ", storeName="
				+ storeName + ", storeCategory=" + storeCategory + ", storePhone=" + storePhone + ", storeAddress="
				+ storeAddress + ", signUpDate=" + signUpDate + "]";
	}
	
	
}
