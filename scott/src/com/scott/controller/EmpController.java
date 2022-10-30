package com.scott.controller;

import java.util.ArrayList;

import com.scott.mode.dao.EmpDao;
import com.scott.mode.vo.Employee;
import com.scott.view.MainView;

public class EmpController {
	MainView mv = new MainView();
	
	public void mainMenu() {
		mv.mainMenu();
	}
	
	public void allList() {
		ArrayList<Employee> list =new EmpDao().allList();
		new MainView().printData(list);
	}
	
	public void searchName() { 
		String name=new MainView().searchName(); 
		Employee e=new EmpDao().searchName(name);
		new MainView().printData(e);
	}
	
	public void searchSalary(int num, int salary) {
		//월급 받아와
//		new MainView().searchSalary();
//		new EmpDao().searchSalary(salary);
	}

}
