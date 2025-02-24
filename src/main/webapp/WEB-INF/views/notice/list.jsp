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
		<h1>Notice</h1>
		<table class="table table-success table-striped">
		  <thead>
		    <tr>
		      <th scope="col">NO</th>
		      <th scope="col">TITLE</th>
		      <th scope="col">WRITER</th>
		      <th scope="col">DATE</th>
		      <th scope="col">HIT</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list}" var="v">
			    <tr>
			      <th scope="row">${v.boardNum}</th>
			      <td><a href="./detail?boardNum=${v.boardNum}">${v.boardTitle}</a></td>
			      <td>${v.userName}</td>
			      <td>${v.boardDate}</td>
			      <td>${v.boardHit}</td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
		<div class="col-md-4">
			<a href="./add" class="btn btn-success">글 작성</a>
		</div>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>