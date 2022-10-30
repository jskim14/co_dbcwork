package com.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.member.common.JdbcTemplate;
import com.member.model.vo.Member;

public class MemberDao {

	private static MemberDao dao;
	
	private Properties props = new Properties();
	
	private MemberDao() {
		try {
			props.load(new FileReader("resources/sql/member/member_sql.properties")); //소스폴더만들어서 했으면 이렇게 접근..?
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getDao() {
		if(dao==null) dao = new MemberDao();
		return dao;
	}
	
	public List<Member> searchAll(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
//		String sql="SELECT * FROM MEMBER";
		List<Member> list = new ArrayList();
		
		try {
//			pstmt=conn.prepareStatement(sql);
			pstmt=conn.prepareStatement(props.getProperty("memberAll"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender").charAt(0));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby").split(","));
				m.setEnrollDate(rs.getDate("enroll_date"));
				list.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return list;
	}
	
	public Member searchId(Connection conn, String id) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql="SELECT * FROM MEMBER WHERE MEMBER_id= ? ";
		Member m= null; //여기에서 new로 생성하면 뷰 조건문에서 null에 못걸리지~ 
		
		try {
//			pstmt=conn.prepareStatement(sql);
			pstmt=conn.prepareStatement(props.getProperty("searchId"));
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) { 
				m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender").charAt(0));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby").split(","));
				m.setEnrollDate(rs.getDate("enroll_date"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return m;
	}
	
	public List<Member> searchName(Connection conn, String name) {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		//String sql="SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE '%'||?||'%' ";
		String sql="SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE ? ";
		List<Member> list = new ArrayList();
		
		try {
//			pstmt=conn.prepareStatement(sql);
			pstmt=conn.prepareStatement(props.getProperty("searchName"));
			
			//pstmt.setString(1, name);
			pstmt.setString(1, "%"+name+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) { 
				Member m = new Member();
				//rs.get~ (인덱스 번호 가능) 그러나..추천하진 않는다 ! 
				m.setMemberId(rs.getString(1));
//				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender").charAt(0));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby").split(","));
				m.setEnrollDate(rs.getDate("enroll_date"));
				list.add(m);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return list;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		try {
			pstmt=conn.prepareStatement(sql);
			//위치홀더값 세팅이 먼저 -> execute
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, String.valueOf(m.getGender())); // char를 string으로 바꿔
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, String.join(",",m.getHobby()));// 배열을 string으로 바꿔
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
		} 
		return result;
	}
	
	
}
