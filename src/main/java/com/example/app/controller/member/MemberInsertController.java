package com.example.app.controller.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
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

			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/register.jsp").forward(request, response);
				return;
			}

			if (method.contains("POST")) {

				// 1 파라미터
				int id = 0;
				String realname = request.getParameter("realname");
				String birth = request.getParameter("birth");
				boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String confrimPassword = request.getParameter("confrimPassword");

				// 2 유효성
				if (!isValid(realname, birth, gender, phone, email, username, password, confrimPassword)) {

				} else {

				}

				// 3 서비스
				MemberDto memberDto = new MemberDto(id, realname, birth, gender, phone, email, username, password,
						confrimPassword);
				memberService.register(memberDto);

				// 4 뷰
				response.sendRedirect(request.getContextPath() + "/admin/member/insert");

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

	private boolean isValid(String realname, String birth, boolean gender, String phone, String email, String username,
			String password, String confrimPassword) {
		if (password != confrimPassword) {
			return false;
		}
		if (realname == null || realname.isEmpty()) {
			return false;
		}
		if (birth == null || birth.isEmpty()) {
			return false;
		}
		if (birth.isBlank() || birth.isEmpty()) {
			return false;
		}
		if (phone == null || phone.isEmpty()) {
			return false;
		}
		if (email == null || email.isEmpty()) {
			return false;
		}
		if (username == null || username.isEmpty()) {
			return false;
		}
		if (password == null || password.isEmpty()) {
			return false;
		}
		if (confrimPassword == null || confrimPassword.isEmpty()) {
			return false;
		}
		return true;
	}

}
