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
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String cel = request.getParameter("celeb");
%>

<h2>연예인 이름:<%=name %></h2>
<h2>주소: <%=addr %></h2>
<h2>사진</h2>
<img alt="" src="<%=cel %>"/>

</body>
</html>