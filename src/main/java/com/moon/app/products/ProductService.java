package com.moon.app.products;

import java.util.List;

import javax.print.attribute.standard.PageRanges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.app.pages.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	//list
	public List<ProductDTO> getList(Pager pager) throws Exception {
//		Pager pager = new Pager();
//		pager.setPage(page);
		
		Long totalCount = productDAO.count(pager);
		
		pager.make(totalCount);
		
		pager.makeNum();
		List<ProductDTO> ar = productDAO.getList(pager);
		
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
