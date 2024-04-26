package com.example.app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
				return;
			}

			if (method.contains("POST")) {
				// 1 parameter
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				HttpSession session = request.getSession();

				// 2 validation
				if (!isValid()) {
					return;
				}

				// 3 service
				boolean isSuccess = memberService.login(username, password, session);

				// 4 view
				if (isSuccess) {

					response.sendRedirect(request.getContextPath() + "/");
				} else {
					System.err.println("ERROR!!!");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isValid() {
		return true;
	}

}
