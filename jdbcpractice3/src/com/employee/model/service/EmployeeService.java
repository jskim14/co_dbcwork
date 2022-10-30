package com.employee.model.service;

import static com.employee.common.JDBCTemplate.close;
import static com.employee.common.JDBCTemplate.getConnection;
import static com.employee.model.dao.EmployeeDao.getDao;

import java.sql.Connection;
import java.util.List;

import com.employee.common.JDBCTemplate;
import com.employee.model.vo.Department;
import com.employee.model.vo.Employee;
import com.employee.model.vo.Job;

public class EmployeeService {
	private static EmployeeService service;
	private EmployeeService() {}
	public static EmployeeService getService() {
		if(service==null) service = new EmployeeService();
		return service;
	}
	public List<Employee> searchAllEmp() {
		Connection conn = getConnection();
		List<Employee> list = getDao().searchAllEmp(conn);
		close(conn);
		
		return list;
	}
	
	public List<Department> searchAllDept() {
		Connection conn = getConnection();
		List<Department> list = getDao().searchAllDept(conn);
		close(conn);
		
		return list;
	}
	
	public List<Job> searchAllJob() {
		Connection conn = getConnection();
		List<Job> list = getDao().searchAllJob(conn);
		close(conn);
		
		return list;
	}
	
	public List<Employee> searchDept(String searchDept) {
		Connection conn = getConnection();
		List<Employee> list = getDao().searchDept(conn, searchDept);
		close(conn);
		
		return list;
	}
	public List<Employee> searchJob(String searchJob) {
		Connection conn = getConnection();
		List<Employee> list = getDao().searchJob(conn, searchJob);
		close(conn);
		
		return list;
	}
	public List<Employee> searchName(String searchName) {
		Connection conn = getConnection();
		List<Employee> list = getDao().searchName(conn, searchName);
		close(conn);
		
		return list;
	}
	public List<Employee> searchSal(int searchSal, String op) {
		Connection conn = getConnection();
		List<Employee> list = getDao().searchSal(conn, searchSal, op);
		close(conn);
		
		return list;
	}
	public int insertEmp(Employee e) {
		Connection conn = getConnection();
		int result = getDao().insertEmp(conn,e);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
		
	}
	public int updateEmp(Employee e) {
		Connection conn = getConnection();
		int result = getDao().updateEmp(conn,e);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public int deleteEmp(String deleteId) {
		Connection conn = getConnection();
		int result = getDao().deleteEmp(conn,deleteId);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public int insertDepartment(Department d) {
		Connection conn = getConnection();
		int result = getDao().insertDept(conn,d);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public int updateDept(Department d) {
		Connection conn = getConnection();
		int result = getDao().updateDept(conn,d);
		close(conn);
		
		return result;
	}
	public int deleteDept(String deleteId) {
		Connection conn = getConnection();
		int result = getDao().deleteDept(conn,deleteId);
		close(conn);
		
		return result;
	}
	public int insertJob(Job j) {
		Connection conn = getConnection();
		int result = getDao().insertJob(conn,j);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public int updateJob(Job j) {
		Connection conn = getConnection();
		int result = getDao().updateJob(conn,j);
		close(conn);
		
		return result;
	}
	public int deleteJob(String deleteCode) {
		Connection conn = getConnection();
		int result = getDao().deleteJob(conn,deleteCode);
		close(conn);
		
		return result;
	}
	
	
	
}
