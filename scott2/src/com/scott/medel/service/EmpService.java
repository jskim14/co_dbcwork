package com.scott.medel.service;

public class EmpService {
	
	private static EmpService service;
	
	public static EmpService getService() {
		if(service==null) service=new EmpService();
		return service;
	}

}
