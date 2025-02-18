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
		<h1>Product Add</h1>
		<form action="./add" method="post">
		  <div class="mb-3">
		    <label for="inputProductName" class="form-label">상품명</label>
		    <input type="text" placeholder="상품명 입력" name="productName" class="form-control" id="inputProductName">
		  </div>
		  <div class="mb-3">
		    <label for="inputProductRate" class="form-label">이자율</label>
		    <input type="text" placeholder="x.xx" name="productRate" class="form-control" id="inputProductRate">
		  </div>
		  <div class="mb-3">
		    <label for="inputProductDate" class="form-label">만기일</label>
		    <input type="date" name="productDate" class="form-control" id="inputProductRate">
		  </div>
		  <div class="mb-3">
		    <label for="inputProductDetail" class="form-label">상품설명</label>
		    <textarea rows="10" cols="" name="productDetail" class="form-control" id="inputProductDetail"></textarea>
		  </div>
		  <button type="submit" class="btn btn-success">등록</button>
		</form>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>