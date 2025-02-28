package com.moon.app.boards.qna;

import com.moon.app.boards.BoardDTO;

public class QnaDTO extends BoardDTO {

	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
	
	public Long getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(Long boardRef) {
		this.boardRef = boardRef;
	}
	public Long getBoardStep() {
		return boardStep;
	}
	public void setBoardStep(Long boardStep) {
		this.boardStep = boardStep;
	}
	public Long getBoardDepth() {
		return boardDepth;
	}
	public void setBoardDepth(Long boardDepth) {
		this.boardDepth = boardDepth;
	}
	
}
