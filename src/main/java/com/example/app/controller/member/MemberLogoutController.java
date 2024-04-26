package com.example.app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberLogoutController implements SubController {
	
	private MemberService memberService;
	private ConnectionPool connectionPool;

	public MemberLogoutController() {

		try {

			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
