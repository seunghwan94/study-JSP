<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="image/png;"
    pageEncoding="UTF-8"%>
<%
//img파일로 전송할 예정
	FileInputStream fis = new FileInputStream("C:/Users/tj/Downloads/pngwing.png");
	byte[] bs = fis.readAllBytes();
	ServletOutputStream sos = response.getOutputStream();
	sos.write(bs);
%>