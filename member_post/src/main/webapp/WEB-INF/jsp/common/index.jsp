<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.bundle.min.js" integrity="sha512-sH8JPhKJUeA9PWk3eOcOl8U+lfZTgtBXD41q6cO/slwxGHCxKcW45K4oPCUhHG7NMB4mbKEddVmPuTXtpbCbFA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.17/jquery.bxslider.min.js" integrity="sha512-LaBO0tZh1+6Ebk+EnHt/WsGM0UnmkCXfQ1rfhGmpa5MXUdslNuSSELBRcteHKz4k4ny+Op10Ax2fPoTNq+VcUg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <title>Mago UI Practice</title>
  
  <link rel="icon" href="./images/favicon.ico" type="image/x-icon">
  <style>
    .logo-img {width: 240px; height: 80px;}
  </style>
</head>
<body>
  <div class="wrap">
    <header class="container-fluid bg-secondary pb-3">
      <div class="container clearfix p-2">
        <!-- <a href="index.html" class="float-start"><img src="https://placehold.co/240x80?text=Mago" alt="Logo"></a> -->
        <a href="index.html" class="float-start"><img class="logo-img" src="https://i.namu.wiki/i/gq8rUiVxHzCh5G-6Ca7Y8jf_TrVX4N7Wd0-Zv9q0FHitA3u3prbxWGXFjFCw5lkHzKGaHDP0GCuTIp25p9TsvQ.webp" alt="Logo"></a>
        <h1 class="float-end fw-bold p-3 text-center">Mago UI Practice</h1>
      </div>
    </header>
      <nav class="navbar navbar-expand-sm bg-dark">
        <ul class="navbar-nav container justify-content-start">
          <li class="nav-item"><a class="nav-link text-white mx-3" href="index.html">Home</a></li>
          <li class="nav-item"><a class="nav-link text-white mx-3" href="mypage.html">MyPage</a></li>
          <li class="nav-item"><a class="nav-link text-white mx-3" href="post.html?category=1">공지사항</a></li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle text-white mx-3" data-bs-toggle="dropdown" role="button">게시판</a>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="post.html?category=2">자유게시판</a>
              <a class="dropdown-item" href="post.html?category=3">자료실</a>
              <a class="dropdown-item" href="gallery.html">갤러리</a>
            </div>
          </li>
        </ul>
      </nav>
    <main class="container">
      <div class="row">
        <div class="col-md-9">
          <div class="p-3">
            <h1>index</h1>
          </div>
        </div>
        <div class="col-md-3">
          <div class="p-3 d-grid gap-2">
          <% 
          	Object o = session.getAttribute("member");
          	if(o!= null){
          %>
            <p><a href="mypage.html" class="text-decoration-none text-dark"><strong>홍길동</strong>님 환영합니다.</a></p>
            <div class="small clearfix">
              <a href="logout.html" class="small float-start text-decoration-none">로그아웃</a>
              <a href="mypage.html" class="small float-end text-decoration-none">마이페이지</a>
            </div>
            
          <%
          	} else {
          		Member m = (Member) o;
          %>
			<a href="signin" class="btn btn-secondary btn-block">로그인</a>
            <div class="small clearfix">
              <a href="signup" class="small float-start text-decoration-none">회원가입</a>
              <a href="signup" class="small float-end text-decoration-none">아이디/비밀번호 찾기</a>
            </div>
          <%
          	
          	} 
          %> 
          </div>
        </div>
      </div>


    </main>
    <footer class="bg-secondary text-center p-4">
      <address>서울 특별시 구로구 디지털로 306 대륭포스트 2차 2층 더조은 아카데미</address>
      <p>All rights reserved &copy; copyright.</p>
    </footer>
  </div>
</body>
</html>