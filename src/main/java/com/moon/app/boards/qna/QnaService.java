package com.moon.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.app.boards.BoardDTO;
import com.moon.app.boards.BoardService;
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
	
	public int add(BoardDTO boardDTO)throws Exception{
		return qnaDAO.add(boardDTO);
	}
	
	public int update(BoardDTO boardDTO)throws Exception{
		return qnaDAO.update(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO)throws Exception{
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO)throws Exception {
		//boardDTO 답글 : 이름, 제목, 내용, 부모글 : 글번호
		
		
		//step update
		int result = qnaDAO.updateStep(qnaDTO);
		
		result = qnaDAO.reply(qnaDTO);
		
		return result;
	}

}
