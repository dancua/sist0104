<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");

MemberDao dao = new MemberDao();

%>
<body>
<h2><%=name%>님의 회원가입을 축하드립니다!</h2>
<img alt="" src="../image2/logoImg/a.png">

<button type="button" class="btn btn-outline-info"
style="width:100px;" onclick="location.href='../index.jsp'">Home</button>
<!-- 회원가입이 성공되면 gaipSuccess 페이지로 간다
dao 하나 만들면 id 보내서
name 리턴 받는 김연아 님의 회원가입이 성공되었습니다.

성공 이미지

angel님의 회원가입이 성공되었습니다. -->
</body>
</html>