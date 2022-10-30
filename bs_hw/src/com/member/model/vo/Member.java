package com.member.model.vo;

import java.sql.Date;

public class Member {

	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private Department dept;
	private Job job;
	private String salLevel;
	private String salary;
	private String bonus;
	private String managerId;
	private String hireDate;
	private String entDate;
	private String entYn;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String empId, String empName, String empNo, String email, String phone, Department dept, Job job,
			String salLevel, String salary, String bonus, String managerId, String hireDate, String entDate,
			String entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.dept = dept;
		this.job = job;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entYn = entYn;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getEntDate() {
		return entDate;
	}

	public void setEntDate(String entDate) {
		this.entDate = entDate;
	}

	public String getEntYn() {
		return entYn;
	}

	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}

	@Override
	public String toString() {
		return "Member [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email + ", phone="
				+ phone + ", dept=" + dept + ", job=" + job + ", salLevel=" + salLevel + ", salary=" + salary
				+ ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate + ", entDate=" + entDate
				+ ", entYn=" + entYn + "]";
	}

	
	
	
	
}
