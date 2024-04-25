package com.example.app.controller.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberDeleteController implements SubController {

	private MemberService memberService;
	private ConnectionPool connectionPool;

	public MemberDeleteController() {

		try {

			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberDeleteController's execute() invoke ");

		try {

			// GET 요청
			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/delete.jsp").forward(request, response);
				return;
			}

			// POST 요청(etc Method)
			// 1
			int id = Integer.parseInt(request.getParameter("id"));
			// 2 validation
			if (!isValid()) {

				return;
			}

			// 3 service
			memberService.deleteMember(id);

			// 4 view

		} catch (Exception e) {
			e.printStackTrace();
			// 예외페이지로 넘기기..or new ServletException("message") 처ㅣ

			try {
				connectionPool.txRollBack();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}

	}

	private boolean isValid() {

		return true;
	}

}
