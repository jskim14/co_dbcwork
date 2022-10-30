package com.member.view;


import static com.member.controller.MemberController.getController;

import java.util.ArrayList;
import java.util.Scanner;

import com.member.model.vo.Department;
import com.member.model.vo.Job;
import com.member.model.vo.Member;

public class MemberView {
	
	private static MemberView view;
	
	private MemberView() {}
	
	public static MemberView getView() {
		if(view==null) view=new MemberView();
		return view;
	}
	
	public void mainMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("==== 사원관리 프로그램 ====");
		
		while(true) {
			System.out.println("1. 전체사원 조회");
			System.out.println("2. 사원조회(부서,직책,이름,급여)");
			System.out.println("3. 사원등록");
			System.out.println("4. 사원수정(직책,부서,급여,전화번호,이메일)");
			System.out.println("5. 사원삭제");
			System.out.println("6. 부서관리");
			System.out.println("7. 직책관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int cho =sc.nextInt();
			switch(cho) {
				case 1 : getController().searchAll() ; break;
				case 2 : getController().subMenuCase() ; break;
				case 3 : getController().enroll(); break;
				case 4 : getController().modify(); break;
				case 5 : getController().remove(); break;
				case 6 : getController().deptManage(); break;
				case 7 : ; break;
				case 0 : System.out.println("프로그램 종료"); return;
			}
		}
	}
	
	public void print(ArrayList<Member> list) {
		if(list.isEmpty()) System.out.println("조회결과 없음");
		else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
	}
	
	public void printDept(ArrayList<Department> list) {
		if(list.isEmpty()) System.out.println("조회결과 없음");
		else {
			for(Department m : list) {
				System.out.println(m.getDeptTitle());
			}
			System.out.println();
		}
	}
	
	public void printJob(ArrayList<Job> list) {
		if(list.isEmpty()) System.out.println("조회결과 없음");
		else {
			for(Job j : list) {
				System.out.println(j.getJobName());
			}
			System.out.println();
		}
	}
	
	public int subMenu() {
		Scanner sc= new Scanner(System.in);
		System.out.println("조회 (1.부서 / 2.직책 / 3.이름 / 4.급여)");
		return sc.nextInt();
	}
	
	public String searchData(String str) {
		Scanner sc= new Scanner(System.in);
		System.out.print("조회할 "+str+" 검색 : ");
		return sc.nextLine();
	}
	
	public Member inputData() {
		Scanner sc= new Scanner(System.in);
		Member m =new Member();
		System.out.print("아이디 : ");
		m.setEmpId(sc.nextLine());
		System.out.print("이름 : ");
		m.setEmpName(sc.nextLine());
		sc.nextLine();
		System.out.print("주민등록번호 : ");
		m.setEmpNo(sc.nextLine());
		System.out.print("이메일 : ");
		m.setEmail(sc.nextLine());
		System.out.print("연락처 : ");
		m.setPhone(sc.nextLine());
		//-------------------
		Department dept= new Department();
		System.out.print("부서코드 : ");
		dept.setDeptId(sc.nextLine());
		System.out.print("부서명 : ");
		dept.setDeptTitle(sc.nextLine());
		System.out.print("지역 : ");
		dept.setLocationId(sc.nextLine());
		m.setDept(dept);
		//-------------------
		Job job= new Job();
		System.out.print("직책코드 : ");
		job.setJobCode(sc.nextLine());
		System.out.print("직책명 : ");
		job.setJobName(sc.nextLine());
		m.setJob(job);
		//-------------------
		System.out.print("급여등급 : ");
		m.setSalLevel(sc.nextLine());
		System.out.print("급여 : ");
		m.setSalary(sc.nextLine());
		System.out.print("보너스율 : ");
		m.setBonus(sc.nextLine());
		System.out.print("관리자 번호 : ");
		m.setManagerId(sc.nextLine());
		System.out.print("입사일 : ");
		String hire=sc.nextLine();
		m.setHireDate(hire); 
		System.out.print("퇴사일");
		m.setEntDate(sc.nextLine());
		System.out.print("재직여부 : ");
		m.setEntYn(sc.nextLine());
		System.out.println(m.toString());

		return m;
	}
	
	public Member modify() {//직책,부서,급여,전화번호,이메일
		Scanner sc= new Scanner(System.in);
		Member m = new Member();
		System.out.println("수정할 회원의 아이디 : ");
		m.setEmpId(sc.nextLine());
		
		
		System.out.print("직책코드 : ");
		m.getJob().setJobCode(sc.nextLine());
		System.out.print("부서 : ");
		m.getDept().setDeptId(sc.nextLine());
		System.out.print("전화번호 : ");
		m.setPhone(sc.nextLine());
		System.out.print("급여 : ");
		m.setSalary(sc.nextLine());
		System.out.print("이메일 : ");
		m.setEmail(sc.nextLine());
		return m;
	}
	
	public void modifyDept() { //등록,수정,삭제
		Scanner sc= new Scanner(System.in);
		
	}
	

}
