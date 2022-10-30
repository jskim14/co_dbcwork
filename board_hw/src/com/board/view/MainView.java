package com.board.view;


import java.util.Scanner;
import static com.board.controller.MemberController.getController;

public class MainView {
	
	public void mainMenu() {
		while(true) {
			System.out.println("======메인메뉴=====");
			System.out.println("1. 회원관리");
			System.out.println("2. 게시판관리");
			System.out.println("3. 프로그램 종료");
			switch(inputNum()) {
				case 1: memberManager(); break;
				case 2: boardManager(); break;
				case 3: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못입력하셨습니다. 다시 .");
			}
		}
	}
	
	public int inputNum() {
		Scanner sc= new Scanner(System.in);
		System.out.print("메뉴선택 : ");
		return sc.nextInt();
	}
	
	public void memberManager() {
		while(true) {
			System.out.println("======회원관리=====");
			System.out.println("1. 전체회원조회");
			System.out.println("2. 회원 아이디로 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원가입");
			System.out.println("5. 회원정보수정(주소, 전화번호, 이메일)");
			System.out.println("6. 회원탈퇴");
			System.out.println("7. 메인메뉴로");
			switch(inputNum()) {
				case 1: getController().searchAll(); break;
				case 2: getController().searchId(); break;
				case 3: getController().searchName(); break;
				case 4: getController().enrollMember(); break;
				case 5: getController().updateMember(); break;
				case 6: getController().deleteMember(); break;
				case 7: ; return;
				default: System.out.println("다시");
			}
		}
	}
	
	public void boardManager() {
		while(true){			
			System.out.println("======게시판 관리=====");
			System.out.println("1. 게시판전체 검색");
			System.out.println("2. 게시물 등록");
			System.out.println("3. 작성자로 검색");
			System.out.println("4. 제목으로 검색");
			System.out.println("5. 게시물 수정(제목, 내용)");
			System.out.println("6. 게시물 삭제");
			System.out.println("7. 메인메뉴로");
			switch(inputNum()) {
			case 1: getController().searchBoardAll(); break;
			case 2: getController().insertBoard(); break;
			case 3: getController().searchWriter(); break;
			case 4: getController().searchTitle(); break;
			case 5: getController().updateBoard(); break;
			case 6: getController().deleteBoard(); break;
			case 7: ; return;
			default: System.out.println("다시");
			}
		}
	}
	
}
