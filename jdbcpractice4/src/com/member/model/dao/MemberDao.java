package com.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.member.common.JDBCTemplate;
import com.member.model.vo.Board;
import com.member.model.vo.Member;

public class MemberDao {
	private static MemberDao dao;
	private Properties prop = new Properties();
	
	private MemberDao() {
		try {
			prop.load(new FileReader("resources/sql/member/member_sql.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getDao() {
		if(dao==null) dao = new MemberDao();
		return dao;
	}

	public List<Member> searchAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("searchAllMember"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setIdx(rs.getInt("IDX"));
				m.setMemberId(rs.getString("MEMBER_ID"));
				m.setMemberPwd(rs.getString("MEMBER_PWD"));
				m.setMemberName(rs.getString("MEMBER_NAME"));
				m.setEmail(rs.getString("EMAIL"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setPhone(rs.getString("PHONE"));			
				list.add(m);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<Member> searchId(Connection conn, String searchId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchId"));
			pstmt.setString(1,searchId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setIdx(rs.getInt("IDX"));
				m.setMemberId(rs.getString("MEMBER_ID"));
				m.setMemberPwd(rs.getString("MEMBER_PWD"));
				m.setMemberName(rs.getString("MEMBER_NAME"));
				m.setEmail(rs.getString("EMAIL"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setPhone(rs.getString("PHONE"));			
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<Member> searchName(Connection conn, String searchName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchName"));
			pstmt.setString(1,"%"+searchName+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setIdx(rs.getInt("IDX"));
				m.setMemberId(rs.getString("MEMBER_ID"));
				m.setMemberPwd(rs.getString("MEMBER_PWD"));
				m.setMemberName(rs.getString("MEMBER_NAME"));
				m.setEmail(rs.getString("EMAIL"));
				m.setAddress(rs.getString("ADDRESS"));
				m.setPhone(rs.getString("PHONE"));			
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertMember"));
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getPhone());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateMember"));
			pstmt.setString(1, m.getAddress());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setInt(4, m.getIdx());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, int deleteIdx) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteMember"));
			pstmt.setInt(1, deleteIdx);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Board> searchAllBoard(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(prop.getProperty("searchAllBoard"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setIdx(rs.getInt("IDX"));
				b.setDiv(rs.getString("DIV"));
				b.setTitle(rs.getString("TITLE"));
				b.setContents(rs.getString("CONTENTS"));
				b.setWriter(rs.getInt("WRITER"));
				b.setWriteDate(rs.getDate("WRITE_DATE"));
				list.add(b);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("insertBoard"));
			pstmt.setString(1, b.getDiv());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContents());
			pstmt.setInt(4, b.getWriter());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public List<Board> searchWriter(Connection conn, int writer) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchWriter"));
			pstmt.setInt(1,writer);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setIdx(rs.getInt("IDX"));
				b.setDiv(rs.getString("DIV"));
				b.setTitle(rs.getString("TITLE"));
				b.setContents(rs.getString("CONTENTS"));
				b.setWriter(rs.getInt("WRITER"));
				b.setWriteDate(rs.getDate("WRITE_DATE"));
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public List<Board> searchTitle(Connection conn, String title) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("searchTitle"));
			pstmt.setString(1,"%"+title+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setIdx(rs.getInt("IDX"));
				b.setDiv(rs.getString("DIV"));
				b.setTitle(rs.getString("TITLE"));
				b.setContents(rs.getString("CONTENTS"));
				b.setWriter(rs.getInt("WRITER"));
				b.setWriteDate(rs.getDate("WRITE_DATE"));
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("updateBoard"));
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContents());
			pstmt.setInt(3, b.getIdx());
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int deleteIdx) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt=conn.prepareStatement(prop.getProperty("deleteBoard"));
			pstmt.setInt(1, deleteIdx);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
}
