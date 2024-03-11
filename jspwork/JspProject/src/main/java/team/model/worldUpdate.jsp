<%@page import="myworld.model.WorldDAO"%>
<%@page import="myworld.model.WorldDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script href="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>

<%

request.setCharacterEncoding("utf-8");

String num = request.getParameter("unum");
String writer = request.getParameter("uwriter");
String content = request.getParameter("ucontent");
String avata = request.getParameter("uavata");


WorldDTO dto = new WorldDTO();

dto.setNum(num);
dto.setWriter(writer);
dto.setContent(content);
dto.setAvata(avata);

WorldDAO dao = new WorldDAO();

dao.worldUpdate(dto);

%>

</body>
</html>