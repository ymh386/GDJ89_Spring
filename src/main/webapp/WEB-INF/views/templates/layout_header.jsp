<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="container-fluid">
		<div class="row">
			<nav class="navbar navbar-expand-lg bg-dark border-bottom border-body bg-body-tertiary" data-bs-theme="dark">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="/">Bank</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="/">Home</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/products/list">Products</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/notice/list">공지사항</a>
			        </li>	
			        <li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
			            Dropdown
			          </a>
			          <ul class="dropdown-menu">
			            <li><a class="dropdown-item" href="#">Action</a></li>
			            <li><a class="dropdown-item" href="#">Another action</a></li>
			            <li><hr class="dropdown-divider"></li>
			            <li><a class="dropdown-item" href="#">Something else here</a></li>
			          </ul>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link disabled" aria-disabled="true">Disabled</a>
			        </li>
			        <c:if test="${empty user}">
				        <li class="nav-item">
				        	<a class="nav-link" href="/users/login">로그인</a>
				        </li>
				        <li class="nav-item">
				        	<a class="nav-link" href="/users/join">회원가입</a>
				        </li>
			        </c:if>
			        <c:if test="${not empty user}">
			        	 <li class="nav-item">
			        	<a class="nav-link" href="/users/logout	">로그아웃</a>
			        </li>
			        <li class="nav-item">
			        	<a class="nav-link" href="/users/mypage?userName=${user.userName}">내정보</a>
			        </li>
			        </c:if>
			      </ul>
			      <form class="d-flex" role="search">
			        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Search</button>
			      </form>
			    </div>
			  </div>
			</nav>
		</div>
	</header>