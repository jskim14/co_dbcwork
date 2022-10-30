package com.member.model.service;

import static com.member.common.JDBCTemplate.close;
import static com.member.common.JDBCTemplate.getConnection;
import static com.member.model.dao.MemberDao.getDao;

import java.sql.Connection;
import java.util.ArrayList;

import com.member.common.JDBCTemplate;
import com.member.model.vo.Department;
import com.member.model.vo.Job;
import com.member.model.vo.Member;

public class MemberService {

	private static MemberService service;
	
	public static MemberService getService() {
		if(service==null) service=new MemberService();
		return service;
	}
	
	public ArrayList<Member> searchAll() {
		Connection conn = getConnection();
		ArrayList<Member>list =getDao().searchAll(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Member> searchDept(String str) {
		Connection conn = getConnection();
		ArrayList<Member>list =getDao().searchDept(conn, str);
		close(conn);
		return list;
	}
	
	public ArrayList<Department> deptList() { //아니그럼..
		Connection conn = getConnection();
		ArrayList<Department>list =getDao().deptList(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Member> searchJob(String str) {
		Connection conn = getConnection();
		ArrayList<Member>list =getDao().searchJob(conn, str);
		close(conn);
		return list;
	}
	
	public ArrayList<Job> jobList() { //아니그럼..
		Connection conn = getConnection();
		ArrayList<Job>list =getDao().jobList(conn);
		close(conn);
		return list;
	}
	
	public ArrayList<Member> searchName(String str) {
		Connection conn = getConnection();
		ArrayList<Member>list =getDao().searchName(conn,str);
		close(conn);
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn= getConnection();
		int result=getDao().inputData(conn,m);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		return result;
	}
	
	public int searchId(String str) {
		Connection conn = getConnection();
		int result = getDao().searchId(conn,str);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		return result;
	}
	
	public int update(Member m) {
		Connection conn = getConnection();
		int result = getDao().update(conn,m);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		return result;
	}
	
}
