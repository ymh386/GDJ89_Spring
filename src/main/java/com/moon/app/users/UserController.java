package com.moon.app.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "users/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO userDTO) throws Exception {
		int result = userService.join(userDTO);
		
		return "redirect:../";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() throws Exception {
		
		return "users/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserDTO userDTO, HttpSession session, Model model) throws Exception {
		userDTO = userService.login(userDTO);
		if(userDTO != null) {
			session.setAttribute("user", userDTO);
			
			return "redirect:../";
		}else {
			
			model.addAttribute("result", "로그인 실패");
			model.addAttribute("path", "./login");
			return "commons/result";
		}
			
		}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String getDetail(UserDTO userDTO, Model model) throws Exception {
		userDTO = userService.getDetail(userDTO);
		
		model.addAttribute("dto", userDTO);
		
		return "users/mypage";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(UserDTO userDTO, Model model) throws Exception {
		userDTO = userService.getDetail(userDTO);
		
		model.addAttribute("dto", userDTO);
		
		return "users/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(UserDTO userDTO) throws Exception {
		int result = userService.update(userDTO);
		
		return "redirect:./mypage?userName=" + userDTO.getUserName();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(UserDTO userDTO, HttpSession session, Model model) throws Exception {
		int result = userService.delete(userDTO);
		
		String str = "회원 탈퇴 실패";
		if(result > 0) {
			str = "회원 탈퇴 성공";
		}
		model.addAttribute("result", str);
		model.addAttribute("path", "../");
		
		session.invalidate();
		
		return "commons/result";
	}
	
	

}
