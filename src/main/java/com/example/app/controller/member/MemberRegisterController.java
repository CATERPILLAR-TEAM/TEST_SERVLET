package com.example.app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberRegisterController implements SubController {

	private MemberService memberService;
	private ConnectionPool connectionPool;

	public MemberRegisterController() {

		try {
			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberRegisterController's execute() invoke ");
		try {

			String method = request.getMethod();
			if (method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/register.jsp").forward(request, response);
				return;
			}

			if (method.contains("POST")) {

				// 1 파라미터
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
				MemberDto memberDto = new MemberDto(realname, birth, gender, phone, email, username, password,
						confrimPassword);
				boolean isSuccess = memberService.register(memberDto);
				if (!isSuccess) {
					System.err.println("ERROR!!!!!!!!!!");
				} else {
				// 4 뷰
//				response.sendRedirect(request.getContextPath() + "/member/login");
				request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
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
