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
		<a href="./mypage?userName=${dto.userName}" class="offset-md-11 btn-close"></a> 
		<h1>User Update</h1>
		<form action="./update" method="post" enctype="multipart/form-data">
		  <div class="mb-3">
		    <label for="inputName" class="form-label">Name</label>
		    <input type="text" name="name" value="${dto.name}" class="form-control" id="inputName">
		  </div>
		  <div class="mb-3">
		    <label for="inputPhone" class="form-label">Phone</label>
		    <input type="text" name="phone" value="${dto.phone}" class="form-control" id="inputPhone">
		  </div>
		  <div class="mb-3">
		    <label for="inputEmail" class="form-label">Email</label>
		    <input type="email" name="email" value="${dto.email}" class="form-control" id="inputEmail">
		  </div>
		  <div class="mb-3">
		    <label for="profile" class="form-label">Profile</label>
		    <input type="file" name="profile" class="form-control" id="profile">
		  </div>
		  <div>
		  	${user.userFileDTO.oldName} <span class="btn text-danger">X</span>
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