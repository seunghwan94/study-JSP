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
    .hide {display: none;}
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

    <main class="container mb-5">
        <h1 class="text-center mt-4 fw-bold">Sign in</h1>
        <form name="form" method="post" class="mx-auto col-8 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-3 mt-4">
          <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id">
          <input type="password" class="form-control my-3" id="pw" placeholder="비밀번호" name="pw">

          <div class="form-check form-switch mb-4">
            <input class="form-check-input" type="checkbox" id="mySwitch" name="remember-id" value="yes">
            <label class="form-check-label" for="mySwitch">아이디 기억</label>
          </div>

          <button class="btn btn-secondary mt-1">로그인</button>
        </form>
    </main>

    <footer class="bg-secondary text-center p-4 mt-5">
      <address>서울 특별시 구로구 디지털로 306 대륭포스트 2차 2층 더조은 아카데미</address>
      <p>All rights reserved &copy; copyright.</p>
    </footer>
    
  </div>
</body>
</html>