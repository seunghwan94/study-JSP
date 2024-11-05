<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <jsp:include page="head.jsp"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <style>
    .popup { position: absolute; top: 200px; left: calc(50% - 210px); display: none}
    popup > img {display: block;}
    .backgrounddiv {background-color: skyblue; padding:5px;}
    .left { margin:0; float: left; }
    .backgrounddiv > a {float: right; text-decoration: none; color: #eee;}  
  </style>
</head>
<body>
  <div class="wrap">
    <jsp:include page="header.jsp"/>
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
              <a href="logout" class="small float-start text-decoration-none">로그아웃</a>
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

		<div class="popup">
		    <img src="https://image.yes24.com/momo/scmfiles/AdvertFiles/202410/2578206_241014101146.jpg">
		    <div class="backgrounddiv clearfix">
		      <p class="left">오늘 하루 그만 보기 <input type="checkbox"></p>
		      <a href="#">닫기</a>
		    </div>
		</div>
		
		
		
    </main>
	<jsp:include page="footer.jsp"/>
	<script>
		
		/* 쿠키가 없을때 할일 */
		if(!$.cookie("layer"))
			$(".popup").show();
	
		/* 레이어 팝업 내의 닫기 버튼 클릭시 이벤트 */
		$(".popup a").click(function(){
			const checked = $(this).prev().find("input:checkbox").prop("checked");
			console.log(checked);
			if(checked)
				$.cookie('layer','yes', {expires: 1});
			$(".popup").hide();
		})
	</script>
  </div>
</body>
</html>