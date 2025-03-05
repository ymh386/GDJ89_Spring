package com.moon.app.boards.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moon.app.boards.BoardDTO;
import com.moon.app.boards.BoardFileDTO;
import com.moon.app.boards.BoardService;
import com.moon.app.files.FileManager;
import com.moon.app.pages.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.count(pager);
		
		pager.make(totalCount);
		
		pager.makeNum();
		
		return qnaDAO.getList(pager);
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check)throws Exception{
		if(check) {
			qnaDAO.updateHit(boardDTO);
		}
		return qnaDAO.getDetail(boardDTO);
	}
	
	public int add(BoardDTO boardDTO, HttpSession session, MultipartFile [] attaches)throws Exception{
		int result = qnaDAO.add(boardDTO);
		for(MultipartFile attach: attaches) {
			if(attach.isEmpty()) {
				continue;
			}
			BoardFileDTO boardFileDTO = this.fileSave(attach, session.getServletContext());
			
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = qnaDAO.addFile(boardFileDTO);
		}
		return result;
	}
	
	public int update(BoardDTO boardDTO)throws Exception{
		return qnaDAO.update(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO)throws Exception{
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO)throws Exception {
		//boardDTO 답글 : 이름, 제목, 내용, 부모글 : 글번호
		QnaDTO parent = (QnaDTO)qnaDAO.getDetail(qnaDTO);
		
		//ref 부모의 ref
		qnaDTO.setBoardRef(parent.getBoardRef());
		//step 부모의 step+1
		qnaDTO.setBoardStep(parent.getBoardStep()+1);
		//depth 부모의 depth+1
		qnaDTO.setBoardDepth(parent.getBoardDepth()+1);
		
		//step update
		int result = qnaDAO.updateStep(parent);
		
		result = qnaDAO.reply(qnaDTO);
		
		return result;
	}
	
	private BoardFileDTO fileSave(MultipartFile attach, ServletContext servletContext)throws Exception{
		//1. 어디에 저장할 것인가??
		String path = servletContext.getRealPath("/resources/images/qna/");
		
		System.out.println(path);
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. HDD에 파일을 저장하고 저장된 파일명을 리턴
		String fileName=FileManager.fileSave(path, attach);
		
		//3. 파일의 정보를 DTO에 담아서 리턴
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOldName(attach.getOriginalFilename());
		
		return boardFileDTO;
	}

}
