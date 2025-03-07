package com.moon.app.accounts;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moon.app.users.UserDTO;

@Controller
@RequestMapping(value = "/accounts/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Long [] productNum, HttpSession session, Model model) throws Exception {		
		int result = accountService.add(productNum, (UserDTO)session.getAttribute("user"));
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}

}
