package com.springbook.biz.menu;

public class MenuVO {
	
	private int menuNum;
	private String menuName;
	private int menuPrice;
	private int store_Num;
	
	public int getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getStore_Num() {
		return store_Num;
	}
	public void setStore_Num(int store_Num) {
		this.store_Num = store_Num;
	}
	
	@Override
	public String toString() {
		return "MenuVO [menuNum=" + menuNum + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", store_Num="
				+ store_Num + "]";
	}
	
}
