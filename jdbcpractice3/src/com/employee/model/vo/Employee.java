package com.employee.model.vo;

import java.sql.Date;

public class Employee {
	private String empId;
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String deptCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private int bonus;
	private String managerId;
	private Date hireDate;
	private Date entDate;
	private char entYn;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String empName, String empNo, String email, String phone, String deptCode,
			String jobCode, String salLevel, int salary, int bonus, String managerId, Date hireDate, Date entDate,
			char entYn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.deptCode = deptCode;
		this.jobCode = jobCode;
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

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getSalLevel() {
		return salLevel;
	}

	public void setSalLevel(String salLevel) {
		this.salLevel = salLevel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}

	public char getEntYn() {
		return entYn;
	}

	public void setEntYn(char entYn) {
		this.entYn = entYn;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empNo=" + empNo + ", email=" + email
				+ ", phone=" + phone + ", deptCode=" + deptCode + ", jobCode=" + jobCode + ", salLevel=" + salLevel
				+ ", salary=" + salary + ", bonus=" + bonus + ", managerId=" + managerId + ", hireDate=" + hireDate
				+ ", entDate=" + entDate + ", entYn=" + entYn + "]";
	}

	
}
