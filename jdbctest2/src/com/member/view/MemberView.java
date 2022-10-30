package com.member.view;

import static com.member.controller.MemberController.getController;

import java.util.List;
import java.util.Scanner;

import com.member.model.vo.Member;;

public class MemberView {
	
	private static MemberView view;
	
	private MemberView() {}
	
	public static MemberView getView() {
		if(view==null) {
			view=new MemberView();
		}
		return view;
	}
	
	public void mainMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 회원관리 프로그램 ====");
		
		while(true) {
			System.out.println("1. 전체회원 조회");
			System.out.println("2. 아이디 조회");
			System.out.println("3. 이름으로 조회");
			System.out.println("4. 회원등록");
			System.out.println("5. 회원수정");
			System.out.println("6. 회원삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int cho =sc.nextInt();
			switch(cho) {
				case 1 : getController().searchAll() ; break;
				case 2 : getController().searchId(); break;
				case 3 : getController().searchName(); break;
				case 4 : getController().insertMember(); break;
				case 5 : ; break;
				case 6 : ; break;
				case 0 : System.out.println("프로그램 종료"); return;
			}
		}
	}
	
	public void printData(List<Member> list) {
		System.out.println("==== 회원조회 결과 ====");
		if(list.isEmpty()) System.out.println("내용없음");
		else {
			for(Member m: list) {
			System.out.println(m);
			}
		}
	}
	
	public void printData(Member m) {
		System.out.println("==== 회원조회 결과 ====");
		if(m==null) System.out.println("내용없음");
		else {
			System.out.println(m);
		}
	}
	
	public String inputData(String title) { // 이거 짱이다 
		Scanner sc= new Scanner(System.in);
		System.out.println("===="+title+" 입력 =====");
		return sc.nextLine();
	}
	
	public Member inputMember() {
		Scanner sc= new Scanner(System.in);
		Member m= new Member();
		System.out.println("===== 회원정보 입력 =====");
		System.out.println("아이디 : ");
		String id="";
		while(id.length()<8) {
			id=sc.nextLine();
			System.out.println(id.length()<8 ? "8글자 이상 작성하세요" : "");
		}
		m.setMemberId(id);
		System.out.println("비밀번호 : ");
		m.setMemberPwd(sc.nextLine());
		System.out.println("이름 : ");
		m.setMemberName(sc.nextLine());
		System.out.println("성별(M/F) : ");
		char gender=' ';
		while(gender==' '||!(gender=='M'|| gender=='F')) {
			gender=sc.nextLine().toUpperCase().charAt(0);
		}
		m.setGender(gender);
		System.out.println("나이 : ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.println("이메일 : ");
		m.setEmail(sc.nextLine());
		System.out.println("전화번호 : ");
		m.setPhone(sc.nextLine());
		System.out.println("주소");
		m.setAddress(sc.nextLine());
		System.out.println("취미(,로 구분) : ");
		m.setHobby(sc.nextLine().split(","));
		return m;
		
	}
	
	public void printMsg(String msg) {
		System.out.println("===== 알림 =====");
		System.out.println(msg);
	}

	
	
}






