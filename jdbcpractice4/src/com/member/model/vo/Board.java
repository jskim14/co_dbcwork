package com.member.model.vo;

import java.sql.Date;

public class Board {
	private int idx;
	private String div;
	private String title;
	private String contents;
	private int writer;
	private Date writeDate;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int idx, String div, String title, String contents, int writer, Date writeDate) {
		super();
		this.idx = idx;
		this.div = div;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", div=" + div + ", title=" + title + ", contents=" + contents + ", writer="
				+ writer + ", writeDate=" + writeDate + "]";
	}

	
	
	
}
