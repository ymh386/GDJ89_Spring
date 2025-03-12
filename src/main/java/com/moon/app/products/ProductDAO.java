package com.moon.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.app.pages.Pager;
import com.moon.app.utils.DBConnection;

//annotation(설명, 실행)
@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.moon.app.products.ProductDAO.";

	//list
	public List<ProductDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getList", pager);
		
	}
	
	//count
	public Long count(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count", pager);
	}
	
	//detail
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		//statement => mapper의 id값
		return sqlSession.selectOne(NAMESPACE + "getDetail", productDTO);
		
		
		
	}
	
	//add
	public int add(ProductDTO productDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "add", productDTO);
	}
	
	//update
	public int update(ProductDTO productDTO) throws Exception {
	
		return sqlSession.update(NAMESPACE + "update", productDTO);
	}
	
	//delete
	public int delete(ProductDTO productDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE + "delete", productDTO);
	}
	
	public Long test() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "test");
	}
	
	public Map<String, Object> test2() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "test2");
	}
	
	//------------------------Comments------------------------------
	public int addComments(CommentsDTO commentsDTO)throws Exception {
		return sqlSession.insert(NAMESPACE + "addComments", commentsDTO);
	}
	
	public List<CommentsDTO> getCommentList(Map<String, Object> map) throws Exception{
		return sqlSession.selectList(NAMESPACE + "getCommentList", map);
	}
	
	public Long getCommentsTotalCount(CommentsDTO commentsDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentsTotalCount", commentsDTO);
	}
	
	public int deleteComments(CommentsDTO commentsDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "deleteComments", commentsDTO);
	}
	
	public int updateComments(CommentsDTO commentsDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "updateComments", commentsDTO);
	}

}
