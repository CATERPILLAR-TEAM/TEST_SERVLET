package com.example.app.controller.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.service.ReservationServiceImpl;

public class ReservAddController implements SubController {
	
	private ReservationServiceImpl reservServiceImpl;
	private ConnectionPool connectionPool;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ReservAddController execute : ");
		
		
	}
	
	
	
	
}
