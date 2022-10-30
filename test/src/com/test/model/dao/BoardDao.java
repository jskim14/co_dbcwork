package com.test.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.model.vo.Board;

public class BoardDao {
	
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@192.168.0.100:1521:xe";
	private String user = "user00";
	private String password = "user00";
	
	public ArrayList<Board> allList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM BOARD ORDER BY SEQ_BOARD";
		ArrayList<Board> list = new ArrayList();
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt= conn.prepareStatement(sql); 
			rs= pstmt.executeQuery(); 
			
			while(rs.next()) {
				Board b=new Board();
				b.setBoardNum(rs.getInt("SEQ_BOARD"));
				b.setTitle(rs.getString("TITLE"));
				b.setContent(rs.getString("CONTENT"));
				b.setWriter(rs.getString("WRITER"));
				b.setEnrollDate(rs.getDate("ENROLL_DATE"));
				list.add(b);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();

			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertBoard(Board b) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result =0;
		String sql="INSERT INTO BOARD VALUES(SEQ_BOARD.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getWriter());
			result= pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
	}

}
