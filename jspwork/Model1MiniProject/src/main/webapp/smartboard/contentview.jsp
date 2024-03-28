<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
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
<body>
<!-- 상세페이지 -->
작성자 글제목,날짜,내용 조회수 포함
맨아래에는 목록,글쓰기,수정,삭제 버튼 만들기

<jsp:useBean id="dao" class="data.dao.SmartDao"></jsp:useBean>
<%
String num = request.getParameter("num");
String currentPage = request.getParameter("currentPage");

//조회수 1 증가
dao.updateReadcount(num);

SmartDto dto = dao.getData(num);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<div style="margin:50px 100px; width:500px;">
	<table class="table table-bordered">
	<caption align="top"><h3><b>
	<%=dto.getSubject() %>
	</b></h3></caption>
	<tr>
	<td>
	<b>작성자:<%=dto.getWriter() %></b><br>
	<span><%=sdf.format(dto.getWriteday()) %></span>
	&nbsp;&nbsp;조회 <%=dto.getReadcount()%>
	</td>
	</tr>
	
	<tr height="150">
	<td>
		<%=dto.getContent().replace("\n","<br>") %>
	</td>
	</tr>
	
	<tr>
	<td style="float:right;">
	<button type="button" class="btn btn-info btn-sm"
	onclick="location.href='index.jsp?main=smartboard.smartform.jsp'">글쓰기</button>
	<button type="button" class="btn btn-success btn-sm"
	onclick="location.href='index.jsp?main=smartboard/boardList.jsp'">목록</button>
	<button type="button" class="btn btn-warning btn-sm" onclick="location.href=''">수정</button>
	<button type="button" class="btn btn-danger btn" onclick="location.href=''">삭제</button>
	</table>
</div>

</body>
</html>