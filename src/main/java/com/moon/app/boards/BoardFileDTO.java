package com.moon.app.boards;

import com.moon.app.files.FileDTO;

public class BoardFileDTO extends FileDTO{
	
	private Long fileNum;
	public Long getFileNum() {
		return fileNum;
	}
	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	private Long boardNum;

}
