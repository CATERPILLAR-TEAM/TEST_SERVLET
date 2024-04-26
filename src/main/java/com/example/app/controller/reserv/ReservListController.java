package com.example.app.controller.reserv;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.ConnectionPool;
import com.example.app.domain.common.dto.ReservDto;
import com.example.app.domain.common.service.ReservService;
import com.example.app.domain.common.service.ReservServiceImpl;

public class ReservListController implements SubController {

	private ReservService reservService;
	private ConnectionPool connectionPool;
	
	
	//생성자-싱글톤
	public ReservListController() {
		
		try {
			reservService = ReservServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ReservListController's execute() invoke");
		
		
		
			String method = request.getMethod();
			if(method.contains("GET"))
				try {
					request.getRequestDispatcher("/WEB-INF/view/reservation/list.jsp").forward(request, response);
					System.out.println("list 페이지 보여줄게");
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			String userId = request.getParameter("userId");
			
			if(!Valid(userId)) {
				return;
			}
			
			
			
			//4
			request.setAttribute("userId", method)
	

			
			
			
			
			
			
			
			
	}



	private boolean Valid(String userId) {
		
		return true;
	}
	
	

}
