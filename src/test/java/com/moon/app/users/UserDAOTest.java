package com.moon.app.users;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.moon.app.SampleTestCase;

public class UserDAOTest extends SampleTestCase {

	@Autowired
	private UserDAO userDAO;
	
	@Test(expected = Exception.class) //예외가 터지길 기대
	public void joinTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("id");
		userDTO.setPassword("pw");
		userDTO.setName("name");
		userDTO.setPhone("1234");
		userDTO.setEmail("email@email");
		
		int result = userDAO.join(userDTO);
//		int result = 0;
		//단정문 assert
		assertNotEquals(1, result);
	}
	
	@Test
	public void getDetailTest() throws Exception {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("admin");
		userDTO = userDAO.getDetail(userDTO);
		
		assertNotNull(userDTO);
	}

}
