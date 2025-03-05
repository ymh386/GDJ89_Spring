package com.moon.app.products;

import java.sql.Date;
import java.util.List;

import com.moon.app.users.CartDTO;

public class ProductDTO {
	
	//모든 멤버변수의 접근지정자는 private
	//변수명, 타입은 DB의 컬럼과 동일
	//Setter, Getter
	//생성자는 최소 기본생성자가 있어야 함
	//이제부터 long은 null을 못담기 때문에 Reference타입인 Long으로 대체(int -> Integer, double->Double 등)
	private Long productNum;
	private String productName;
	private Double productRate;
	private Date productDate;
	private String productDetail;
	private List<CartDTO> cartDTOs;
	
	

	public List<CartDTO> getCartDTOs() {
		return cartDTOs;
	}

	public void setCartDTOs(List<CartDTO> cartDTOs) {
		this.cartDTOs = cartDTOs;
	}

	public Long getProductNum() {
		return productNum;
	}
	
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductRate() {
		return productRate;
	}
	public void setProductRate(Double productRate) {
		this.productRate = productRate;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

}
