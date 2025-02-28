package com.moon.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.app.boards.BoardDTO;
import com.moon.app.boards.BoardService;
import com.moon.app.pages.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;

	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.count(pager);
		
		pager.make(totalCount);
		
		pager.makeNum();
		
		return noticeDAO.getList(pager);
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check)throws Exception{
		if(check) {
			noticeDAO.updateHit(boardDTO);
		}
		return noticeDAO.getDetail(boardDTO);
	}
	
	public int add(BoardDTO boardDTO)throws Exception{
		return noticeDAO.add(boardDTO);
	}
	
	public int update(BoardDTO boardDTO)throws Exception{
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(BoardDTO boardDTO)throws Exception{
		return noticeDAO.delete(boardDTO);
	}
}
