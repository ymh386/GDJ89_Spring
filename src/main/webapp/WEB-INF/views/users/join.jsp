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
		<a href="../index" class="offset-md-11 btn-close"></a> 
		<h1>User Join</h1>
		<form action="./join" method="post">
		  <div class="mb-3">
		    <label for="inputUserName" class="form-label">Username</label>
		    <input type="text" placeholder="아이디 입력" name="userName" class="form-control" id="inputUserName">
		  </div>
		  <div class="mb-3">
		    <label for="inputPassword" class="form-label">Password</label>
		    <input type="password" placeholder="비밀번호 입력" name="password" class="form-control" id="inputPassword">
		  </div>
		  <div class="mb-3">
		    <label for="inputName" class="form-label">Name</label>
		    <input type="text" name="name" class="form-control" id="inputName">
		  </div>
		  <div class="mb-3">
		    <label for="inputPhone" class="form-label">Phone</label>
		    <input type="text" name="phone" class="form-control" id="inputPhone">
		  </div>
		  <div class="mb-3">
		    <label for="inputEmail" class="form-label">Email</label>
		    <input type="email" name="email" class="form-control" id="inputEmail">
		  </div>
		  <div class="col-md-4">
			  <button type="submit" class="btn btn-success">가입</button>
			  <button type="reset" class="btn btn-danger">초기화</button>
		  </div>
		</form>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>