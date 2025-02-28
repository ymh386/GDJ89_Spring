package com.moon.app.boards;

import java.util.List;

import com.moon.app.pages.Pager;

public interface BoardDAO {
	//상수, 추상메서드
	
	//count
	public abstract Long count(Pager pager) throws Exception;
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//detail
	BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	//hitupdate
	public int updateHit(BoardDTO boardDTO) throws Exception;
	
	//add
	public int add(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
}
