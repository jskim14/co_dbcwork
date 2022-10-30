package com.scott.model.vo;

import java.sql.Date;

public class Employee {
	private String empNo;
	private String eName;
	private String job;
	private String MGR;
	private Date hireDate;
	private int sal;
	private int comm;
	private int deptNo;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empNo, String eName, String job, String mGR, Date hireDate, int sal, int comm, int deptNo) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		MGR = mGR;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptNo = deptNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMGR() {
		return MGR;
	}

	public void setMGR(String mGR) {
		MGR = mGR;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", MGR=" + MGR + ", hireDate="
				+ hireDate + ", sal=" + sal + ", comm=" + comm + ", deptNo=" + deptNo + "]";
	}
	
	
	
}
