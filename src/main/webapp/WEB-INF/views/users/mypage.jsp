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
		<h1>MyPage</h1>
		<form>
		  <div class="mb-3">
		    <label class="form-label">아이디</label>
		    <input type="text" class="form-control" value="${dto.userName}" readonly>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">이름</label>
		    <input type="text" class="form-control" value="${dto.name}" readonly>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">전화번호</label>
		    <input type="text" class="form-control" value="${dto.phone}" readonly>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">이메일</label>
		    <input type="email" class="form-control" value="${dto.email}" readonly>
		  </div>
		</form>
		<div class="alert alert-success" role="alert">
			<img alt="" src="/resources/images/profiles/${not empty dto.userFileDTO.fileName ? dto.userFileDTO.fileName:'default.png'}">
		</div>
		<div class="col-md-8">
			<a href="/accounts/list" class="btn btn-success">계좌정보</a>
			<a href="/users/cart?userName=${dto.userName}">장바구니</a>
		</div>
		<div class="col-md-4">
			<a href="/users/update?userName=${dto.userName}" class="offset-md-4 btn btn-success">정보수정</a>
			<a href="/users/delete?userName=${dto.userName}" class="btn btn-danger">회원탈퇴</a>
		</div>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>