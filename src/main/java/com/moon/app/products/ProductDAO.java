package com.moon.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moon.app.utils.DBConnection;

//annotation(설명, 실행)
@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.moon.app.products.ProductDAO.";
	
	//list
	public List<ProductDTO> getList() throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getList");
		
		
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

}
