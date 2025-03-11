package com.moon.app.boards.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.app.boards.BoardDAO;
import com.moon.app.boards.BoardDTO;
import com.moon.app.boards.BoardFileDTO;
import com.moon.app.pages.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.moon.app.boards.qna.QnaDAO.";

	@Override
	public Long count(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "count", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	@Override
	public int updateHit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "updateHit", boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}
	
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}
	
	public int fileDelete(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "fileDelete", boardFileDTO);
	}
	
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getFileDetail", boardFileDTO);
	}
	
	public int updateStep(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateStep", qnaDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "reply", qnaDTO);
	}
	
	

}
