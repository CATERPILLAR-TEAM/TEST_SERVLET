package com.example.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.member.MemberDeleteController;
import com.example.app.controller.member.MemberLoginController;
import com.example.app.controller.member.MemberLogoutController;
import com.example.app.controller.member.MemberRegisterController;
import com.example.app.controller.member.MemberSelectAllController;
import com.example.app.controller.member.MemberSelectController;
import com.example.app.controller.member.MemberUpdateController;
import com.example.app.controller.reservation.ReservAddController;
import com.example.app.controller.reservation.ReservDeleteController;
import com.example.app.controller.reservation.ReservListController;
import com.example.app.controller.reservation.ReservUpdateController;

public class FrontController extends HttpServlet {

	private Map<String, SubController> map;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FrontController's init() invoke..");

		map = new HashMap<>();

		String path = config.getServletContext().getContextPath();
		// '/'
		map.put(path + "/", new HomeController());
		// reservation
		map.put(path + "/reserv/add", new ReservAddController());
		map.put(path + "/reserv/list", new ReservListController());
		map.put(path + "/reserv/update", new ReservUpdateController());
		map.put(path + "/reserv/delete", new ReservDeleteController());

		// user
		map.put(path + "/member/delete", new MemberDeleteController());
		map.put(path + "/member/register", new MemberRegisterController());
		map.put(path + "/member/update", new MemberUpdateController());
		map.put(path + "/member/select", new MemberSelectController());
		map.put(path + "/member/selectAll", new MemberSelectAllController());
		map.put(path + "/member/login", new MemberLoginController());
		map.put(path + "/member/logout", new MemberLogoutController());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();
		System.out.println("FrontController's service() invoke.." + uri);

		SubController controller = map.get(uri);
		if (controller == null) {
			throw new ServletException("해당 페이지는 존재하지 않습니다..");
		}

		controller.execute(request, response);

	}

}
