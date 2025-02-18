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
		<h1>Product List Page</h1>
		<table class="table table-success table-striped">
		  <thead>
		    <tr>
		      <th scope="col">상품번호</th>
		      <th scope="col">상품이름</th>
		      <th scope="col">이자율</th>
		      <th scope="col">기간</th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		      <th scope="row">1</th>
		      <td>청년적금</td>
		      <td>10%</td>
		      <td>2년</td>
		    </tr>
		    <tr>
		      <th scope="row">2</th>
		      <td>군인적금</td>
		      <td>5%</td>
		      <td>전역시까지</td>
		    </tr>
		  </tbody>
		</table>
		<a href="./add" class="btn btn-success">상품 등록</a>
	</div>
</div>



<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>