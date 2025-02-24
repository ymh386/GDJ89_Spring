package com.moon.app.notice;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moon.app.users.UserDTO;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(NoticeDTO noticeDTO, Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.getList(noticeDTO);
		
		model.addAttribute("list", ar);
		
		return "notice/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public void getDetail(NoticeDTO noticeDTO, Model model, HttpSession session)throws Exception{
		//"board" : set(글번호들,,)
		Object obj = session.getAttribute("board");
		boolean check=false;
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(noticeDTO.getBoardNum())) {
				ar.add(noticeDTO.getBoardNum());
				check=true;
			}else {
				
				check=false;
			}
		}else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(noticeDTO.getBoardNum());
			session.setAttribute("board", num);
			check=true;
		}
		
		noticeDTO= noticeService.getDetail(noticeDTO, check);
		model.addAttribute("dto", noticeDTO);
	}
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add(HttpSession session, Model model)throws Exception{
		
		if(session.getAttribute("user") == null) {
			model.addAttribute("result", "로그인 후 작성 가능");
			model.addAttribute("path", "./list");
		}else {
			return "/notice/add";
		}
		
		return "commons/result";
	}
		
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, HttpSession session)throws Exception{
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		noticeDTO.setUserName(userDTO.getUserName());
		int result = noticeService.add(noticeDTO);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model)throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO, false);
		model.addAttribute("dto", noticeDTO);
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO)throws Exception{
		int result =  noticeService.update(noticeDTO);
		
		//return "redirect:./list";
		return "redirect:./detail?boardNum="+noticeDTO.getBoardNum();
		
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO, Model model)throws Exception{
		int result = noticeService.delete(noticeDTO);
		String s = "삭제 실패";
		if(result>0) {
			s = "삭제 성공";
		}
		model.addAttribute("result", s);
		model.addAttribute("path", "./list");
		
		return "commons/result";
		
	}
}
