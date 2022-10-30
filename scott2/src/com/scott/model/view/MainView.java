package com.scott.model.view;

import java.util.Scanner;

import com.scott.controller.EmpController;

public class MainView {
	
	private static MainView view;
	
	private MainView() {}
	
	public static MainView getView() {
		if(view==null) {
			view=new MainView();
		}
		return view;
	}

	public void mainMenu() {
		Scanner sc= new Scanner(System.in);
		System.out.println("===== 사원관리 프로그램 =====");
		while(true) {
			System.out.println("1. 사원 전체 조회");
			System.out.println("2. 이름검색");
			System.out.println("3. 월급조회");
			System.out.println("4. 사원등록");
			System.out.println("5. 사원수정");
			System.out.println("6. 사원삭제");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("입력 : ");
			int cho=sc.nextInt();
			switch(cho) {
				case 1 : ; break;
				case 2 : ; break;
				case 3 :  break;
				case 4 :  break;
				case 5 :  break;
				case 6 :  break;
				case 0 : System.out.println("프로그램 종료"); return;
				default : System.out.println("잘못눌렀어"); break;
			}
		}
	}
	
}
