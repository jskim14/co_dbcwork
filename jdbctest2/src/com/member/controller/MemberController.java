package com.member.controller;

import java.util.List;

import com.member.model.vo.Member;
import com.member.view.MemberView;
import static com.member.model.service.MemberService.getService;
import static com.member.view.MemberView.getView;

public class MemberController {
	private static MemberController controller;
	
	private MemberController() {} // 기본생성자가 private으로 선언하여 기본생성 차단
	
	public static MemberController getController() {
		if(controller==null) controller= new MemberController();
		return controller;
	}
	
	//1.메인화면 출력하기
	public void mainMenu() {
		MemberView.getView().mainMenu();
	}
	
	public void searchAll() {
		//service객체에 전체조회를 요청 
		List<Member> list = getService().searchAll();
		getView().printData(list);
	}
	
	public void searchId() {
		String id=getView().inputData("아이디");
		getService().searchId(id);
		Member m = getService().searchId(id);
		getView().printData(m);
	}
	
	public void searchName() {
		String name=getView().inputData("이름");
		getService().searchName(name);
		List<Member> list = getService().searchName(name);
		getView().printData(list);
	}
	
	public void insertMember() {
		Member m = getView().inputMember();
		int result= getService().insertMember(m);
		getView().printMsg(result>0 ? "성공" : "실패");
	}
}
