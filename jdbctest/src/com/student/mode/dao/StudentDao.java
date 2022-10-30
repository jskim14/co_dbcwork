package com.student.mode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.mode.vo.Student;

public class StudentDao {
	
	//DB에 연결하여 SQL문을 실행하고 그 결과를 가져오는 역할
	
	public ArrayList<Student> entrySearch() { //DB접속해서 전체조회
		//member테이블의 전체데이터를 조회 -> select문을 이용
		//조회한 데이터를 호출한 곳으로 반환! ====> 로우 하나가 객체니까 그 객체들이 모인 리스트를 반환 
		
		//DB연결을 위한 로직을 구성
		//1. jdbc에서 사용할 객체변수를 선언 + 리턴값까지 
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Student> list = new ArrayList<>(); //DB에서 가져온 데이터를 저장할 ArrayList만든다
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 등록하기 
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student"); //connect 객체 가져오기
			stmt=conn.createStatement(); //sql문을 실행하는 Statement객체를 생성
			String sql="select * from member"; //실행할 sql문 작성
			rs=stmt.executeQuery(sql); //sql문을 db에서 실행하기 
			
			while(rs.next()) { //결과(오라클 데이터)를 java클래스 형식으로 변경 
								//보통 테이블과 매칭되는 클래스를 만들어 놓음 ->vo클래스 == table row
				Student s= new Student();
				s.setMemberId(rs.getString("member_id"));
				s.setMemberPwd(rs.getString("member_pwd"));
				s.setMemberName(rs.getString("member_name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setEmail(rs.getString("email"));
			 	s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
				s.setHobby(rs.getString("hobby"));
				s.setEnrollDate(rs.getDate("enroll_date"));
				//while문을 한번 돌 때 1개 row를 Student클래스를 생성해서 저장 
				
				list.add(s); // list를 생성해서 db에 가져온 값을 넣은ㄱ 개체를 저장
			}	
			System.out.println(list);

		} catch(ClassNotFoundException e) {
			e.printStackTrace();			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(stmt!=null && !stmt.isClosed()) stmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public Student searchId(String searchId) { //DB접속해서 ID조회

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		//pk값을 비교했을 때 중복값이 생길 수 없다. 없거나 한개 있거나 
		
		Student s = null; //값을 찾았으면 값이 들어가고 없으면 null
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student"); 
			stmt=conn.createStatement(); 
			String sql="SELECT * FROM MEMBER WHERE MEMBER_ID='"+searchId+"'"; 
			rs=stmt.executeQuery(sql); 
			
			if(rs.next()) { //다음거를 하나씩 넘겨라 
				s=new Student();
				s.setMemberId(rs.getString("member_id"));
				s.setMemberPwd(rs.getString("member_pwd"));
				s.setMemberName(rs.getString("member_name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setEmail(rs.getString("email"));
			 	s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
				s.setHobby(rs.getString("hobby"));
				s.setEnrollDate(rs.getDate("enroll_date"));
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(stmt!=null && !stmt.isClosed()) stmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}		
		}
	
		return s;
	}
	
	public ArrayList<Student> searchName(String name) { //DB접속해서 이름조회 =>SELECT문을 실행하여 RESULT SET을 반환하라 
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Student> list= new ArrayList<>();
		String sql="select * from member where member_name like '%"+name+"%'"; //부분검색 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				Student s= new Student(); //하나씩 계속 생성해주는거 
				s.setMemberId(rs.getString("member_id"));
				s.setMemberPwd(rs.getString("member_pwd"));
				s.setMemberName(rs.getString("member_name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setEmail(rs.getString("email"));
			 	s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
				s.setHobby(rs.getString("hobby"));
				s.setEnrollDate(rs.getDate("enroll_date"));
				list.add(s);
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null && !rs.isClosed()) rs.close();
				if(stmt!=null && !stmt.isClosed()) stmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}		
		}
		return list;
	}
	
	public int insertMember(Student s) {
		Connection conn=null;
		Statement stmt=null;
		int result=0; // insert문에 대한 반환값은 int, select문에 대한 반환값은 resultSet
		String sql="insert into member values('"+s.getMemberId()+"','"+s.getMemberPwd()+"','"
		+s.getMemberName()+"','"+s.getGender()+"',"+s.getAge()+","+"'"+s.getEmail()+"','"+s.getPhone()+"','"+s.getAddress()+"','"+s.getHobby()+"',sysdate)";
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			
			conn.setAutoCommit(false); // 커밋처리
			
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql); //DML은 executeUpdate()메소드를 사용함
			//DML구문을 실행한 경우 반드시 트랜젝션 처리를 해줘야 함.
			
			if(result>0) conn.commit();
			else conn.rollback();

			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null && !stmt.isClosed()) stmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}		
		}
		return result;
		
	}
	
	public int updateMember(Student s) {
		Connection conn=null;
		Statement stmt=null;
		int result=0;

		String sql="update member set member_name = '"+ s.getMemberName()+"', age =" 
		+ s.getAge() +", email = '" + s.getEmail()+"', address = '"+s.getAddress()+"' where member_id='"+s.getMemberId()+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
//			conn.setAutoCommit(false); 
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql); 
			
//			if(result>0) conn.commit();
//			else conn.rollback();

			
		} catch(Exception e) {
			e.printStackTrace();			
		} finally {
			try {
				if(stmt!=null && !stmt.isClosed()) stmt.close();
				if(conn!=null && !conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}		
		}
		return result;
	}
	
	//preparestatement객체를 이용해서 sql문 실행시키기
	//statement와 동일한 기능을 하는 클래스로 connection객체를 이용해서 생성함 => preparestatement("sql문") 매소드 이용
	//매개변수로 전달되는 sql문은 외부에서 전달받은 값으로 세팅하는 부분을 ?로 표시함. 
	//예) 기존 => "select * from member where member_id='"+변수명+"'";
	//예) prepared=>"select * from member where member_id=?";
	// 학생추가 => insert into member values(?,?,?,?,?,?,?,?,sysdate);
	//?(위치홀더)표시된 부분은 PreparedStatement가 제공하는 메소드를 이용해서 처리함
	//setString(인덱스,값), setInt(인덱스,값), setDate(인덱스,값)
	//인덱스 변호는 제일 왼쪽부터 1로 시작 (0부터x)
	
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url ="jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "student";
	private String password = "student";
	
	public List<Student> entrySearchP() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM MEMBER";
		List<Student> list = new ArrayList();
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt= conn.prepareStatement(sql); //매개변수에 sql문을 넣고
			rs= pstmt.executeQuery(); //매개변수에 sql문을 안넣는다 
			
			while(rs.next()) {
				Student s= new Student(); //하나씩 계속 생성해주는거 
				s.setMemberId(rs.getString("member_id"));
				s.setMemberPwd(rs.getString("member_pwd"));
				s.setMemberName(rs.getString("member_name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setEmail(rs.getString("email"));
			 	s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
				s.setHobby(rs.getString("hobby"));
				s.setEnrollDate(rs.getDate("enroll_date"));
				list.add(s);
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
	
	// prparedStatement 아이디 조회
	public Student searchIdP(String searchId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student s=null;
		String sql ="SELECT * FROM MEMBER WHERE MEMBER_ID=?";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt=conn.prepareStatement(sql);
			// ? (위치홀더) 를 반 드 시 세팅해줘야 함. 
			pstmt.setString(1, searchId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) { //다음거를 하나씩 넘겨라 
				s=new Student();
				s.setMemberId(rs.getString("member_id"));
				s.setMemberPwd(rs.getString("member_pwd"));
				s.setMemberName(rs.getString("member_name"));
				s.setGender(rs.getString("gender"));
				s.setAge(rs.getInt("age"));
				s.setEmail(rs.getString("email"));
			 	s.setPhone(rs.getString("phone"));
				s.setAddress(rs.getString("address"));
				s.setHobby(rs.getString("hobby"));
				s.setEnrollDate(rs.getDate("enroll_date"));
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
		return s;
	}
	
	public int insertMemberP(Student s) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result =0;
		String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt=conn.prepareStatement(sql);
			//위치홀더값 세팅하기
			pstmt.setString(1, s.getMemberId());
			pstmt.setString(2, s.getMemberPwd());
			pstmt.setString(3, s.getMemberName());
			pstmt.setString(4, s.getGender());
			pstmt.setInt(5, s.getAge());
			pstmt.setString(6, s.getEmail());
			pstmt.setString(7, s.getPhone());
			pstmt.setString(8, s.getAddress());
			pstmt.setString(9, s.getHobby());
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
	
	public int updateMemberP(Student s) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql="UPDATE MEMBER SET MEMBER_NAME=?, AGE=?, EMAIL=?, ADDRESS=? WHERE MEMBER_ID=?";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, s.getMemberName());
			pstmt.setInt(2, s.getAge());
			pstmt.setString(3, s.getEmail());
			pstmt.setString(4, s.getAddress());
			pstmt.setString(5, s.getMemberId());
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
	
	public int deleteMember(Student s) {
		Connection conn=null;
		PreparedStatement pstmt= null;
		int result= 0;
		String sql="DELETE FROM MEMBER WHERE MEMBER_ID=?";
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, s.getMemberId());
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
