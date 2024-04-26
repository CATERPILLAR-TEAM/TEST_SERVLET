package com.example.app.controller.reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.ReservationDto;
import com.example.app.domain.common.service.ReservationService;
import com.example.app.domain.common.service.ReservationServiceImpl;

public class ReservUpdateController implements SubController {

	private ReservationService reservationService;
	private ConnectionPool connectionPool;

	public ReservUpdateController() {
		try {
			reservationService = ReservationServiceImpl.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ReservationUpdateController execute : ");

		String method = req.getMethod();

		if (method.contains("GET")) {
			// 경로지정 jsp
			try {
				req.getRequestDispatcher("/WEB-INF/view/reservation/update.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (method.contains("POST")) {
			// 1
			String room_info_id = req.getParameter("room_info_id");
			String user_id = req.getParameter("user_id");
			String reservation_type = req.getParameter("reservation_type");
			String check_in = req.getParameter("check_in");
			String check_out = req.getParameter("check_out");

			int room_id = Integer.parseInt(room_info_id);
			int userid = Integer.parseInt(user_id);
			boolean reservtype = Boolean.parseBoolean(reservation_type);
			LocalDateTime checkin = LocalDateTime.parse(check_in);
			LocalDateTime checkout = LocalDateTime.parse(check_out);
			ReservationDto dto = new ReservationDto(room_id, userid, reservtype, checkin, checkout);
			req.setAttribute("reservationDto", dto);

			// 2
			if (!isValid()) {
				return;

			}

			// 3 service
			boolean isUpdated = false;
			try {
				isUpdated = reservationService.updateReserv(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 4
			if (isUpdated) {
				try {
					resp.sendRedirect(req.getContextPath() + "/reserv/list?user_id=" + user_id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					resp.sendRedirect(req.getContextPath() + "/reserv/list?user_id=" + user_id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return;
	}

	private boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

}
