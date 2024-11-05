<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
  <div class="wrap">
    <jsp:include page="../common/header.jsp"/>

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

    <jsp:include page="../common/footer.jsp"/>
    
    <script>
		if($.cookie("rememberId")){
			$("#id").val($.cookie("id"));
			$("#mySwitch").prop("checked",true);	
		}
    </script>
  </div>
</body>
</html>