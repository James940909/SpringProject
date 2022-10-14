package com.springbook.biz.review;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVO {
	
	private int reviewNum;
	private String reviewWriter;
	private float reviewScore;
	private String reviewContent;
	private String reviewDate;
	private int store_Num;
	private String r_img;
	private MultipartFile reviewImgUpload;
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public float getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(float reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getStore_Num() {
		return store_Num;
	}
	public void setStore_Num(int store_Num) {
		this.store_Num = store_Num;
	}
	public String getR_img() {
		return r_img;
	}
	public void setR_img(String r_img) {
		this.r_img = r_img;
	}
	public MultipartFile getReviewImgUpload() {
		return reviewImgUpload;
	}
	public void setReviewImgUpload(MultipartFile reviewImgUpload) {
		this.reviewImgUpload = reviewImgUpload;
	}

	@Override
	public String toString() {
		return "ReviewVO [reviewNum=" + reviewNum + ", reviewWriter=" + reviewWriter + ", reviewScore=" + reviewScore
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", store_Num=" + store_Num
				+ ", r_img=" + r_img + ", reviewImgUpload=" + reviewImgUpload + "]";
	}
	
	
}
