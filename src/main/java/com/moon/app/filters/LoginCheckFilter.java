package com.moon.app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
public class LoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//필터 객체가 소멸될 때 실행
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//요청이 들어 왔을 때 실행하는 영역
		System.out.println("요청 발생");
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		Object obj = req.getSession().getAttribute("user");
		
		
		if(obj != null) {
			//다음 필터의 doFilter메서드 호출
			//다음 필터가 없다면 Dispatcher Servlet이동
			chain.doFilter(request, response);
		}
		
		//1. redirect
//		HttpServletResponse res = (HttpServletResponse)response;
//		res.sendRedirect("/users/login");
		
		//2. foward
		req.setAttribute("result", "로그인이 필요");
		req.setAttribute("path", "/users/login");
		RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
		view.forward(request, response);
		
		//응답이 나갈 때 실행 하는 영역
		System.out.println("응답 발생");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//필터 객체가 생성 될 때 실행
	}

}
