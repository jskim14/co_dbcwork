package com.test.controller;

import java.util.ArrayList;

import com.test.model.dao.BoardDao;
import com.test.model.vo.Board;
import com.test.view.MainView;

public class BoardController {

	public void mainMenu() {
		new MainView().MainMenu();
	}
	
	public void allList() {
		ArrayList<Board> list =new BoardDao().allList(); 
		new MainView().printList(list);
	}
	
	public void insertBoard() {
		Board b=new MainView().insertBoard();
		int result= new BoardDao().insertBoard(b);
		new MainView().printMsg(result>0 ? "저장성공" : "저장실패");
	}
}
