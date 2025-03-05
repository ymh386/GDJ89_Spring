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
		<h1>Cart Page</h1>

		
		<table class="table table-success table-striped">
		  <thead>
		    <tr>
		      <th scope="col">상품번호</th>
		      <th scope="col">상품이름</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list}" var="v">
			    <tr>
			      <th scope="row">${v.productNum}</th>
			      <td><a href="../products/detail?productNum=${v.productNum}">${v.productName}</a></td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>