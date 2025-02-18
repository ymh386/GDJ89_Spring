package com.moon.app.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	//list
	public void getList() throws Exception {
		productDAO.getList();
		System.out.println("Service List");
	}

}
