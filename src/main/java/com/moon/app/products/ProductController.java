package com.moon.app.products;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList() throws Exception {
		System.out.println("Product List");
		productService.getList();
		return "products/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail() throws Exception {
		System.out.println("Product Detail");
		
		return "products/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		System.out.println("Product Add");
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add2(ProductDTO productDTO) throws Exception {
		/**
		 * 파라미터 처리 방법
		 * 1. 모든 요청 정보는 Request에 있다.(URL, METHOD, PARAMETER, COOKIE...)
		 * 	메서드의 매개변수로 HttpServletRequest request 선언
		 * 	request.getParameter("")
		 * 
		 * 2. 매개변수로 파라미터이름과 동일한 변수명, 동일한 타입명을 선언
		 * 
		 * 3. 매개변수로 Bean(DTO)를 선언
		 * 	파라미터의 이름과 타입이 DTO의 Setter의 이름과 동일
		 */
		
		System.out.println(productDTO.getProductName());
		System.out.println(productDTO.getProductRate());
		
		return "products/add";
	}
}
