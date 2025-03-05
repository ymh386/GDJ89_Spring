package com.moon.app.users;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.moon.app.products.ProductDTO;

@Controller
@RequestMapping(value = "/users/*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public String cart(CartDTO cartDTO, HttpSession session, Model model) throws Exception {
		List<CartDTO> ar = userService.cart(cartDTO);
		
		model.addAttribute("list", ar);
		
		return "users/cart";
		
	}
	
	@RequestMapping(value = "addCart", method = RequestMethod.GET)
	public String addCart(CartDTO cartDTO, HttpSession session, Model model) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		cartDTO.setUserName(userDTO.getUserName());
		int result = userService.addCart(cartDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	//	/users/check
	//check
	@RequestMapping(value = "check", method = RequestMethod.GET)
	public String check(UserDTO userDTO, Model model) throws Exception {
		System.out.println("ID 중복 체크");
		System.out.println(userDTO.getUserName());
		userDTO = userService.getDetail(userDTO);
		//userDTO == null 이면 가입 가능 중복 X
		//userDTO != null 이면 가입 불가 중복 O
		int result = 0; //중복 0
		if(userDTO == null) {
			result = 1; //중복아님
		}
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() throws Exception {
		
		return "users/join";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO userDTO, MultipartFile profile, HttpSession session) throws Exception {
		System.out.println(profile.getContentType());
		System.out.println(profile.getName());
		System.out.println(profile.getOriginalFilename());
		System.out.println(profile.getSize());
		System.out.println(profile.isEmpty());
		System.out.println(session.getServletContext());
		
		int result = userService.join(userDTO, profile, session.getServletContext());
		
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
	public String getDetail(UserDTO userDTO, HttpSession session, Model model) throws Exception {
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
	public String update(UserDTO userDTO, HttpSession session, MultipartFile profile) throws Exception {
		UserDTO dto = (UserDTO)session.getAttribute("user");
		
		userDTO.setUserName(dto.getUserName());
		
		int result = userService.update(userDTO, profile, session);
		
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
