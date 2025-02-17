package com.moon.app.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList() throws Exception {
		System.out.println("Product List");
		
		return "products/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail() throws Exception {
		System.out.println("Product Detail");
		
		return "products.detail";
	}
}
