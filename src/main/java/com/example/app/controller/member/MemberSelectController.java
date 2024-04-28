package com.example.app.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberSelectController implements SubController {
	
	private MemberService memberService;
	private ConnectionPool connectionPool;

	public MemberSelectController() {

		try {
			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberSelectController's execute() invoke ");
		
		try {
			
//			MemberDto memberDto = memberService.selectMember();
			
			
			
			request.getRequestDispatcher("/WEB-INF/views/member/read.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
