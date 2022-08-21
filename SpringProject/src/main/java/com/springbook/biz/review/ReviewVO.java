package com.springbook.biz.review;


public class ReviewVO {
	
	private int reviewNum;
	private String reviewWriter;
	private float reviewScore;
	private String reviewContent;
	private String reviewDate;
	private int store_Num;
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
	@Override
	public String toString() {
		return "ReviewVO [reviewNum=" + reviewNum + ", reviewWriter=" + reviewWriter + ", reviewScore=" + reviewScore
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", store_Num=" + store_Num + "]";
	}
	
	
	
}
