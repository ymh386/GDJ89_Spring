package com.moon.app.files;

public class FileDTO {
	
	private String fileName;
	
	public String getFileName() {
//		if(fileName == null) {
//			this.fileName="default.jsp";
//		}
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	private String oldName;

}
