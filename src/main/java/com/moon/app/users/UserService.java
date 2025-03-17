package com.moon.app.users;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.moon.app.files.FileManager;
import com.moon.app.pages.Pager;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public int cartDelete(Map<String, Object> map) throws Exception{
		return userDAO.cartDelete(map);
	}
	
	public List<CartDTO> cart(Pager pager, Object userDTO) throws Exception {
		
		pager.make(userDAO.getCartTotalCount(userDTO));
		
		pager.makeNum();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("user", userDTO);
		List<CartDTO> ar = userDAO.cart(map);
		return ar;
	}
	
	public int addCart(Map<String, Object> map) throws Exception {
		return userDAO.addCart(map);
	}
	
	public int join(UserDTO userDTO, MultipartFile profile, ServletContext context) throws Exception {
		int result = userDAO.join(userDTO);
		
		if(profile.isEmpty()) {
			return result;
		}
		
		UserFileDTO userFileDTO = this.save(context, profile, userDTO);
		result = userDAO.upload(userFileDTO);
		return result;
		
		
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		UserDTO result = userDAO.getDetail(userDTO);
		if(result != null) {
			if(result.getPassword().equals(userDTO.getPassword())) {
				return result;
			}
			
			throw new UserNameException("비밀번호가 틀렸다");
		}
		
		if(result == null) {
			throw new UserNameException("아이디가 틀렸다");
			
		}
		
		return null;
	}
	
	public UserDTO getDetail(UserDTO userDTO) throws Exception {
		userDTO = userDAO.getDetail(userDTO);
		
		return userDTO;
	}
	
	public int update(UserDTO userDTO, MultipartFile profile, HttpSession session) throws Exception {
		//dao user정보를 update
		int result = userDAO.update(userDTO);
		
		if(!profile.isEmpty()) {
			UserFileDTO userFileDTO = this.save(session.getServletContext(), profile, userDTO);
			//update 후에 결과값이 1이면 update
			int r = userDAO.updateFile(userFileDTO);
			if(r<1) {
				//update 후에 결과값이 0이면 insert
				result = userDAO.upload(userFileDTO);
			}
		}
		
		
		
		
		userDTO = userDAO.getDetail(userDTO);
		session.setAttribute("user", userDTO);
		
		
		
		return result;
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		int result = userDAO.delete(userDTO);
		
		return result;
	}
	
	private UserFileDTO save(ServletContext context, MultipartFile profile, UserDTO userDTO) throws Exception {
		//1. 어디에 저장 할 것인가??
		
		String path = context.getRealPath("/resources/images/profiles/");
		System.out.println(path);
		
		String f = FileManager.fileSave(path, profile);
		
		
		UserFileDTO userFileDTO = new UserFileDTO();
		userFileDTO.setUserName(userDTO.getUserName());
		userFileDTO.setFileName(f);
		userFileDTO.setOldName(profile.getOriginalFilename());
		
		return userFileDTO;
	}

}
