package com.springbook.biz.board;

import java.util.Date;

public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int store_Num;
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getStore_Num() {
		return store_Num;
	}
	public void setStore_Num(int store_Num) {
		this.store_Num = store_Num;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardContent=" + boardContent + ", boardDate=" + boardDate 
				+ ", store_Num=" + store_Num + "]";
	}
	
	
	
	
}