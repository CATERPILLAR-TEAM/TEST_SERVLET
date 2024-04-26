package com.example.app.controller.reserv;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.ConnectionPool;
import com.example.app.domain.common.dto.ReservDto;
import com.example.app.domain.common.service.ReservService;
import com.example.app.domain.common.service.ReservServiceImpl;


public class ReservAddController implements SubController {
	
	private ReservService ReservService;
	private ConnectionPool connectionPool;
	 
	public ReservAddController() {
		
		try {
			ReservService = ReservServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ResevAddController's execute() invoke");
		
		try {
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/reservation/add.jsp").forward(request, response);
				return;
			}
				
				

		
		//1
		
			
			
		String room_info_id = request.getParameter("room_info_id");
		String user_id = request.getParameter("user_id");
		String reservation_type = request.getParameter("reservation_type");
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		
		LocalDateTime cIn = LocalDateTime.parse(checkIn);
		LocalDateTime cOut = LocalDateTime.parse(checkOut);
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");
//		LocalDateTime checkInDateTime = LocalDateTime.parse(checkIn, formatter);
//		LocalDateTime checkOutDateTime = LocalDateTime.parse(checkOut, formatter);
		
		
		//2isValid(room_info_id,user_id,reservation_type,checkIn,checkOut)
//		if(!isValid(room_info_id,user_id,reservation_type,checkIn,checkOut)) {
//			
//			
//			return;
//			
//		}
//		
		
		
		//3 
		ReservDto reservDto = new ReservDto(Integer.parseInt(room_info_id),Boolean.parseBoolean(reservation_type),cIn,cOut);
		
			boolean isAdded = ReservService.reservRegister(reservDto);
//		
			System.out.println("추가되었습니다.");
			
		//4
			
			if(isAdded) {
				
				response.sendRedirect(request.getContextPath()+ "/reserv/list");
				return;
				
			}
			else {
				System.out.println("안돼. 돌아가.");
				//request.getRequestDispatcher("/WEB-INF/view/reservation/add.jsp").forward(request, response);
				
			}	
		
		}catch(Exception e) {
			e.printStackTrace();
			//예외페이지로 넘기기..or new ServletException("message") 처리
			
			try {
				connectionPool.txRollBack();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		}	
		
	}

	private boolean isValid(String room_info_id, String user_id, String reservation_type, LocalDateTime checkIn, LocalDateTime checkOut) {
		if(room_info_id==null || room_info_id.isEmpty()) {
			return false;
		}
		if(user_id==null || user_id.isEmpty()) {
			return false;
		}
		if(reservation_type==null || reservation_type.isEmpty()) {
			return false;
		}
		if(checkIn==null) {
			return false;
		}
		if(checkOut==null) {
			return false;
		}
		return true;
	}


}
