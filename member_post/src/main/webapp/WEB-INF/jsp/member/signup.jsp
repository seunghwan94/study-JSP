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
        <form class="mx-auto col-8 col-sm-8 col-md-6 col-lg-5 col-xl-4 col-xxl-3 card p-3 mt-4">
          <input type="text" class="form-control my-3" id="id" placeholder="아이디" name="id">
          <input type="password" class="form-control my-3" id="pwd" placeholder="비밀번호" name="pwd">
          <input type="text" class="form-control my-3" id="name" placeholder="이름">
          <input type="email" class="form-control my-3" id="email" placeholder="이메일">
          
          <input type="text" class="form-control my-3" id="roadAddr" placeholder="도로명" name="roadAddr" readonly>
          <input type="text" class="form-control my-3" id="addr" placeholder="상세주소" name="addr">
          
          <div class="input-group my-3">
            <input type="text" class="form-control" placeholder="도로명검색">
            <button class="btn btn-secondary" type="button" id="search">Search</button>
          </div>
          <ul class="list-group search-result-list hide"></ul>
          <button class="btn btn-secondary mt-1">가입하기</button>
        </form>
    </main>

    <footer class="bg-secondary text-center p-4">
      <address>서울 특별시 구로구 디지털로 306 대륭포스트 2차 2층 더조은 아카데미</address>
      <p>All rights reserved &copy; copyright.</p>
    </footer>
    <script>
      $(function(){
  
  
  
  
  
        $("#search").click(function(){
          
          const keyword = $(this).prev().val();
          if(!keyword) return;
          const data = {
            keyword,
            confmKey : "devU01TX0FVVEgyMDI0MTAyOTE2MTY1MDExNTIwMTA=",
            currentPage : 1,
            countPerPage : 10,
            resultType : "json"
          }
          console.log(data);
  
          $.ajax({
            url :"https://business.juso.go.kr/addrlink/addrLinkApiJsonp.do",
            type : "post",
            data,
            dataType:"jsonp",
            crossDomain: true,
            success:function(data){
              console.log(data);
              let str = "";
              for(let i=0; i < data['results']['juso'].length; i++){
                str += `<li class="list-group-item"><a href="#" class="small">\${data['results']['juso'][i]['roadAddr']}</a></li>`;
  
              }
              
              $(".search-result-list").removeClass("hide").append(str);
              
            },
            error: function(err, msg){
              console.log(msg);
            }
          })
          $(".search-result-list").on("click","a",function(){
            $("#roadAddr").val($(this).text());
            $(this).closest("ul").empty().addClass("hide");
          })
        })
  
      })
    </script>
  </div>
</body>
</html>