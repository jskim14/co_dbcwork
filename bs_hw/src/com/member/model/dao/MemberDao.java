package com.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.member.common.JDBCTemplate;
import com.member.model.vo.Department;
import com.member.model.vo.Job;
import com.member.model.vo.Member;

public class MemberDao {
	
	private static MemberDao dao;
	
	private Properties props= new Properties();
	
	private MemberDao() {
		try {
			props.load(new FileReader("resource/member_sql.properties"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getDao() {
		if(dao==null) dao=new MemberDao();
		return dao;
	}
	
	public ArrayList<Member> searchAll(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Member> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(props.getProperty("memberAll"));
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member m= new Member();
				m.setEmpId(rs.getString("EMP_ID"));
				m.setEmpName(rs.getString("EMP_NAME"));
				m.setEmpNo(rs.getString("EMP_NO"));
				m.setEmail(rs.getString("EMAIL"));
				m.setPhone(rs.getString("PHONE"));
				m.setDept(new Department(rs.getString("DEPT_ID"),rs.getString("DEPT_TITLE"), rs.getString("LOCATION_ID")));
				m.setJob(new Job(rs.getString("JOB_CODE"),rs.getString("JOB_NAME")));
				m.setSalLevel(rs.getString("SAL_LEVEL"));
				m.setSalary(rs.getString("SALARY"));
				m.setBonus(rs.getString("BONUS"));
				m.setManagerId(rs.getString("MANAGER_ID"));
				m.setHireDate(rs.getString("HIRE_DATE"));
				m.setEntDate(rs.getString("ENT_DATE"));
				m.setEntYn(rs.getString("ENT_YN"));
				list.add(m);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Member> searchDept(Connection conn, String str) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Member> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(props.getProperty("searchDept"));
			pstmt.setString(1, "%"+str+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member m= new Member();
				m.setEmpId(rs.getString("EMP_ID"));
				m.setEmpName(rs.getString("EMP_NAME"));
				m.setEmpNo(rs.getString("EMP_NO"));
				m.setEmail(rs.getString("EMAIL"));
				m.setPhone(rs.getString("PHONE"));
				m.setDept(new Department(rs.getString("DEPT_ID"),rs.getString("DEPT_TITLE"), rs.getString("LOCATION_ID")));
				m.setJob(new Job(rs.getString("JOB_CODE"),rs.getString("JOB_NAME")));
				m.setSalLevel(rs.getString("SAL_LEVEL"));
				m.setSalary(rs.getString("SALARY"));
				m.setBonus(rs.getString("BONUS"));
				m.setManagerId(rs.getString("MANAGER_ID"));
				m.setHireDate(rs.getString("HIRE_DATE"));
				m.setEntDate(rs.getString("ENT_DATE"));
				m.setEntYn(rs.getString("ENT_YN"));
				list.add(m);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Department> deptList(Connection conn) { //부서전체 
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Department> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(props.getProperty("deptAll"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Department d= new Department();
				d.setDeptId(rs.getString("DEPT_ID"));
				d.setDeptTitle(rs.getString("dept_title"));
				d.setLocationId(rs.getString("location_id"));
				list.add(d);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Member> searchJob(Connection conn, String str) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Member> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(props.getProperty("searchJob"));
			pstmt.setString(1, "%"+str+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member m= new Member();
				m.setEmpId(rs.getString("EMP_ID"));
				m.setEmpName(rs.getString("EMP_NAME"));
				m.setEmpNo(rs.getString("EMP_NO"));
				m.setEmail(rs.getString("EMAIL"));
				m.setPhone(rs.getString("PHONE"));
				m.setDept(new Department(rs.getString("DEPT_ID"),rs.getString("DEPT_TITLE"), rs.getString("LOCATION_ID")));
				m.setJob(new Job(rs.getString("JOB_CODE"),rs.getString("JOB_NAME")));
				m.setSalLevel(rs.getString("SAL_LEVEL"));
				m.setSalary(rs.getString("SALARY"));
				m.setBonus(rs.getString("BONUS"));
				m.setManagerId(rs.getString("MANAGER_ID"));
				m.setHireDate(rs.getString("HIRE_DATE"));
				m.setEntDate(rs.getString("ENT_DATE"));
				m.setEntYn(rs.getString("ENT_YN"));
				list.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Job> jobList(Connection conn) { //직책전체 
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Job> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(props.getProperty("jobAll"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Job j= new Job();
				j.setJobCode(rs.getString("JOB_CODE"));
				j.setJobName(rs.getString("JOB_NAME"));
				list.add(j);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Member> searchName(Connection conn, String str) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Member> list = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(props.getProperty("searchName"));
			pstmt.setString(1, "%"+str+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Member m= new Member();
				m.setEmpId(rs.getString("EMP_ID"));
				m.setEmpName(rs.getString("EMP_NAME"));
				m.setEmpNo(rs.getString("EMP_NO"));
				m.setEmail(rs.getString("EMAIL"));
				m.setPhone(rs.getString("PHONE"));
				m.setDept(new Department(rs.getString("DEPT_ID"),rs.getString("DEPT_TITLE"), rs.getString("LOCATION_ID")));
				m.setJob(new Job(rs.getString("JOB_CODE"),rs.getString("JOB_NAME")));
				m.setSalLevel(rs.getString("SAL_LEVEL"));
				m.setSalary(rs.getString("SALARY"));
				m.setBonus(rs.getString("BONUS"));
				m.setManagerId(rs.getString("MANAGER_ID"));
				m.setHireDate(rs.getString("HIRE_DATE"));
				m.setEntDate(rs.getString("ENT_DATE"));
				m.setEntYn(rs.getString("ENT_YN"));
				list.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public int inputData(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(props.getProperty("insertMember"));
			pstmt.setString(1, m.getEmpId());
			pstmt.setString(2, m.getEmpName());
			pstmt.setString(3, m.getEmpNo());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getDept().getDeptId());
			pstmt.setString(7, m.getJob().getJobCode());
			pstmt.setString(8, m.getSalLevel());
			pstmt.setInt(9, Integer.parseInt(m.getSalary()));
			pstmt.setInt(10, Integer.parseInt(m.getBonus()));
			pstmt.setString(11, m.getManagerId());
			pstmt.setString(12, m.getHireDate());
			pstmt.setString(13, m.getEntDate());
			pstmt.setString(14, m.getEntYn());
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		} 
		
		return result;
	}
	
	public int searchId(Connection conn, String id) { //delete
		PreparedStatement pstmt=null;
		int result= 0;
		
		try {
			pstmt=conn.prepareStatement(props.getProperty("searchId"));
			pstmt.setString(1, id);
			result=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		} 
		return result;
	}
	
	public int update(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result= 0;
		try {
			pstmt=conn.prepareStatement(props.getProperty("update"));
			pstmt.setString(1, m.getJob().getJobCode());
			pstmt.setString(2, m.getDept().getDeptId());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getSalary());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getEmpId());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		} 
		return result;
		
	}

}
