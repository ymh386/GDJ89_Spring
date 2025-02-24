package com.moon.app.products;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	//list
	public List<ProductDTO> getList() throws Exception {
//		Pager pager = new Pager();
//		pager.setPage(page);
		
//		//1. TotalPage
//		Long totalCount = productDAO.getTotalCount();
//		Long totalPage = totalCount/10;
//		if(totalCount%10 != 0) {
//			totalPage++;
//		}
//		pager.setTotalPage(totalPage);
//		
//		//2.TotalBlock
//		Long totalBlock = totalPage/5;
//		if(totalPage %5 !=0) {
//			totalBlock++;
//		}
//		
//		//3. page번호로 Block 번호 구하기
//		Long curBlock = pager.getPage()/5;
//		
//		if(pager.getPage()%5 != 0) {
//			curBlock++;
//		}
//		
//		//4. Block번호로 시작 번호 끝번호 계산
//		Long start = (curBlock-1)*5+1;
//		Long end = curBlock*5;
//		
//		pager.setStart(start);
//		pager.setEnd(end);
		
		//5. curBlock이 마지막 블럭 이라면
		if(totalBlock == curBlock) {
			
		}
//		
//		pager.makeNum();
		List<ProductDTO> ar = productDAO.getList();
		
		return ar;
	}
	
	//detail
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		productDTO = productDAO.getDetail(productDTO);
		
		return productDTO;
	}
	
	//add
	public int add(ProductDTO productDTO) throws Exception {
		//dao 호출
		int result = productDAO.add(productDTO);
		
		return result;
	}
	
	//update
	public int update(ProductDTO productDTO) throws Exception {
		int result = productDAO.update(productDTO);
		
		return result;
	}
	
	//delete
	public int delete(ProductDTO productDTO) throws Exception {
		int result = productDAO.delete(productDTO);
		
		return result;
	}

}
