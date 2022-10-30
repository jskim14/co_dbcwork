package com.board.model.vo;

import java.sql.Date;

public class Member {
	private String idx;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private String phone;
	private Date enrollDate;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String idx, String id, String pwd, String name, String email, String address, String phone,
			Date enrollDate) {
		super();
		this.idx = idx;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	
}
