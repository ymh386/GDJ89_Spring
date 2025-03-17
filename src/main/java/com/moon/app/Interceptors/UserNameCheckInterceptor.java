package com.moon.app.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.moon.app.boards.BoardDTO;
import com.moon.app.boards.notice.NoticeDAO;
import com.moon.app.products.ProductDTO;
import com.moon.app.users.UserDTO;

public class UserNameCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		
		String kind = (String)modelAndView.getModel().get("kind");
		
		
		Object objDTO = (BoardDTO)modelAndView.getModel().get("dto");
		
		String name="";
		
		if(objDTO instanceof BoardDTO) {
			name = ((BoardDTO)objDTO).getUserName();
		}
		
		if(!userDTO.getUserName().equals(name)) {
			modelAndView.setViewName("/commons/result");
			modelAndView.getModel().put("result", "작성자만 가능");
			modelAndView.getModel().put("path", "./list");
			
		}
	}
	
	

}
