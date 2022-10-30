package com.firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBC {

	public static void main(String[] args) {
		//DB연결 및 SQL문 실행에 필요한 클래스변수는 미리 선언함
		// -> 객체를 반드시 반환해야 하기 때문이다. (지역변수니까 초기화도)
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		// JDBC활용
		// 자바에서 DB에 연결하는 방법 : 순서가 정해져있음
		//1.DataBase 연결하기 
		// 1) class.forName() 메소드를 이용해서 드라이브를 등록한다. 
		//		-> oracle.jdbc.driver.OracleDriver -> ojdbc.jar에 있는 내용
		// * ojdbc.jar파일을 프로젝트에 라이브러리로 추가해야함. ->프로젝트마다 설정해야함
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공!");
			
		//2. Connection 객체를 생성하기 : DB연결정보를 가지고 있는 객체
			// 1) DriverManager클래스를 이용
			// 	-getConnection() static매소드를 이용
			// 		- 1 : DB접속 주소, 정보 -> 형식이 정해져있음
			//			jdbc:oracle:thin:@ip주소:포트번호:sid
			//		- 2 : DB접속 사용자계정명 *대소문자 구분안함*
			//		- 3 : 사용자계정의 비밀번호 *대소문자 구분*
			// 위 세개의 매개변수는 모두 String으로 대입함
			
//			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
//										"student","student");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"student","student");
			System.out.println("Connection 객체 생성완료! 접속완료!");
			
		//3. Connect객체를 이용해서 sql문을 실행할 객체를 생성 -> Statement인터페이스 
		// - Connection의 createStateent()매소드를 이용해서 생성함
//			Statement stmt=conn.createStatement();
			stmt=conn.createStatement();
			//Statement는 connect에 연결되어 있는 DB에 SQL구문을 실행하고, 그 결과를 가져오는 역할
		//4. DB에서 실행할 SQL구문을 작성 -> String으로 작성
			String sql="SELECT * FROM MEMBER "; // WHERE MEMBER_NAME='관리자'"AND MEMBER_ID='admin'"; //Member테이블의 전체회원 조회
			//String sql="SELECT * FROM MEMBER" +
			//			"WHERE MEMBER_NAME='관리자'" + " AND MEMBER_ID='admin'"; +로 줄바꿈 가능
			//쿼리문 작성시 모든것을 동일하게 작성해야함. 단!! 마지막 세미콜론만 생략.
			
		//5. Statement객체의 excuteQuery()메소드를 이용해서 작성된 sql구문을 실행
			//excuteQuery(sql구문을 대입);
			//excuteQuery()매소드를 실행하면 ResultSet을 반환함 -> DB실행결과(data)가 저장되어있음.
			//excuteQuery() 실행하면 ResultSet 변수로 받아줘야 함.
//			ResultSet rs=stmt.executeQuery(sql); //연결된 db에서 쿼리문을 실행 -> SQLException처리를 해야함.
			rs=stmt.executeQuery(sql);
			System.out.println("쿼리문 실행완료!");
			//select문 실행은 executeQuery()실행 -> ResultSet반환
			//DML(insert, update, delete) executeUpdate() 실행 -> int형 반환
			
		//6. ResultSet으로 받아온 data확인, 클래스에 저장하기 
			// - ResultSet의 get00(컬럼명)메소드를 이용
			// - 자료형별로 메소드가 만들어져 있음.
			// - 문자열(varchar2,char,nvarchar2,nchar)은 getString();
			// - 숫자(number)는 getInt() 또는 getDouble();
			// - 날짜(Date)는 getDate() -java.sql.Date;로 반환
			// resultSet에서의 데이터는 각 row별로 데이터를 받아옴.
			// resultSet의 next()메소드를 이용하면 row에 차례대로 접근할 수 있다. next() 진위형을 반환
			
/*			rs.next(); //-->resultSet의 첫번째 row를 지정/가져옴
			System.out.println(rs.getString("member_id"));
			System.out.println(rs.getString("member_name"));
			System.out.println(rs.getInt("age"));
			rs.next(); //-->resultSet의 두번째 row를 지정/가져옴
			System.out.println(rs.getString("member_id"));
			System.out.println(rs.getString("member_name"));
			System.out.println(rs.getInt("age")); 
*/			
			while(rs.next()) {
				System.out.print(rs.getString("member_id")); //매개변수 컬럼명은 대소문자 구분없음 
				System.out.print(rs.getString("member_pwd"));
				System.out.print(rs.getString("member_name"));
				System.out.print(rs.getString("gender"));
				System.out.print(rs.getInt("age"));
				System.out.print(rs.getString("email"));
				System.out.print(rs.getString("phone"));
				System.out.print(rs.getString("address"));
				System.out.print(rs.getString("address"));
				System.out.print(rs.getString("hobby"));
				System.out.print(rs.getString("enroll_date"));
				System.out.println();
				// select문으로 가져온 데이터는 통상 vo클래스를 만들어서 저장 후 객체로 활용 
				// 다수의 객체가 생성된 경우(resultset에 다수row가 있는 경우)에는 ArrayList를 이용함.
			}
			
			// DML구문 실행하기 -> 트랜젝션 처리를 해줘야함. commint(), rollback()
			// insert문 활용하기
			// sql문 작성하기
			sql="INSERT INTO MEMBER VALUES('USER99','USER99','유저9','F',"
					+ "38,'USER99@USER99.COM','0101234561','서울시 강남구','코딩,운전',SYSDATE)";
			int result= stmt.executeUpdate(sql); // int인 이유는 1행이 삽입되었을 때 그 1행에 대한 숫자 
			
			if(result>0) conn.commit(); //트랜젝션 커밋실행
			
			System.out.println(result>0? "입력성공":"입력실패");
			
			// 7. 생성된 객체를 닫아주기
			// connection, statement, result(select문을 실행한 경우)
			// 객체를 반환할 때는 생성순서의 역순으로 진행 
/*			rs.close();
			stmt.close();
			conn.close();
*/			
						
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null&& rs.isClosed()) rs.close();
				if(stmt!=null&& stmt.isClosed()) stmt.close();
				if(conn!=null&& conn.isClosed()) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
