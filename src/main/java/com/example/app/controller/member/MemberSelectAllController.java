package com.example.app.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberSelectAllController implements SubController {
	
	private MemberService memberService;
	private ConnectionPool connectionPool;
	
	public MemberSelectAllController(){
		
		try {		
			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberSelectAllController's execute() invoke ");
		
		try {
			
			List<MemberDto> list = memberService.selectAll();
			
			request.setAttribute("list",list);
			
			request.getRequestDispatcher("/WEB-INF/view/member/list.jsp").forward(request, response);

			
		 } catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
