package com.employee.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.employee.common.JDBCTemplate;
import com.employee.model.vo.Department;
import com.employee.model.vo.Employee;
import com.employee.model.vo.Job;

public class EmployeeDao {
	private static EmployeeDao dao;
	private Properties prop = new Properties();
	
	private EmployeeDao() {
		try {
			prop.load(new FileReader("resources/sql/employee/employee_sql.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static EmployeeDao getDao() {
		if(dao==null) dao = new EmployeeDao();
		return dao;
	}

	public List<Employee> searchAllEmp(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("searchAllEmp"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getString("EMP_ID"));
				e.setEmpName(rs.getString("EMP_Name"));
				e.setEmpNo(rs.getString("EMP_NO"));
				e.setEmail(rs.getString("EMAIL"));
				e.setPhone(rs.getString("PHONE"));
				e.setDeptCode(rs.getString("DEPT_CODE"));
				e.setJobCode(rs.getString("JOB_CODE"));
				e.setSalLevel(rs.getString("SAL_LEVEL"));
				e.setSalary(rs.getInt("SALARY"));
				e.setBonus(rs.getInt("BONUS"));
				e.setManagerId(rs.getString("MANAGER_ID"));
				e.setHireDate(rs.getDate("HIRE_DATE"));
				e.setEntDate(rs.getDate("ENT_DATE"));
				e.setEntYn(rs.getString("ENT_YN").charAt(0));
				list.add(e);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public List<Department> searchAllDept(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("searchAllDept"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Department d = new Department();
				d.setDeptId(rs.getString("DEPT_ID"));
				d.setDeptTitle(rs.getString("DEPT_TITLE"));
				d.setLocationId(rs.getString("LOCATION_ID"));
				list.add(d);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	
	public List<Employee> searchDept(Connection conn, String searchDept) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchDept"));
			pstmt.setString(1,searchDept);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getString("EMP_ID"));
				e.setEmpName(rs.getString("EMP_Name"));
				e.setEmpNo(rs.getString("EMP_NO"));
				e.setEmail(rs.getString("EMAIL"));
				e.setPhone(rs.getString("PHONE"));
				e.setDeptCode(rs.getString("DEPT_CODE"));
				e.setJobCode(rs.getString("JOB_CODE"));
				e.setSalLevel(rs.getString("SAL_LEVEL"));
				e.setSalary(rs.getInt("SALARY"));
				e.setBonus(rs.getInt("BONUS"));
				e.setManagerId(rs.getString("MANAGER_ID"));
				e.setHireDate(rs.getDate("HIRE_DATE"));
				e.setEntDate(rs.getDate("ENT_DATE"));
				e.setEntYn(rs.getString("ENT_YN").charAt(0));
				list.add(e);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<Job> searchAllJob(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Job> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("searchAllJob"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Job j = new Job();
				j.setJobCode(rs.getString("JOB_CODE"));
				j.setJobName(rs.getString("JOB_NAME"));
				list.add(j);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<Employee> searchJob(Connection conn, String searchJob) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchJob"));
			pstmt.setString(1,searchJob);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getString("EMP_ID"));
				e.setEmpName(rs.getString("EMP_Name"));
				e.setEmpNo(rs.getString("EMP_NO"));
				e.setEmail(rs.getString("EMAIL"));
				e.setPhone(rs.getString("PHONE"));
				e.setDeptCode(rs.getString("DEPT_CODE"));
				e.setJobCode(rs.getString("JOB_CODE"));
				e.setSalLevel(rs.getString("SAL_LEVEL"));
				e.setSalary(rs.getInt("SALARY"));
				e.setBonus(rs.getInt("BONUS"));
				e.setManagerId(rs.getString("MANAGER_ID"));
				e.setHireDate(rs.getDate("HIRE_DATE"));
				e.setEntDate(rs.getDate("ENT_DATE"));
				e.setEntYn(rs.getString("ENT_YN").charAt(0));
				list.add(e);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<Employee> searchName(Connection conn, String searchName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchName"));
			pstmt.setString(1,"%"+searchName+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getString("EMP_ID"));
				e.setEmpName(rs.getString("EMP_Name"));
				e.setEmpNo(rs.getString("EMP_NO"));
				e.setEmail(rs.getString("EMAIL"));
				e.setPhone(rs.getString("PHONE"));
				e.setDeptCode(rs.getString("DEPT_CODE"));
				e.setJobCode(rs.getString("JOB_CODE"));
				e.setJobCode(rs.getString("SAL_LEVEL"));
				e.setSalary(rs.getInt("SALARY"));
				e.setBonus(rs.getInt("BONUS"));
				e.setManagerId(rs.getString("MANAGER_ID"));
				e.setHireDate(rs.getDate("HIRE_DATE"));
				e.setEntDate(rs.getDate("ENT_DATE"));
				e.setEntYn(rs.getString("ENT_YN").charAt(0));
				list.add(e);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<Employee> searchSal(Connection conn, int searchSal, String op) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList();
		try {
			if(op.equals("이상")) {
				pstmt=conn.prepareStatement(prop.getProperty("searchSal1"));
				
			}else {
				pstmt=conn.prepareStatement(prop.getProperty("searchSal2"));
			}
			pstmt.setInt(1,searchSal);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpId(rs.getString("EMP_ID"));
				e.setEmpName(rs.getString("EMP_Name"));
				e.setEmpNo(rs.getString("EMP_NO"));
				e.setEmail(rs.getString("EMAIL"));
				e.setPhone(rs.getString("PHONE"));
				e.setDeptCode(rs.getString("DEPT_CODE"));
				e.setJobCode(rs.getString("JOB_CODE"));
				e.setSalLevel(rs.getString("SAL_LEVEL"));
				e.setSalary(rs.getInt("SALARY"));
				e.setBonus(rs.getInt("BONUS"));
				e.setManagerId(rs.getString("MANAGER_ID"));
				e.setHireDate(rs.getDate("HIRE_DATE"));
				e.setEntDate(rs.getDate("ENT_DATE"));
				e.setEntYn(rs.getString("ENT_YN").charAt(0));
				list.add(e);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertEmp(Connection conn, Employee emp) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertEmp"));
			pstmt.setString(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDeptCode());
			pstmt.setString(7, emp.getJobCode());
			pstmt.setString(8, emp.getSalLevel());			
			pstmt.setInt(9, emp.getSalary());
			pstmt.setInt(10, emp.getBonus());
			pstmt.setString(11, emp.getManagerId());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateEmp(Connection conn, Employee emp) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateEmp"));
			pstmt.setString(1, emp.getJobCode());
			pstmt.setString(2, emp.getDeptCode());
			pstmt.setInt(3, emp.getSalary());
			pstmt.setString(4, emp.getPhone());
			pstmt.setString(5, emp.getEmail());
			pstmt.setString(6, emp.getEmpId());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteEmp(Connection conn, String deleteId) {
		PreparedStatement pstmt =null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteEmp"));
			pstmt.setString(1, deleteId);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertDept(Connection conn, Department d) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertDept"));
			pstmt.setString(1, d.getDeptId());
			pstmt.setString(2, d.getDeptTitle());
			pstmt.setString(3, d.getLocationId());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateDept(Connection conn, Department d) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateDept"));
			pstmt.setString(1, d.getDeptTitle());
			pstmt.setString(2, d.getLocationId());
			pstmt.setString(3, d.getDeptId());			
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteDept(Connection conn, String deleteId) {
		PreparedStatement pstmt =null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteDept"));
			pstmt.setString(1, deleteId);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertJob(Connection conn, Job j) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertJob"));
			pstmt.setString(1, j.getJobCode());
			pstmt.setString(2, j.getJobName());
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateJob(Connection conn, Job j) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateJob"));
			pstmt.setString(1, j.getJobName());
			pstmt.setString(2, j.getJobCode());			
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteJob(Connection conn, String deleteCode) {
		PreparedStatement pstmt =null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteJob"));
			pstmt.setString(1, deleteCode);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
}
