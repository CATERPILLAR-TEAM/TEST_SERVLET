package com.example.app.controller.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.service.ReservationService;
import com.example.app.domain.common.service.ReservationServiceImpl;

public class ReservDeleteController implements SubController {

	private ReservationService reservationService;
	private ConnectionPool connectionPool;

	public ReservDeleteController() {
		try {
			reservationService = ReservationServiceImpl.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ReservDeleteController execute : ");

		// 1
		String user_id = req.getParameter("user_id");

		String method = req.getMethod();

		if (method.contains("GET")) {
			// 경로지정 jsp
			try {
				req.getRequestDispatcher("/WEB-INF/view/reservation/delete.jsp").forward(req, resp);
				return;
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 2
		if (!isValid(user_id)) {
			return;
		}

		// 3
		boolean isRemoved = false;
		try {
			isRemoved = reservationService.removeReserv(user_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4
		if (true) {
			try {
				
				resp.sendRedirect(req.getContextPath() + "/reserv/list");
				return ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect(req.getContextPath() + "/reserv/list?user_id=" + user_id);
				return ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean isValid(String user_id) {
		// TODO Auto-generated method stub
		return true;
	}

}
