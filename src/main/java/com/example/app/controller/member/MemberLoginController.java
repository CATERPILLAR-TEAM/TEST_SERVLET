package com.example.app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberLoginController implements SubController {

	private MemberService memberService;
	private ConnectionPool connectionPool;

	public MemberLoginController() {

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

		try {
			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("WEB-INF/view/member/login.jsp");
				return;
			}

			// 1 parameter
			if (method.contains("POST")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				// 2 validation
				if (!isValid()) {
					return;
				}

				// 3 service
				memberService.login(username, password);

				// 4 view

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
