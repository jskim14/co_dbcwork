package com.scott.mode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scott.mode.vo.Employee;

public class EmpDao {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "SCOTT";
	private String password = "TIGER";
	
	
	public ArrayList<Employee> allList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Employee> list = new ArrayList<>();
		String sql= "SELECT * FROM EMP";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt= conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Employee e= new Employee();
				e.setEmpNo(rs.getString("EMPNO"));
				e.seteName(rs.getString("ENAME"));
				e.setJob(rs.getString("MGR"));
				e.setMGR(rs.getString("MGR"));
				e.setHireDate(rs.getDate("HIREDATE"));
				e.setSal(rs.getInt("SAL"));
				e.setComm(rs.getInt("COMM"));
				e.setDeptNo(rs.getInt("DEPTNO"));
				list.add(e);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public Employee searchName(String name) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Employee emp=new Employee();
		String sql="SELECT * FROM EMP WHERE ENAME = ?";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				emp=new Employee();
				emp.setEmpNo(rs.getString("EMPNO"));
				emp.seteName(rs.getString("ENAME"));
				emp.setJob(rs.getString("MGR"));
				emp.setMGR(rs.getString("MGR"));
				emp.setHireDate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getInt("SAL"));
				emp.setComm(rs.getInt("COMM"));
				emp.setDeptNo(rs.getInt("DEPTNO"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
		
	}
	
	public void searchSalary(int salary) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Employee emp=new Employee();
		String sql="SELECT * FROM EMP WHERE sal=?";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				emp=new Employee();
				emp.setEmpNo(rs.getString("EMPNO"));
				emp.seteName(rs.getString("ENAME"));
				emp.setJob(rs.getString("MGR"));
				emp.setMGR(rs.getString("MGR"));
				emp.setHireDate(rs.getDate("HIREDATE"));
				emp.setSal(rs.getInt("SAL"));
				emp.setComm(rs.getInt("COMM"));
				emp.setDeptNo(rs.getInt("DEPTNO"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
//		return emp;
	}

}
