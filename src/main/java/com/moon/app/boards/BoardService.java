package com.moon.app.boards;

import java.util.List;

import com.moon.app.pages.Pager;

public interface BoardService {
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO, boolean check) throws Exception;
	
	//insert
	public int add(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;

}
