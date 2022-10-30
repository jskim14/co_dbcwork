package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import com.student.mode.dao.StudentDao;
import com.student.mode.vo.Student;
import com.student.view.MainView;

public class StudentController {

	//모든서비스를 메소드로 가지고 있음
	
	// 1. main화면을 출력해주는 기능
	public void mainMenu() {
		new MainView().mainMenu();
	}
	
	// 2. 학생 전체조회하기
	public void entrySearch() {
		//DB에 MEMBER테이블에 저장된 전체 데이터를 가져와서 보여주는 기능
		//1. DB에 접속할 수 있는 객체에 요청 ->DAO
//		ArrayList<Student> list =new StudentDao().entrySearch();
		List<Student> list =new StudentDao().entrySearchP();
		
		//2. 데이터를 출력할 화면 선택.
		new MainView().printData(new ArrayList<Student>(list));
		
	}
	
	// 3. 아이디로 조회
	public void searchId() {
		//1. 검색할 아이디를 입력받아야 함
		String searchId=new MainView().inputData();
		
		//2. 입력받은 아이디가 DB의 MEMBER테이블의 MEMBER_ID컬럼에 동일값이 있는지 확인하고 결과출력		
//		Student s = new StudentDao().searchId(searchId);
		Student s = new StudentDao().searchIdP(searchId);
		
		//3. 조회된 결과 출력하기 
		new MainView().printData(s);
		
//		if(s!=null) System.out.println(s.toString());
//		else System.out.println("값 없음");			
		
	}
	
	//4. 이름으로 조회하기
	public void searchName() {
		// 구현하려는 서비스 기능 : 사용자가 원하는 이름을 기준으로 db의 member테이블에 해당 컬럼에 있는 row값을 찾아오도록 값을 가져와 
		
		//1. 사용자가 원하는 이름을 받아와 
		String name=new MainView().inputName();
		
		//2. DB에 정보 확인 : 멤버테이블에서 확인 
		ArrayList<Student> list = new StudentDao().searchName(name); //입력받은 name을 보내니까 
		new MainView().printData(list);
	}
	
	// 학생을 입력하는 서비스 
	public void insertMember() { // DB에 ROW를 등록하는 것 INSERT INTO MEMVER VALUES();
		//1. 저장할 데이터를 사용자한테 입력받음
		Student s=new MainView().inputMember();
//		int result= new StudentDao().insertMember(s); //2. 입력받은 s를 보내서 db에 저장 
		int result= new StudentDao().insertMemberP(s);  
		
		//3. 저장결과를 출력
		new MainView().printMsg(result>0 ? "저장성공" : "저장실패");
	}
	
	//000의 내용을(where) 수정하기 이름,나이,이메일,주소
	public void updateMember() {
		// 수정할 이름, 나이, 이메일, 주소 + 그리고 찾을 아이디 값을 받아야 함.
		
		Student s=new MainView().modify(); //아이디로 조회해서 그 사람을 찾아와 
//		int result = new StudentDao().updateMember(s);
		int result = new StudentDao().updateMemberP(s);
		
		new MainView().printMsg(result>0 ? "완료" : "실패");
	}
	
	public void deleteMember() {
		//사람을 id로 조회해서 한명을 뽑고 그 사람을 삭제
		entrySearch();
		String searchId=new MainView().inputData();
		Student s = new StudentDao().searchIdP(searchId);
		new StudentDao().deleteMember(s);
		
		new MainView().printData(s);
		
		
	}
	
	
	
}
