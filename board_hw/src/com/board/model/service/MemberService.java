package com.board.model.service;

import java.sql.Connection;

import com.board.common.JDBCTemplate;

public class MemberService {
	
	private static MemberService service;

	private MemberService() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberService getMemberService() {
		if(service==null) service=new MemberService();
		return service;
	}
	
	public void searchAll() {
		Connection conn= JDBCTemplate.getConnection();
		
	}
}
