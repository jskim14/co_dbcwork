package com.member.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {

	public static Connection getConnection() {
		Connection conn=null;
		//driver.properties파일에 저장된 내용 불러오기 
		Properties prop=new Properties();
		//prop.load(new FileReader(파일경로)) -> 파일!
		//prop.get("key") -> properties파일에 있는 값 가져오기
/*확인*/	System.out.println(JdbcTemplate.class.getResource("./").getPath()+"/driver.properties");
		String path=JdbcTemplate.class.getResource("./").getPath()+"/driver.properties";
		try {
			prop.load(new FileReader(path));
			System.out.println(prop.get("driver"));
			System.out.println(prop.get("url"));
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pw"));
			
			
			conn.setAutoCommit(false); //자동으로 설정되지 않고 내가 설정할 것이다
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} return conn;
	}
	
	//객체를 반환하는 공용메소드 구현하기
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null &&!conn.isClosed()) conn.rollback();
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
