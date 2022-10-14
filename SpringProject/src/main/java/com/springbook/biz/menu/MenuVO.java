package com.springbook.biz.menu;

import org.springframework.web.multipart.MultipartFile;

public class MenuVO {
	
	private int menuNum;
	private String menuName;
	private int menuPrice;
	private int store_Num;
	private String m_img;
	private MultipartFile menuImgUpload;
	
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
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	public MultipartFile getMenuImgUpload() {
		return menuImgUpload;
	}
	public void setMenuImgUpload(MultipartFile menuImgUpload) {
		this.menuImgUpload = menuImgUpload;
	}
	
	@Override
	public String toString() {
		return "MenuVO [menuNum=" + menuNum + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", store_Num="
				+ store_Num + ", m_img=" + m_img + ", menuImgUpload=" + menuImgUpload + "]";
	}
	
	
	
}
