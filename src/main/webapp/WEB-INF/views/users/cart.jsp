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
		
		<form id="list_form" action="./carts"  class="row row-cols-lg-auto g-3 align-items-center">
			<input type="hidden" name="page" id="pageNum">   
		</form>

		
		<table class="table table-success table-striped">
		  <thead>
		    <tr>
			  <th>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="allCheck">
					<label class="form-check-label" for="allCheck">
					  전체 선택
					</label>
				  </div>
			  </th>
		      <th scope="col">상품번호</th>
		      <th scope="col">상품이름</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list}" var="v" varStatus="i">
			    <tr id="${v.productNum}">
				  <td>
					<div class="form-check">
						<input value="${v.productNum}" data-pn="pn${i.count}" class="form-check-input checks" type="checkbox" value="" >
						<label class="form-check-label" >
						</label>
					  </div>
				  </td>
			      <th scope="row">${v.productNum}</th>
			      <td id="pn${i.count}"><a href="../products/detail?productNum=${v.productNum}">${v.productName}</a></td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
		<div >
			<nav aria-label="Page navigation example" style="width: 300px; margin: 0px auto;">
	  			<ul class="pagination">
	  			  <li class="page-item">
	   			   <a class="page-link" href="./cart?page=${pager.start-1}" aria-label="Previous">
	   		     <span aria-hidden="true">&laquo;</span>
	   			   </a>
			    </li>
			    <c:forEach begin="${pager.start}" end="${pager.end}" var="i">
			    	<li class="page-item"><a class="page-link" href="./cart?page=${i}">${i}</a></li>
			    </c:forEach>
			    <li class="page-item ${pager.endCheck?'disabled':''}">
			      <a class="page-link" href="./cart?page=${pager.end+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>

			<div>
				<button id="account-add" class="btn btn-success">상품가입</button>
				<button id="cart-delete" class="btn btn-danger">삭제</button>
			</div>
	</div>
</div>


<script src="/resources/js/users/cart.js"></script>
<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>