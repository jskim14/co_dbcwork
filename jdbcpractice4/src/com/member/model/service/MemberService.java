package com.member.model.service;

import static com.member.common.JDBCTemplate.close;
import static com.member.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import static com.member.model.dao.MemberDao.getDao;

import com.member.common.JDBCTemplate;
import com.member.model.vo.Board;
import com.member.model.vo.Member;

public class MemberService {
	private static MemberService service;
	private MemberService() {}
	public static MemberService getService() {
		if(service==null) service = new MemberService();
		return service;
	}
	public List<Member> searchAllMember() {
		Connection conn = getConnection();
		List<Member> list = getDao().searchAllMember(conn);
		close(conn);
		return list;
	}
	public List<Member> searchId(String searchId) {
		Connection conn = getConnection();
		List<Member> list = getDao().searchId(conn,searchId);
		close(conn);
		return list;
	}
	public List<Member> searchName(String searchName) {
		Connection conn = getConnection();
		List<Member> list = getDao().searchName(conn,searchName);
		close(conn);
		return list;
	}
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = getDao().insertMember(conn,m);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = getDao().updateMember(conn,m);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public int deleteMember(int deleteIdx) {
		Connection conn = getConnection();
		int result = getDao().deleteMember(conn,deleteIdx);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public List<Board> searchAllBoard() {
		Connection conn = getConnection();
		List<Board> list = getDao().searchAllBoard(conn);
		close(conn);
		return list;
	}
	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = getDao().insertBoard(conn,b);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public List<Board> searchWriter(int writer) {
		Connection conn = getConnection();
		List<Board> list = getDao().searchWriter(conn,writer);
		close(conn);
		return list;
	}
	public List<Board> searchTitle(String title) {
		Connection conn = getConnection();
		List<Board> list = getDao().searchTitle(conn,title);
		close(conn);
		return list;
	}
	public int updateBoard(Board b) {
		Connection conn = getConnection();
		int result = getDao().updateBoard(conn,b);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	public int deleteBoard(int deleteIdx) {
		Connection conn = getConnection();
		int result = getDao().deleteBoard(conn,deleteIdx);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		close(conn);
		
		return result;
	}
	
	
	
}
