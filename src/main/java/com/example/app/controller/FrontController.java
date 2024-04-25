package com.example.app.controller;

import java.io.IOException;	
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.reserv.ReservAddController;
import com.example.app.controller.reserv.ReservDeleteController;
import com.example.app.controller.reserv.ReservListController;
import com.example.app.controller.reserv.ReservUpdateController;


public class FrontController extends HttpServlet{
	
	private Map<String,SubController> map;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FrontController's init() invoke..");
		
		
		map = new HashMap();
		
		String path = config.getServletContext().getContextPath();
		// '/'
		map.put(path+"/", new HomeController());
		
		//reservation
		map.put(path+"/reserv/add", new ReservAddController());
		map.put(path+"/reserv/list", new ReservListController());
		map.put(path+"/reserv/update", new ReservUpdateController());
		map.put(path+"/reserv/delete", new ReservDeleteController());
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//UTF-8
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String uri =  request.getRequestURI();
		System.out.println("FrontController's service() invoke.."+uri);
		
		SubController controller =  map.get(uri);
		if(controller==null) {
			throw new ServletException("해당 페이지는 존재하지 않습니다..");
		}
			
		controller.execute(request, response);
		
		
	}


	
	
}
