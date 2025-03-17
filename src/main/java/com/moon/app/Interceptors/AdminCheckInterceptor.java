package com.moon.app.Interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moon.app.users.UserDTO;

@Component
public class AdminCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//DS -> Controller
		
		Object user = request.getSession().getAttribute("user");
		
		UserDTO userDTO = (UserDTO)user;
		
		if(user != null && userDTO.getUserName().equals("admin")) {
			return true;
		}
		
		//1.redirect
//		response.sendRedirect("/users/login");
		//2. forward
		request.setAttribute("result", "관리자만 사용가능");
		request.setAttribute("path", "./list");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		//return이 true라면 Controller로 진행
		//return이 false라면 Controller로 진행X
		return false;
	}

}
