package com.member.run;

import com.member.controller.MemberController;
import com.member.model.dao.MemberDao;
import com.member.model.service.MemberService;
import com.member.view.MemberView;

public class Main {
	

	public static void main(String[] args) {
		MemberController.getController().mainMenu();
	}

}

