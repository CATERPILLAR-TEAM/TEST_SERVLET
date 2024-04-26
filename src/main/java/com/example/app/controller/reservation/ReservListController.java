package com.example.app.controller.reservation;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.ReservationDto;
import com.example.app.domain.common.service.ReservationService;
import com.example.app.domain.common.service.ReservationServiceImpl;


public class ReservListController implements SubController {

	private ReservationService reservService;
	private ConnectionPool connectionPool;
	private ReservationDto reservationDto;
	
	public ReservListController() {
		try {
			reservService = ReservationServiceImpl.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ReservationListController execute : ");
		
//		Map<String, Object> returnValue = null;
//		
//		List<ReservationDto> list = (List<ReservationDto>) returnValue.get("list");
//		ReservationDto reservationDto = (ReservationDto)returnValue.get("reservationDto");
//		
//		req.setAttribute("list", list);
		req.setAttribute("reservationDto", reservationDto);
		
		try {
			req.getRequestDispatcher("/WEB-INF/view/reservation/list.jsp").forward(req, resp);
			return ;
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
