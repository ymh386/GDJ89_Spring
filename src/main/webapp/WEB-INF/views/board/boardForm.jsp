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
		<a href="./list" class="offset-md-11 btn-close"></a> 
		<h1>${kind} Form</h1>
		<form action="" method="post" enctype="multipart/form-data">
			<input type="hidden" name="boardNum" value="${dto.boardNum}">
		  <div class="mb-3">
		    <label for="inputBoardTitle" class="form-label">Title</label>
		    <input type="text" placeholder="제목 입력" name="boardTitle" value="${dto.boardTitle}" class="form-control" id="inputBoardTitle">
		  </div>
		  <div class="mb-3">
		    <label for="inputProductDetail" class="form-label">Contents</label>
		    <textarea rows="10" cols="" name="boardContent" class="form-control" id="inputProductDetail">${dto.boardContent}</textarea>
		  </div>

		  <div class="mb-3">
			<c:forEach items="${dto.boardFileDTOs}" var="f">
				<div class="alert alert-success" role="alert">
					${f.oldName}<button type="button" data-file-num="${f.fileNum}" data-kind="${kind}" class="badge text-bg-secondary file-delete">X</button>
				  </div>
			</c:forEach>
		  </div>

		  <div id="files" class="mb-3" data-files-size="${dto.boardFileDTOs.size()}">
			<button type="button" id="add_file" class="btn btn-info">파일 추가</button>
		  </div>
		  <div class="col-md-4">
			  <button type="submit" class="btn btn-success">확인</button>
			  <button type="reset" class="btn btn-danger">초기화</button>
		  </div>
		</form>
	</div>
</div>

<script type="module" src="/resources/js/files/fileManager.js"></script>
<!-- <script src="/resources/js/files/fileDelete.js"></script> -->
<c:import url="/WEB-INF/views/templates/layout_footer.jsp"></c:import>
<c:import url="/WEB-INF/views/templates/boot_js.jsp"></c:import>
</body>
</html>