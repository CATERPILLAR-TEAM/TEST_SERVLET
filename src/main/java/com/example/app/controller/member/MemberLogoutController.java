package com.example.app.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
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

		String method = request.getMethod();

		try {
			if (method.contains("GET")) {
				request.getRequestDispatcher("WEB-INF/view/member/delete.jsp").forward(request, response);
				return;
			}
			if (method.contains("POST")) {
				// 1 parameter : none

				// 2 validation : none

				// 3 service
//				memberService.logout();

				// 4 view
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
