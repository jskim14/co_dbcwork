package com.member.controller;

import static com.member.model.service.MemberService.getService;
import static com.member.view.MemberView.getView;

import java.util.ArrayList;

import com.member.model.vo.Member;

public class MemberController {
	
	private static MemberController controller;
	
	private MemberController() {}
	
	public static MemberController getController() {
		if(controller==null) controller =new MemberController();
		return controller;
	}
	
	public void mainMenu() {
		getView().mainMenu();
	}
	
	public void searchAll() {
		//dao로부터 받아오는게 아니라 서비스에서 전체를 데려온다.
		ArrayList<Member> list =getService().searchAll();
		getView().print(list);
	}
	
	public void subMenuCase() {
		int num = getView().subMenu();
		switch(num) { //1.부서 / 2.직책 / 3.이름 / 4.급여
			case 1 : subMenuDept(); break;
			case 2 : subMenuJob(); break;
			case 3 : subMenuName(); break; 
			case 4 : subMenuSalary(); break; 
		}
	}

	public void subMenuDept() {
		getView().printDept(getService().deptList());
		String str=getView().searchData("부서");
		ArrayList<Member> list = getService().searchDept(str);
		getView().print(list);
	}

	public void subMenuJob() {
		getView().printJob(getService().jobList());
		String str=getView().searchData("직책");
		ArrayList<Member> list = getService().searchJob(str);
		getView().print(list);
	}
	
	public void subMenuName() {
		String str=getView().searchData("성명");
		ArrayList<Member> list = getService().searchName(str);
		getView().print(list);
	}
	
	public void subMenuSalary() { //이상, 이하
		String str=getView().searchData("급여");
		ArrayList<Member> list = getService().searchDept(str);
		getView().print(list);
	}
	
	public void enroll() {
		Member m = getView().inputData();
		int result=getService().insertMember(m);
	}
	
	public void modify() { //수정
		Member m= getView().modify();
		getService().update(m);
	}
	
	public void remove() {
		String str = getView().searchData("사원아이디");
		int result =getService().searchId(str);
		System.out.println("삭제완료");
	}
	
	public void deptManage() {//부서관리
		
	}
	
	
}
