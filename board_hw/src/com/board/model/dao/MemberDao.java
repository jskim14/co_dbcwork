package com.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MemberDao {
	
	private static MemberDao dao;
	private Properties props= new Properties();
	private MemberDao() {
		try {
			props.load(new FileReader("resources/sql/member/member_sql.properties"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getMemberDao() {
		if(dao==null) dao=new MemberDao();
		return dao;
	}
	
	
	
	

}
