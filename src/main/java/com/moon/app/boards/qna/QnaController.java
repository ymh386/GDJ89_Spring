package com.moon.app.boards.qna;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.moon.app.boards.BoardDTO;
import com.moon.app.boards.BoardFileDTO;
import com.moon.app.pages.Pager;
import com.moon.app.users.UserDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//해당 메소드의 리턴값을 value로 하고 annotation( )안에 값을 키로 하는값을 모델에 담음
	@ModelAttribute("kind")
	public String getKind() {
		return "qna";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		
		List<BoardDTO> ar = qnaService.getList(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
		
		return "board/list";
		
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(QnaDTO qnaDTO, HttpSession session, Model model) throws Exception {
		
		Object obj = session.getAttribute("board");
		boolean check=false;
		if(obj != null) {
			HashSet<Long> ar = (HashSet<Long>)obj;
			if(!ar.contains(qnaDTO.getBoardNum())) {
				ar.add(qnaDTO.getBoardNum());
				check=true;
			}else {
				
				check=false;
			}
		}else {
			HashSet<Long> num = new HashSet<Long>();
			num.add(qnaDTO.getBoardNum());
			session.setAttribute("board", num);
			check=true;
		}
		
		qnaDTO= (QnaDTO)qnaService.getDetail(qnaDTO, check);
		model.addAttribute("dto", qnaDTO);
		
		return "board/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(HttpSession session, Model model) throws Exception {
		
		if(session.getAttribute("user") == null) {
			model.addAttribute("result", "로그인 후 작성 가능");
			model.addAttribute("path", "./list");
		}else {
			return "/board/boardForm";
		}
		
		return "commons/result";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(QnaDTO qnaDTO, HttpSession session, MultipartFile [] attaches) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		qnaDTO.setUserName(userDTO.getUserName());
		int result = qnaService.add(qnaDTO, session, attaches);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = (QnaDTO)qnaService.getDetail(qnaDTO, false);
		
		model.addAttribute("dto", qnaDTO);
		
		return "board/boardForm";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(QnaDTO qnaDTO, MultipartFile [] attaches, HttpSession session) throws Exception {
		int result = qnaService.update(qnaDTO, attaches, session);
		
		return "redirect:./detail?boardNum=" + qnaDTO.getBoardNum();
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(QnaDTO qnaDTO, HttpSession session, Model model) throws Exception {
		int result = qnaService.delete(qnaDTO, session);
		String s = "삭제 실패";
		if(result>0) {
			s = "삭제 성공";
		}
		model.addAttribute("result", s);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(@ModelAttribute("dto") QnaDTO qnaDTO, HttpSession session, Model model) throws Exception {
		if(session.getAttribute("user") == null) {
			model.addAttribute("result", "로그인 후 작성 가능");
			model.addAttribute("path", "./list");
		}else {
			return "/board/boardForm";
		}
		
		return "commons/result";
		
		
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		qnaDTO.setUserName(userDTO.getUserName());
		
		int result = qnaService.reply(qnaDTO);
		
		return "redirect:./list";
		
		
	}
	
	@RequestMapping(value="fileDelete", method=RequestMethod.POST)
	public String fileDelete(BoardFileDTO boardFileDTO, HttpSession session, Model model) throws Exception {
		int result = qnaService.fileDelete(boardFileDTO, session);
		model.addAttribute("result", result);
		return "commons/ajaxResult";
	}
	
	@RequestMapping(value="fileDown", method=RequestMethod.GET)
	public String fileDown(BoardFileDTO boardFileDTO, Model model) throws Exception {
		boardFileDTO = qnaService.getFileDetail(boardFileDTO);
		model.addAttribute("file", boardFileDTO);
		return "fileDownView";
		
	}
	
	
	

}
