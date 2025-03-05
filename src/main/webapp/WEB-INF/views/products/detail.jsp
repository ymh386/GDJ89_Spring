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
		<c:if test="${not empty dto}">
			<div>
				<form id="frm" action="/test">
					<input type="hidden" name="productNum" value="${dto.productNum}">
					<button type="button" id="up">수정</button>
					<button type="button" id="del">삭제</button>
				</form>
			<button type="button" id="addCart" data-user-name="${user.userName}" data-product-num="${dto.productNum}">장바구니</button>
			</div>
			<form>
			  <div class="mb-3">
			    <label class="form-label">상품번호</label>
			    <input id="productNum" type="text" class="form-control" value="${dto.productNum}" readonly>
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
				<c:if test="${not empty user and user.userName == 'admin'}">
					<a href="./update?productNum=${dto.productNum}" class="col-md-1 btn btn-success">수정</a>
					<a href="./delete?productNum=${dto.productNum}" class="col-md-1 btn btn-danger">삭제</a>
				</c:if>
				<a href="./list" class="col-md-1 offset-md-8 btn btn-success">리스트</a>
			</div>
		</c:if>
		<c:if test="${empty dto}">
			<h3>삭제되었거나 등록되지않은 상품입니다.</h3>
		</c:if>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
<script src="/resources/js/detail.js"></script>
</body>
</html>