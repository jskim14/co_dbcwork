package com.scott.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.scott.controller.EmpController;
import com.scott.mode.vo.Employee;


public class MainView {
	
//	EmpController ec= new EmpController(); //--이거 왜 안돼...?? 헐...
	
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
				case 1 : new EmpController().allList(); break;
				case 2 : new EmpController().searchName(); break;
				case 3 :  break;
				case 4 :  break;
				case 5 :  break;
				case 6 :  break;
				case 0 : System.out.println("프로그램 종료"); return;
				default : System.out.println("잘못눌렀어"); break;
			}
		}
	}
	
	public void printData(ArrayList<Employee> list) {
		if(!(list.isEmpty())) {
			for(Employee e: list) {
			System.out.println(e);
			}
		} else {
			System.out.println("없음");
		}
	}
	
	public void printData(Employee e) {
		if(e!=null) System.out.println(e);
		else System.out.println("없어");
	}
	
	public String searchName() {
		Scanner sc= new Scanner(System.in);
		System.out.print("조회할 이름 : ");
		String name = sc.next();
		return name;
	}
	
	public int searchSalary() {
		Scanner sc= new Scanner(System.in);
		System.out.print("조회할 월급 : ");
		int salary= sc.nextInt();
		
		System.out.print("1. 이상 / 2. 이하 : ");
		int num= sc.nextInt();
		
		
		return salary;
		
		
	}
	
	

}
