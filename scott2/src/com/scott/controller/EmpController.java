package com.scott.controller;

public class EmpController {

	private static EmpController controller;
	
	private EmpController() {}
	
	public static EmpController getController() {
		if(controller==null) controller=new EmpController();
		return controller;
	}
	
	
}
