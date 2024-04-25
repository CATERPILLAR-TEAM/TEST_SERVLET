package com.example.app.controller.member;

import java.sql.SQLException;

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
		System.out.println("MemberLoginController's execute() invoke");

		try {
			// GET
			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
				return;
			}

			// POST
			if (method.contains("POST")) {
				// 1 parameter
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				// 2 validation
				if (!isValid()) {

					return;
				}
				// 3 service
				memberService.login(username, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connectionPool.txRollBack();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	private boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
}
