package com.moon.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public int join(UserDTO userDTO) throws Exception {
		int result = userDAO.join(userDTO);
		
		return result;
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		UserDTO result = userDAO.getDetail(userDTO);
		if(result != null) {
			if(result.getPassword().equals(userDTO.getPassword())) {
				return result;
			}
		}
		return null;
	}
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception {
		userDTO = userDAO.getDetail(userDTO);
		
		return userDTO;
	}
	
	public int update(UserDTO userDTO) throws Exception {
		int result = userDAO.update(userDTO);
		
		return result;
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		int result = userDAO.delete(userDTO);
		
		return result;
	}

}
