package com.moon.app.products;

import java.util.List;

import org.springframework.stereotype.Repository;

//annotation(설명, 실행)
@Repository

public class ProductDAO {
	
	//list
	public List<ProductDTO> getList() throws Exception {
		System.out.println("DAO LIST");
		
		
		return null;
	}

}
