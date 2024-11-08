<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="../common/head.jsp"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <style>
    .logo-img {width: 240px; height: 80px;}
    .hide {display: none;}
  </style>
</head>
<body class="bg-dark">
  <div class="wrap">
    <jsp:include page="../common/header.jsp"/>
    <main class="container mb-5">
  	  <div class= "my-4 clearfix">
		<h2 class="text-white float-start">상세보기</h2>
	  </div>
      <div class="my-3 col-md-9">
        <label for="title" class="form-label text-white mt-3">
          <i class="fa-solid fa-heading" style="color: #48587f;"></i>
          <b>Title</b>
        </label>
        <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${post.title}" disabled>

        <label for="content" class="form-label text-white mt-3">
          <i class="fa-solid fa-pen-fancy"  style="color: #48587f;"></i>
          <b>Content</b>
        </label>
        <textarea class="form-control" rows="20" id="content" name="content" disabled>${post.content}</textarea>

        
        <label for="create-date" class="form-label text-white mt-3 me-4">
          <i class="fa-regular fa-calendar-days"  style="color: #48587f;"></i>
          <b class="text-white">Create Date ${post.createDate}</b>
        </label>
        <label for="create-date" class="form-label text-white mt-3 me-4">
          <i class="fa-regular fa-calendar-days"  style="color: #48587f;"></i>
          <b class="text-white">Update Date ${post.updateDate}</b>
        </label>

        <span class="text-white fw-bold">
          <i class="fa-solid fa-eye" style="color: #48587f;"></i>
          ${post.viewCount}
        </span>

        <label for="writer" class="form-label text-white mt-3">
          <i class="fa-solid fa-user-pen"  style="color: #48587f;"></i>
          <b>Writer</b>
        </label>
        <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${post.writer}" disabled>

        <div class="text-center my-5">
        	<c:if test="${post.writer == member.id}">
	        	<a href="modify?pno=${post.pno}" class="btn btn-secondary">수정</a>
	        	<a href="remove?pno=${post.pno}" class="btn btn-outline-secondary" onclick="return confirm('삭제하시겠습니까?');">삭제</a>
        	</c:if>
          	<a href="list" class="btn btn-secondary">목록</a>
        </div>

      </div>
    </main>
    <jsp:include page="../common/footer.jsp"/>
  </div>
</body>
</html>