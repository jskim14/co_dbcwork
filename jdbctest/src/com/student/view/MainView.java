package com.student.view;

import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.mode.vo.Student;

public class MainView {

	Scanner sc= new Scanner(System.in);
	//사용자에게 화면을 보여주는 역할을 가지고 있는 클래스
	
	//1. main화면 구성
	public void mainMenu() {
		
		System.out.println("==== 학생관리 프로그램 v.1 ====");
		do {
			System.out.println("1. 전체조회");
			System.out.println("2. 아이디로 조회");
			System.out.println("3. 이름으로 조회");
			System.out.println("4. 등록하기");
			System.out.println("5. 회원정보 수정하기");
			System.out.println("6. 회원삭제하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.print("입력 : ");
			int cho=sc.nextInt();
			switch(cho) {
				case 1 : new StudentController().entrySearch(); break;
				case 2 : new StudentController().searchId(); break;
				case 3 : new StudentController().searchName();; break;
				case 4 : new StudentController().insertMember();; break;
				case 5 : new StudentController().updateMember(); break;
				case 6 : new StudentController().deleteMember(); break;
				case 0 : System.out.println("프로그램 종료"); return;
				default : System.out.println("잘못눌렀어"); break;
			}
		} while(true);
		
	}
	
	public void printData(ArrayList<Student> list) {
		System.out.println("===조회결과===");
		//list데이터가 없으면
		if(!list.isEmpty()) {
			for(Student s : list) {
			System.out.println(s);
			}
		} else {
			System.out.println("조회된 결과가 없습니다.");
		}
		
	}
	
	public String inputData() {
		System.out.print("조회할 아이디 입력 : ");
		String id = sc.next();
		return id;
		//new StudentController().searchId(id);
	}
	
	public void printData(Student s) {
		if(s!=null) System.out.println(s);
		else System.out.println("없어");
	}		
	
	public String inputName() {
		System.out.println("검색할 이름 : ");
		String name = sc.next();
		return name;
	}
	
	public Student inputMember() {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("이름 : ");
		String memberName=sc.next();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("나이 : ");
		int age =sc.nextInt();
		sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("연락처 : ");
		String phone=sc.next();
		sc.nextLine();
		System.out.print("주소 : ");
		String address=sc.nextLine();
		System.out.print("취미 : ");
		String hobby=sc.nextLine();
		
		Student s= new Student(id,pw,memberName, gender, age, email, phone, address,hobby,null); 
		// 매개변수있는 생성자로 쭈욱 쓰면 틀릴 가능성이 높기 때문에 setter를 사용하는 것이 좋다.
		
		return s;
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	public Student modify() {
		new StudentController().entrySearch();
		Student s = new Student();
		
		System.out.println("수정할 회원의 아이디 : ");
		s.setMemberId(sc.nextLine());
		
		System.out.print("이름 : ");
		s.setMemberName(sc.next());
		System.out.print("나이 : ");
		s.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("이메일 : ");
		s.setEmail(sc.nextLine());
		System.out.print("주소 : ");
		s.setAddress(sc.nextLine());
		return s;
	}

	
	
	
	
}
