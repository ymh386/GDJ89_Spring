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
		<h1>Product Detail Page</h1>
		<form>
		  <div class="mb-3">
		    <label class="form-label">상품번호</label>
		    <input type="text" class="form-control" value="${dto.productNum}" readonly>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">상품이름</label>
		    <input type="text" class="form-control" value="${dto.productName}" readonly>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">이자율</label>
		    <input type="text" class="form-control" value="${dto.productRate}" readonly>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">만기일</label>
		    <input type="date" class="form-control" value="${dto.productDate}" readonly>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">상품설명</label>
		    <textarea rows="10" cols="" class="form-control" readonly>${dto.productDetail}</textarea>
		  </div>
		</form>
		<div class="col-md-12">
			<a href="./update?productNum=${dto.productNum}" class="col-md-1 btn btn-success">수정</a>
			<a href="./delete?productNum=${dto.productNum}" class="col-md-1 btn btn-danger">삭제</a>
			<a href="./list" class="col-md-1 offset-md-8 btn btn-success">리스트</a>
		</div>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>