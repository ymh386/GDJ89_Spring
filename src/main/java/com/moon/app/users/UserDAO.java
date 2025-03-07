package com.moon.app.users;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.moon.app.users.UserDAO.";
	
	public int cartDelete(Map<String, Object> map) throws Exception {
		return sqlSession.delete(NAMESPACE + "cartDelete", map);
	}
	
	public List<CartDTO> cart(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE + "cart", map);
	}
	
	public Long getCartTotalCount(Object userDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getCartTotalCount", userDTO);
	}
	
	public int addCart(Map<String, Object> map) throws Exception {
		return sqlSession.insert(NAMESPACE + "addCart", map);
	}
	
	public int join(UserDTO userDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "join", userDTO);
	}
	
	//user 한명의 정보를 조회, (userName)
	public UserDTO getDetail(UserDTO userDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", userDTO);
	}
	
	public UserDTO login(UserDTO userDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "login", userDTO);
	}
	
	public int update(UserDTO userDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", userDTO);
	}
	
	public int delete(UserDTO userDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", userDTO);
	}
	
	public int upload(UserFileDTO userFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "upload", userFileDTO);
	}
	
	public int updateFile(UserFileDTO userFileDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateFile", userFileDTO);
	}

}
