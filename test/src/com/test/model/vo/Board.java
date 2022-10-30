package com.test.model.vo;

import java.sql.Date;

public class Board {

	private int boardNum;
	private String title;
	private String content;
	private String writer;
	private Date enrollDate;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNum, String title, String content, String writer, Date enrollDate) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.enrollDate = enrollDate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
