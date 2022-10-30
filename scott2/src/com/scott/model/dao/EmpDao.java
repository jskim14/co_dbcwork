package com.scott.model.dao;

public class EmpDao {
	
	public static EmpDao dao;
	
	private EmpDao() {}
	
	public static EmpDao getEmpDao() {
		if(dao==null) dao=new EmpDao();
		return dao;
	}

}
