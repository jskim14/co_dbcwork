package com.employee.controller;

import static com.employee.model.service.EmployeeService.getService;
import static com.employee.view.MainView.getView;

import java.util.List;

import com.employee.model.vo.Department;
import com.employee.model.vo.Employee;
import com.employee.model.vo.Job;

public class EmployeeController {
	private static EmployeeController controller;
	
	public  EmployeeController() {}
	
	public static EmployeeController getController() {
		if(controller==null) controller = new EmployeeController();
		return controller;
	}
	
	public void mainMenu() {
		getView().mainMenu();
	}
	
	public void searchAllEmp() {
		List<Employee> list = getService().searchAllEmp();
		getView().printEmpData(list);
	}

	public void searchEmp() {
		getView().subMenuSearchEmp();
	}

	public void searchDept() {
		List<Department> AllList = getService().searchAllDept();
		getView().printDeptData(AllList);
		String searchDept = getView().inputDept();
		List<Employee> list = getService().searchDept(searchDept);
		getView().printEmpData(list);	
	}
	
	public void searchJob() {
		List<Job> AllList = getService().searchAllJob();
		getView().printJobData(AllList);
		String searchJob = getView().inputJob();
		List<Employee> list = getService().searchJob(searchJob);
		getView().printEmpData(list);	
	}

	public void searchName() {
		List<Employee> AllList = getService().searchAllEmp();
		getView().printEmpData(AllList);
		String searchName = getView().inputName();
		List<Employee> list = getService().searchName(searchName);
		getView().printEmpData(list);
	}

	public void searchSal() {
		int searchSal = getView().inputSal();
		String op = getView().inputOp();
		List<Employee> list = getService().searchSal(searchSal,op);
		getView().printEmpData(list);
		
	}

	public void insertEmp() {
		Employee e = getView().insertEmp();
		int result = getService().insertEmp(e);
		getView().printMsg(result>0?"저장 성공":"저장 실패");
	}

	public void updateEmp() {
		Employee e = getView().updateEmp();
		int result = getService().updateEmp(e);
		getView().printMsg(result>0?"수정 성공":"수정 실패");
		
	}
	
	public void deleteEmp() {
		String deleteId = getView().deleteEmp();
		int result = getService().deleteEmp(deleteId);
		getView().printMsg(result>0?"삭제 성공":"삭제 실패");
		
	}

	public void manageDept() {
		getView().subMenuManageDept();
		
	}

	public void insertDept() {
		Department d = getView().insertDepartment();
		int result = getService().insertDepartment(d);
		getView().printMsg(result>0?"저장 성공":"저장 실패");
		
	}

	public void updateDept() {
		Department d = getView().updateDept();
		int result = getService().updateDept(d);
		getView().printMsg(result>0?"수정 성공":"수정 실패");
		
	}

	public void searchAllDept() {
		List<Department> AllList = getService().searchAllDept();
		getView().printDeptData(AllList);
		
	}

	public void deleteDept() {
		String deleteId = getView().deleteDept();
		int result = getService().deleteDept(deleteId);
		getView().printMsg(result>0?"삭제 성공":"삭제 실패");
		
	}

	public void insertJob() {
		Job j = getView().insertJob();
		int result = getService().insertJob(j);
		getView().printMsg(result>0?"저장 성공":"저장 실패");
		
	}

	public void updateJob() {
		Job j = getView().updateJob();
		int result = getService().updateJob(j);
		getView().printMsg(result>0?"수정 성공":"수정 실패");
		
	}

	public void searchAllJob() {
		List<Job> AllList = getService().searchAllJob();
		getView().printJobData(AllList);
		
	}

	public void deleteJob() {
		String deleteCode = getView().deleteJob();
		int result = getService().deleteJob(deleteCode);
		getView().printMsg(result>0?"삭제 성공":"삭제 실패");
		
	}

	public void manageJob() {
		getView().subMenuManageJob();
		
	}
	
	
}
