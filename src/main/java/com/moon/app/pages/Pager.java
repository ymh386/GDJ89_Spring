package com.moon.app.pages;

public class Pager {
	
	private Long startNum;
	private Long endNum;
	
	//검색종류
	private String kind;
	//검색어
	private String search;
	
	

	private Long page;
	private Long start;
	private Long end;
	private boolean endCheck;
	
	//한 페이지당 조회할 row의 갯수
	private Long perPage;
	
	//시작 번호, 끝번호를 계산하는 메서드
	public void makeNum() {
		startNum = (getPage()-1)*getPerPage()+1;
		endNum = getPage()*getPerPage();
	}
	
	public void make(Long totalCount) {
		//1. TotalPage
		Long totalPage = totalCount/10;
		if(totalCount%10 != 0) {
			totalPage++;
		}
		
		//2.TotalBlock
		Long totalBlock = totalPage/5;
		if(totalPage %5 !=0) {
			totalBlock++;
		}
		
		//3. page번호로 Block 번호 구하기
		Long curBlock = this.getPage()/5;
		
		if(this.getPage()%5 != 0) {
			curBlock++;
		}
		
		//4. Block번호로 시작 번호 끝번호 계산
		Long start = (curBlock-1)*5+1;
		Long end = curBlock*5;
		
		this.setStart(start);
		this.setEnd(end);
		
		//5. curBlock이 마지막 블럭 이라면
		if(totalBlock == curBlock) {
			this.setEnd(totalPage);
			this.setEndCheck(true);
			
		}
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getEndNum() {
		return endNum;
	}

	public void setEndNum(Long endNum) {
		this.endNum = endNum;
	}
	
	public String getKind() {
		if(this.kind == null) {
			this.kind="k1";
		}
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search == null) {
			this.search=""; //빈문자열
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getPage() {
		if (this.page==null || page<1) {
			this.page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public boolean isEndCheck() {
		return endCheck;
	}

	public void setEndCheck(boolean endCheck) {
		this.endCheck = endCheck;
	}

	public Long getPerPage() {
		if (this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

}
