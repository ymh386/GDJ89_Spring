<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/boot_css.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/templates/layout_header.jsp"></c:import>

<div class="container-fluid my-5">
	<div class="row col-md-8 offset-md-2">
		<!--  contents 내용 작성 -->
		<a href="./detail?productNum=${dto.productNum}" class="offset-md-11 btn-close"></a> 
		<h1>Product Update</h1>
		<form action="./update" method="post">
		  <div class="mb-3">
		    <label for="inputProductName" class="form-label">상품번호</label>
		    <input type="text" name="productNum" value="${dto.productNum}" class="form-control" id="inputProductName" readonly>
		  </div>
		  <div class="mb-3">
		    <label for="inputProductName" class="form-label">상품명</label>
		    <input type="text" placeholder="상품명 입력" name="productName" value="${dto.productName}" class="form-control" id="inputProductName">
		  </div>
		  <div class="mb-3">
		    <label for="inputProductRate" class="form-label">이자율</label>
		    <input type="text" placeholder="x.xx" name="productRate" value="${dto.productRate}" class="form-control" id="inputProductRate">
		  </div>
		  <div class="mb-3">
		    <label for="inputProductDate" class="form-label">만기일</label>
		    <input type="date" name="productDate" class="form-control" value="${dto.productDate}" id="inputProductRate">
		  </div>
		  <div class="mb-3">
		    <label for="inputProductDetail" class="form-label">상품설명</label>
		    <textarea rows="10" cols="" name="productDetail" class="form-control" value="${dto.productDetail}" id="inputProductDetail"></textarea>
		  </div>
		  <div class="col-md-4">
			  <button type="submit" class="btn btn-success">수정</button>
			  <button type="reset" class="btn btn-danger">초기화</button>
		  </div>
		</form>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>