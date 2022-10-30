package com.member.view;

import static com.member.controller.MemberController.getController;

import java.util.List;
import java.util.Scanner;

import com.member.model.vo.Board;
import com.member.model.vo.Member;

public class MainView {
	
	private static MainView view;
	private static Scanner sc = new Scanner(System.in);
	private MainView() {}

	public static MainView getView() {
		if(view==null) view = new MainView();
		return view;
	}

	public void mainMenu() {
//		메인메뉴 
//		1. 회원관리
//		2. 게시판관리
//		3. 프로그램 종료
		while(true) {
			System.out.println("===== 메인 메뉴 =====");
			System.out.println("1. 회원 관리");
			System.out.println("2. 게시판 관리");
			System.out.println("3. 프로그램 종료");
			System.out.print("입력 : ");
			int cho = sc.nextInt();
			switch(cho) {
				case 1: getController().manageMember(); break;
				case 2: getController().manageBoard(); break;
				case 3: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
	
	
	}

	public void subMenuMember() {
//		회원관리 서브메뉴
//		  1. 전체회원조회
//		  2. 회원 아이디로 조회
//		  3. 회원 이름으로 조회
//		  4. 회원가입
//		  5. 회원정보수정(주소, 전화번호, 이메일)
//		  6. 회원탈퇴
//		  7. 메인메뉴로
		
		while(true) {
			System.out.println("===== 회원 관리 서브 메뉴 =====");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 회원 아이디로 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원가입");
			System.out.println("5. 회원 정보 수정(주소, 전화번호, 이메일)");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 메인 메뉴로");
			System.out.print("입력 : ");
			int cho = sc.nextInt();
			switch(cho) {
				case 1: getController().searchAllMember(); break;
				case 2: getController().searchId(); break;
				case 3: getController().searchName(); break;
				case 4: getController().insertMember(); break;
				case 5: getController().updateMember(); break;
				case 6: getController().deleteMember(); break;				
				case 7: System.out.println("메인 메뉴로 돌아갑니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
		
	}

	public void subMenuBoard() {
//		게시판 서브메뉴
//		  1. 게시판전체 검색
//		  2. 게시물 등록
//		  3. 작성자로 검색
//		  4. 제목으로 검색
//		  5. 게시물 수정(제목, 내용) idx로 수정
//		  6. 게시물 삭제
//		  7. 메인메뉴로
		while(true) {
			System.out.println("===== 게시판 서브 메뉴 =====");
			System.out.println("1. 게시판 전체 검색");
			System.out.println("2. 게시물 등록");
			System.out.println("3. 작성자로 검색");
			System.out.println("4. 제목으로 검색");
			System.out.println("5. 게시물 수정(제목, 내용)");
			System.out.println("6. 게시물 삭제");
			System.out.println("7. 메인 메뉴로");
			System.out.print("입력 : ");
			int cho = sc.nextInt();
			switch(cho) {
				case 1: getController().searchAllBoard(); break;
				case 2: getController().insertBoard(); break;
				case 3: getController().searchWriter(); break;
				case 4: getController().searchTitle(); break;
				case 5: getController().updateBoard(); break;
				case 6: getController().deleteBoard(); break;				
				case 7: System.out.println("메인 메뉴로 돌아갑니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
		
		
		
	}

	public String inputId() {
		sc.nextLine();
		System.out.println("==== 아이디로 조회하기 ====");
		System.out.print("조회할 아이디 : ");
		String result = sc.nextLine();
		return result;
	}

	public void printMemberData(List<Member> list) {
		System.out.println("=== 회원 조회 결과 ===");
		if(list.isEmpty()) System.out.println("조회된 결과가 없습니다.");
		else {
			for (Member m : list) {
				System.out.println(m);
			}
		}
		
	}

	public String inputName() {
		sc.nextLine();
		System.out.println("==== 이름으로 조회하기 ====");
		System.out.print("조회할 이름 : ");
		String result = sc.nextLine();
		return result;
	}

	public Member insertMember() {
		sc.nextLine();
		System.out.println("==== 회원 등록 ====");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		Member m = new Member(0, memberId, memberPwd, memberName, email, address, phone, null);
		return m;
	}

	public void printMsg(String msg) {
		System.out.println("===== 시스템 메시지 =====");
		System.out.println(msg);
		System.out.println("=====================");
	}

	public Member updateMember() {
		//회원정보수정(주소, 전화번호, 이메일)
		sc.nextLine();
		System.out.println("==== 전체 회원 정보 ====");
		getController().searchAllMember();
		System.out.println("=== 회원 정보 수정 ===");
		Member m = new Member();
		System.out.print("수정할 회원의 번호 : ");
		m.setIdx(sc.nextInt());
		sc.nextLine();
		System.out.print("주소 : ");
		m.setAddress(sc.nextLine());
		System.out.print("전화번호 : ");
		m.setPhone(sc.nextLine());
		System.out.print("이메일 : ");
		m.setEmail(sc.nextLine());
		
		return m;
	}

	public int deleteMember() {
		System.out.println("==== 전체 회원 정보 ====");
		getController().searchAllMember();
		System.out.println("=== 회원 탈퇴 ===");
		System.out.print("탈퇴할 회원의 번호 : ");
		return sc.nextInt();
	}

	public void printBoardData(List<Board> list) {
		System.out.println("=== 게시판 조회 결과 ===");
		if(list.isEmpty()) System.out.println("조회된 결과가 없습니다.");
		else {
			for (Board b : list) {
				System.out.println(b);
			}
		}
		
	}

	public Board insertBoard() {
		sc.nextLine();
		System.out.println("==== 게시물 등록 ====");
		String div = null;
		do {
			System.out.print("구분(공지,일반,비밀) : ");
			div = sc.nextLine();
			if(!(div.equals("공지")||div.equals("일반")||div.equals("비밀"))) {
				System.out.println("공지 or 일반 or 비밀 셋 중 하나만 적어주세요.");
				div = null;
			}else {
				break;
			}
		}while(true);
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String contents = sc.nextLine();
		System.out.print("작성자 : ");
		int writer = sc.nextInt();
		Board b = new Board(0, div, title, contents, writer, null);
		return b;
	}

	public int inputWriter() {
		System.out.println("==== 작성자로 조회하기 ====");
		System.out.print("조회할 작성자 : ");
		int result = sc.nextInt();
		return result;
	}

	public String inputTitle() {
		sc.nextLine();
		System.out.println("==== 제목으로 조회하기 ====");
		System.out.print("조회할 제목 : ");
		String result = sc.nextLine();
		return result;
	}

	public Board updateBoard() {
		//게시물 수정(제목, 내용) idx로 수정
		sc.nextLine();
		System.out.println("==== 전체 게시판 정보 ====");
		getController().searchAllBoard();
		System.out.println("=== 게시물 수정 ===");
		Board b = new Board();
		System.out.print("수정할 게시물 번호 : ");
		b.setIdx(sc.nextInt());
		sc.nextLine();
		System.out.print("제목 : ");
		b.setTitle(sc.nextLine());
		System.out.print("내용 : ");
		b.setContents(sc.nextLine());
		
		
		return b;
	}

	public int deleteBoard() {
		System.out.println("==== 전체 게시물 정보 ====");
		getController().searchAllBoard();
		System.out.println("=== 게시물 삭제 ===");
		System.out.print("삭제할 게시물의 번호 : ");
		return sc.nextInt();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
