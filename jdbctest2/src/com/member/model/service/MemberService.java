package com.member.model.service;

import java.sql.Connection;
import java.util.List;

import static com.member.common.JdbcTemplate.getConnection;
import static com.member.common.JdbcTemplate.close;

import com.member.common.JdbcTemplate;
import com.member.model.vo.Member;
import static com.member.model.dao.MemberDao.getDao;

public class MemberService {

	//서비스의 역할
	//1. Connection 객체를 관리 생성, 반환
	//2. 트랜젝션 관리를 담당, commit, rollback처리 
	
	private static MemberService service;
	
	public static MemberService getService() {
		if(service==null) service=new MemberService();
		return service;
	}
	
	public List<Member> searchAll() {
		
//		Connection conn=JdbcTemplete.getConnection();
		Connection conn=getConnection(); // static import 사용 
		List<Member>list = getDao().searchAll(conn);
		//Connection을 관리하는 곳이기 때문에 이곳에서 connection객체를 반환
		close(conn);
		return list;
	}	
	public Member searchId(String id) {
		Connection conn=getConnection();
		Member m = getDao().searchId(conn, id);
		
		return m;
	}
	
	public List<Member> searchName(String name) {
		Connection conn=getConnection();
		List<Member>list = getDao().searchName(conn, name);
		close(conn);
		
		return list;
	}
	
	public int insertMember(Member m) {
		//DML -> 트랜잭션 처리를 해야함. 
		//connection 객체를 관리하고 있기 때문에 이곳에서 트랜젝션도 같이 관리해야함. 
		Connection conn=getConnection();
		int result= getDao().insertMember(conn,m);
		//result = getDao().updateAttachement(conn,20);
		//connection을 반환하기 전 dml구문에 대해 트랜젝션 처리 (commit, rollback)
		if(result>0) JdbcTemplate.commit(conn);
		else JdbcTemplate.rollback(conn);
		close(conn);
		return result;
		
	}
		
}
