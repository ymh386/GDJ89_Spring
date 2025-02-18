package com.moon.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.moon.app.utils.DBConnection;

//annotation(설명, 실행)
@Repository
public class ProductDAO {
	
	//list
	public List<ProductDTO> getList() throws Exception {
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS ORDER BY PRODUCTNUM ASC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductRate(rs.getDouble("PRODUCTRATE"));
			productDTO.setProductDate(rs.getDate("PRODUCTDATE"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
			
			ar.add(productDTO);
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return ar;
	}
	
	//detail
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductRate(rs.getDouble("PRODUCTRATE"));
			productDTO.setProductDate(rs.getDate("PRODUCTDATE"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
		}
		
		DBConnection.disConnect(rs, st, con);
		
		return productDTO;
	}
	
	//add
	public int add(ProductDTO productDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS VALUES (PRODUCTS_SEQ.NEXTVAL, ? ,? ,? ,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, productDTO.getProductName());
		st.setDouble(2, productDTO.getProductRate());
		st.setDate(3, productDTO.getProductDate());
		st.setString(4, productDTO.getProductDetail());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnect(st, con);
		
		return result;
	}

}
