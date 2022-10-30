package com.board.controller;

import static com.board.model.service.MemberService.getMemberService;;

public class MemberController {
	
	private static MemberController controller;
	
	private MemberController() {
	}
	
	public static MemberController getController() {
		if(controller==null) controller=new MemberController();
		return controller;
	}
	
	public void mainMenu() {
		
	}
	
	//----------member
	
	public void searchAll() {
		getMemberService().searchAll();
	}
	
	public void searchId() {
		
	}
	
	public void searchName() {
		
	}
	
	public void enrollMember() {
		
	}
	
	public void updateMember() {
		
	}
	
	public void deleteMember() {
		
	}
	
	//------------board
	public void searchBoardAll() {
		
	}
	
	public void insertBoard() {
		
	}
	
	public void searchWriter() {
		
	}
	
	public void searchTitle() {
		
	}
	
	public void updateBoard() {
		
	}
	
	public void deleteBoard() {
		
	}

}
