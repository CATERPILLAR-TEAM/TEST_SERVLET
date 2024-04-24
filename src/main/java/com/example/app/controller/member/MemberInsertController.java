package com.example.app.controller.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberInsertController implements SubController {
	
	private MemberService memberService;
	private ConnectionPool connectionPool;
	
	public MemberInsertController() {

		try {
			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberInsertController's execute() invoke ");
		try {
			
			// 1 파라미터
			String realname = request.getParameter("realname");
			String birth = request.getParameter("birth");
			int gender 
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confrimPassword = request.getParameter("confrimPassword");
			
			// 2 유효성
			
			// 3 서비스
			
			// 4 뷰
			response.sendRedirect(request.getContextPath()+ "/admin/member/insert");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
