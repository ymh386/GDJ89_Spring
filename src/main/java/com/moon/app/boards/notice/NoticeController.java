package com.moon.app.boards.notice;

import java.io.Reader;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.moon.app.boards.BoardDTO;
import com.moon.app.pages.Pager;
import com.moon.app.users.UserDTO;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("kind")
	public String getKind() {
		return "notice";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		System.out.println("Notice List");
		List<BoardDTO> ar = noticeService.getList(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
		
		return "board/list";
	}
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO boardDTO, Model model, HttpSession session)throws Exception{
		//"board" : set(글번호들,,)
		Object obj = session.getAttribute("board");
		boolean check=false;
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(boardDTO.getBoardNum())) {
				ar.add(boardDTO.getBoardNum());
				check=true;
			}else {
				
				check=false;
			}
		}else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(boardDTO.getBoardNum());
			session.setAttribute("board", num);
			check=true;
		}
		
		boardDTO= (NoticeDTO)noticeService.getDetail(boardDTO, check);
		model.addAttribute("dto", boardDTO);
		
		return "board/detail";
	}
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String add(HttpSession session, Model model)throws Exception{
		
		if(session.getAttribute("user") == null) {
			model.addAttribute("result", "로그인 후 작성 가능");
			model.addAttribute("path", "./list");
		}else {
			return "/board/boardForm";
		}
		
		return "commons/result";
	}
		
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(NoticeDTO boardDTO, HttpSession session, MultipartFile [] attaches)throws Exception{
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		boardDTO.setUserName(userDTO.getUserName());
		int result = noticeService.add(boardDTO, session, attaches);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public String update(NoticeDTO boardDTO, Model model)throws Exception{
		boardDTO = (NoticeDTO)noticeService.getDetail(boardDTO, false);
		model.addAttribute("dto", boardDTO);
		
		return "board/boardForm";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(NoticeDTO boardDTO)throws Exception{
		int result =  noticeService.update(boardDTO);
		
		//return "redirect:./list";
		return "redirect:./detail?boardNum="+boardDTO.getBoardNum();
		
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(BoardDTO boardDTO, Model model)throws Exception{
		int result = noticeService.delete(boardDTO);
		String s = "삭제 실패";
		if(result>0) {
			s = "삭제 성공";
		}
		model.addAttribute("result", s);
		model.addAttribute("path", "./list");
		
		return "commons/result";
		
	}
}
