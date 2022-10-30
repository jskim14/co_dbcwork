package com.member.controller;

import static com.member.model.service.MemberService.getService;
import static com.member.view.MainView.getView;

import java.util.List;

import com.member.model.vo.Board;
import com.member.model.vo.Member;

public class MemberController {
	private static MemberController controller;
	
	public MemberController() {}
	
	public static MemberController getController() {
		if(controller==null) controller = new MemberController();
		return controller;
	}
	
	public void mainMenu() {
		getView().mainMenu();
	}

	public void manageMember() {
		getView().subMenuMember();
	}
	
	public void manageBoard() {
		getView().subMenuBoard();
	}

	public void searchAllMember() {
		List<Member> list = getService().searchAllMember();
		getView().printMemberData(list);
	}

	public void searchId() {
		List<Member> AllList = getService().searchAllMember();
		getView().printMemberData(AllList);
		String searchId = getView().inputId();
		List<Member> list = getService().searchId(searchId);
		getView().printMemberData(list);
		
	}

	public void searchName() {
		List<Member> AllList = getService().searchAllMember();
		getView().printMemberData(AllList);
		String searchName = getView().inputName();
		List<Member> list = getService().searchName(searchName);
		getView().printMemberData(list);
	}

	public void insertMember() {
		Member m = getView().insertMember();
		int result = getService().insertMember(m);
		getView().printMsg(result>0?"저장 성공":"저장 실패");
		
	}

	public void updateMember() {
		Member m = getView().updateMember();
		int result = getService().updateMember(m);
		getView().printMsg(result>0?"수정 성공":"수정 실패");
	}

	public void deleteMember() {
		int deleteIdx = getView().deleteMember();
		int result = getService().deleteMember(deleteIdx);
		getView().printMsg(result>0?"삭제 성공":"삭제 실패");
		
	}

	public void searchAllBoard() {
		List<Board> list = getService().searchAllBoard();
		getView().printBoardData(list);
	}

	public void insertBoard() {
		Board b = getView().insertBoard();
		int result = getService().insertBoard(b);
		getView().printMsg(result>0?"저장 성공":"저장 실패");
		
	}

	public void searchWriter() {
		List<Board> AllList = getService().searchAllBoard();
		getView().printBoardData(AllList);
		int writer = getView().inputWriter();
		List<Board> list = getService().searchWriter(writer);
		getView().printBoardData(list);
		
	}

	public void searchTitle() {
		List<Board> AllList = getService().searchAllBoard();
		getView().printBoardData(AllList);
		String title = getView().inputTitle();
		List<Board> list = getService().searchTitle(title);
		getView().printBoardData(list);
		
	}

	public void updateBoard() {
		Board b = getView().updateBoard();
		int result = getService().updateBoard(b);
		getView().printMsg(result>0?"수정 성공":"수정 실패");
		
	}

	public void deleteBoard() {
		int deleteIdx = getView().deleteBoard();
		int result = getService().deleteBoard(deleteIdx);
		getView().printMsg(result>0?"삭제 성공":"삭제 실패");
		
	}

}
