package com.moon.app.products;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.app.SampleTestCase;

public class ProductDAOTest extends SampleTestCase{

	@Autowired
	private ProductDAO productDAO;
	
	@BeforeClass
	public static void bf() {
		System.out.println("전체 테스트 실행 전");
	}
	
	@AfterClass
	public static void af() {
		System.out.println("전체 테스트 종료 후");
	}
	
	@Before
	public void fe() {
		System.out.println("개별 테스트 실행 전");
	}
	
	@After
	public void ae() {
		System.out.println("개별 테스트 실행 후");
	}
	
	@Test
	public void getDetailTest() throws Exception {
		System.out.println("getDetail Test");
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(62L);
		
		productDTO = productDAO.getDetail(productDTO);
		
		assertNotNull(productDTO);
	}
	
	@Test
	public void getListTest() throws Exception {
		System.out.println("getList Test");
		List<ProductDTO> ar = productDAO.getList();
		
		assertNotEquals(0, ar.size());
	}
	

}
