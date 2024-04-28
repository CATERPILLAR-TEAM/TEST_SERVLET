package com.example.app.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.service.MemberService;
import com.example.app.domain.common.service.MemberServiceImpl;

public class MemberUpdateController implements SubController {


	private MemberService memberService;
	private ConnectionPool connectionPool;
	
	public MemberUpdateController(){
		
		try {		
			memberService = MemberServiceImpl.getInstance();
			connectionPool = ConnectionPool.getInstance();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberUpdateController's execute() invoke ");
		

		try {
			
			String method = request.getMethod();
			if(method.contains("GET")) {
				request.getRequestDispatcher("/WEB-INF/view/member/read.jsp").forward(request, response);
				return ;
			}
			
			
			// 1 파라미터
			String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
			
			// 2 유효성
			if(!isValid(username,password,email,phone)){
				return ;
			}
			
			// 3 서비스
            MemberDto memberDto = new MemberDto(username, password, email,phone);
            
            boolean isUpdated = memberService.update(username,password,email,phone);
            
			// 4 뷰
            if (isUpdated) {
            	response.sendRedirect(request.getContextPath()+ "/member/read?username="+username);
            } else {
            	response.sendRedirect(request.getContextPath()+ "/member/read");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private boolean isValid(String username, String password, String email, String phone) {
		return true;
	}
}
