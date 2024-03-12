<%@page import="quizShop.model.quizDAO"%>
<%@page import="quizShop.model.quizDTO"%>
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
<%
String num = request.getParameter("num");
quizDAO dao = new quizDAO();
quizDTO dto = dao.getOneData(num);

%>

<div style="margin:50px;">
<img src="../image/쇼핑몰사진/<%=dto.getPhoto()%>.jpg" style="width:500px; height:500px;">
<div style="margin-top: 20px;" class="d-inline-flex">
<p>상품명: <%=dto.getSang_name()%></p>
<p>가격: <%=dto.getPrice() %></p>
<p>입고일: <%=dto.getIpgoday() %></p>
<button type="button" class="btn btn-info"  onclick="location.href='shopList.jsp'">돌아가기</button>
</div>

</div>
<!-- 이미지가 크게 나오고 옆에 설명 추가
	상품명 기격 입고일 수정버튼 삭제 -->
	
</body>
</html>