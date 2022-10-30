package com.employee.view;

import static com.employee.controller.EmployeeController.getController;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.employee.model.vo.Department;
import com.employee.model.vo.Employee;
import com.employee.model.vo.Job;

public class MainView {
	
	private static MainView view;
	private static Scanner sc = new Scanner(System.in);
	private MainView() {}

	public static MainView getView() {
		if(view==null) {
			view = new MainView();
		}
		return view;
	}

	public void mainMenu() {
//		1. 전체 사원조회
//		2. 사원조회 SubMenu(1.부서, 2.직책, 3.이름, 4. 급여(크고작고))
//		3. 사원등록
//		4. 사원수정(직책, 부서, 급여, 전화번호, 이메일)
//		5. 사원 삭제
//		5. 부서관리 submenu(1.등록, 2.수정,3.삭제)
//		6. 직책관리 submenu(1.등록, 2.부서수정,3.삭제)
		while(true) {
			System.out.println("===== 사원 관리 프로그램 =====");
			System.out.println("1. 전체 사원 조회");
			System.out.println("2. 사원 조회");
			System.out.println("3. 사원 등록");
			System.out.println("4. 사원 수정");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서 관리");
			System.out.println("7. 직책 관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
			int cho = sc.nextInt();
			switch(cho) {
				case 1: getController().searchAllEmp(); break;
				case 2: getController().searchEmp(); break;
				case 3: getController().insertEmp(); break;
				case 4: getController().updateEmp(); break;
				case 5: getController().deleteEmp(); break;
				case 6: getController().manageDept(); break;
				case 7: getController().manageJob(); break;
				case 0: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				
			}
		}
	}
	
	public String inputDept() {
		sc.nextLine();
		System.out.println("==== 부서로 조회하기 ====");
		System.out.print("조회할 부서코드 : ");
		String result = sc.nextLine();
		return result;
	}
	
	
	public void printEmpData(List<Employee> list) {
		System.out.println("=== 사원 조회 결과 ===");
		if(list.isEmpty()) System.out.println("조회된 결과가 없습니다.");
		else {
			for (Employee e : list) {
				System.out.println(e);
			}
		}
		
	}
	
	public void printDeptData(List<Department> list) {
		System.out.println("=== 모든 부서 조회 결과 ===");
		if(list.isEmpty()) System.out.println("조회된 결과가 없습니다.");
		else {
			for (Department d : list) {
				System.out.println(d);
			}
		}
	}
	
	public void printJobData(List<Job> list) {
		System.out.println("=== 모든 직급 조회 결과 ===");
		if(list.isEmpty()) System.out.println("조회된 결과가 없습니다.");
		else {
			for (Job j : list) {
				System.out.println(j);
			}
		}
	}
	
	
	public void subMenuSearchEmp() {
		while(true) {
			System.out.println("===== 사원 조회 =====");
			System.out.println("1. 부서");
			System.out.println("2. 직책");
			System.out.println("3. 이름");
			System.out.println("4. 급여");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("입력 : ");
			int cho = sc.nextInt();
			switch(cho) {
				case 1: getController().searchDept(); break;
				case 2: getController().searchJob(); break;
				case 3: getController().searchName(); break;
				case 4: getController().searchSal(); break;
				case 0: System.out.println("메인 메뉴로 돌아갑니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
		
	}

	public String inputJob() {
		sc.nextLine();
		System.out.println("==== 직급으로 조회하기 ====");
		System.out.print("조회할 직급코드 : ");
		String result = sc.nextLine();
		return result;
	}

	public String inputName() {
		sc.nextLine();
		System.out.println("==== 이름으로 조회하기 ====");
		System.out.print("조회할 이름 : ");
		String result = sc.nextLine();
		return result;
	}

	public int inputSal() {
		System.out.println("==== 월급으로 조회하기 ====");
		System.out.print("월급 : ");
		return sc.nextInt();
	}

	public String inputOp() {
		sc.nextLine();
		while(true) {
			String op=null;
			System.out.print("이상 or 이하 : ");
			op = sc.nextLine();
			if(!(op.equals("이상")||op.equals("이하"))) {
				System.out.println("이상 or 이하 둘 중 하나만 입력하십시오.");
			}else {
				return op;
			}
		}
	}

	public Employee insertEmp() {
		sc.nextLine();
		System.out.println("==== 사원 등록 ====");
		System.out.print("사원번호 : ");
		String empId = sc.nextLine();
		System.out.print("이름 : ");
		String empName = sc.nextLine();
		System.out.print("주민등록번호 : ");
		String empNo = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		System.out.print("부서코드 : ");
		String deptCode = sc.nextLine();
		System.out.print("직급코드 : ");
		String jobCode = sc.nextLine();		
		System.out.print("급여등급 : ");
		String salLevel = sc.nextLine();
		System.out.print("월급 : ");
		int salary = sc.nextInt();
		System.out.print("보너스 : ");
		int bonus = sc.nextInt();
		sc.nextLine();
		System.out.print("매니저 번호 : ");
		String managerId = sc.nextLine();
		Employee e = new Employee(empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, bonus, managerId, null, null, 'N');
		return e;
	}

	public Employee updateEmp() {
		// 사원수정(직책, 부서, 급여, 전화번호, 이메일)
		sc.nextLine();
		System.out.println("==== 전체 사원 정보 ====");
		getController().searchAllEmp();
		System.out.println("==== 사원 수정 ====");
		Employee e = new Employee();
		System.out.print("수정할 사원의 사원번호 : ");
		e.setEmpId(sc.nextLine());
		System.out.print("직책 : ");
		e.setJobCode(sc.nextLine());
		System.out.print("부서 : ");
		e.setDeptCode(sc.nextLine());
		System.out.print("급여 : ");
		e.setSalary(sc.nextInt());
		sc.nextLine();
		System.out.print("전화번호 : ");
		e.setPhone(sc.nextLine());
		System.out.print("이메일 : ");
		e.setEmail(sc.nextLine());
		return e;
		
	}

	public void printMsg(String msg) {
		System.out.println("===== 시스템 메시지 =====");
		System.out.println(msg);
		System.out.println("=====================");
		
	}

	public String deleteEmp() {
		sc.nextLine();
		System.out.println("==== 전체 사원 정보 ====");
		getController().searchAllEmp();
		System.out.println("==== 사원 삭제 ====");
		System.out.print("삭제할 사원의 사원번호 : ");
		return sc.nextLine();
	}

	public void subMenuManageDept() {
		//부서관리 submenu(1.등록, 2.수정,3.삭제)
		while(true) {
			System.out.println("==== 부서 관리 ====");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("입력 : ");
			int cho = sc.nextInt();
			switch(cho) {
				case 1: getController().insertDept(); break;
				case 2: getController().updateDept(); break;
				case 3: getController().deleteDept(); break;
				case 0: System.out.println("메인 메뉴로 돌아갑니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public Department insertDepartment() {
		sc.nextLine();
		System.out.println("==== 부서 등록 ====");
		System.out.print("부서코드 : ");
		String deptId = sc.nextLine();
		System.out.print("부서명 : ");
		String deptTitle = sc.nextLine();
		System.out.print("지역코드 : ");
		String locationId = sc.nextLine();
		Department d = new Department(deptId, deptTitle, locationId);
		
		return d;
		
	}

	public Department updateDept() {
		sc.nextLine();
		System.out.println("==== 전체 부서 정보 ====");
		getController().searchAllDept();
		System.out.println("==== 부서 수정 ====");
		Department d = new Department();
		System.out.print("수정할 부서의 부서코드 : ");
		d.setDeptId(sc.nextLine());
		System.out.print("부서명 : ");
		d.setDeptTitle(sc.nextLine());
		System.out.print("지역코드 : ");
		d.setLocationId(sc.nextLine());
		
		return d;
	}

	public String deleteDept() {
		sc.nextLine();
		System.out.println("==== 전체 부서 정보 ====");
		getController().searchAllDept();
		System.out.println("==== 부서 삭제 ====");
		System.out.print("삭제할 부서의 부서코드 : ");
		return sc.nextLine();
	}
	
	public void subMenuManageJob() {
		//직책관리 submenu(1.등록, 2.부서수정,3.삭제)
		while(true) {
			System.out.println("==== 직급 관리 ====");
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("입력 : ");
			int cho = sc.nextInt();
			switch(cho) {
				case 1: getController().insertJob(); break;
				case 2: getController().updateJob(); break;
				case 3: getController().deleteJob(); break;
				case 0: System.out.println("메인 메뉴로 돌아갑니다."); return;
				default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public Job insertJob() {
		sc.nextLine();
		System.out.println("==== 직급 등록 ====");
		System.out.print("직급코드 : ");
		String jobCode = sc.nextLine();
		System.out.print("직급명 : ");
		String jobName = sc.nextLine();
		Job j = new Job(jobCode, jobName);
		return j;
	}

	public Job updateJob() {
		sc.nextLine();
		System.out.println("==== 전체 직급 정보 ====");
		getController().searchAllJob();
		System.out.println("==== 부서 수정 ====");
		Job j = new Job();
		System.out.print("수정할 직급의 직급코드 : ");
		j.setJobCode(sc.nextLine());
		System.out.print("직급명 : ");
		j.setJobName(sc.nextLine());
		return j;
	}

	public String deleteJob() {
		sc.nextLine();
		System.out.println("==== 전체 직급 정보 ====");
		getController().searchAllJob();
		System.out.println("==== 직급 삭제 ====");
		System.out.print("삭제할 부서의 직급코드 : ");
		return sc.nextLine();
	}
	
	
}
