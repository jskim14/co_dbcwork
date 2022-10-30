package com.test.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.controller.BoardController;
import com.test.model.vo.Board;

public class MainView {

	public void MainMenu() {
		Scanner sc= new Scanner(System.in);
		System.out.println("===== 게시판 관리 프로그램 =====");
		while(true) {
			System.out.println("1. 게시글조회");
			System.out.println("2. 게시글 등록 구현하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int input=sc.nextInt();
			switch(input) {
				case 1 : new BoardController().allList(); break;
				case 2 : new BoardController().insertBoard(); break;
				case 0 : System.out.println("프로그램 종료"); return;
				default : System.out.println("잘못누르셨습니다. 다시입력하세요!!"); break;
			}	
		}
	}
	
	public void printList(ArrayList<Board> list) {
		System.out.println("====조회 결과====");
		if(!(list.isEmpty())) {
			for(Board b : list)
			System.out.println(b);
		} else {
			System.out.println("조회결과가 없음.");
		}
		
	}
	
	public Board insertBoard() {
		Scanner sc = new Scanner(System.in);
		System.out.print("게시글 제목 : ");
		String title =sc.nextLine();
		System.out.print("게시글 내용 : ");
		String content =sc.nextLine();
		System.out.print("게시글 작성자  : ");
		String writer =sc.nextLine();
		
		Board b = new Board(0,title,content,writer,null);
		return b;
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
}
