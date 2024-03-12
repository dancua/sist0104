<%@page import="java.text.SimpleDateFormat"%>
<%@page import="quizShop.model.quizDTO"%>
<%@page import="java.util.List"%>
<%@page import="quizShop.model.quizDAO"%>
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
<style type="text/css">

.sang{
cursor:pointer;

}

</style>
</head>
<%
quizDAO dao = new quizDAO();

List<quizDTO>list=dao.getAllInfos();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

%>

<body>
<div style="margin:50px 50px; width:800px;">
<h3 class="alert alert-info">QuizShop 입고목록</h3>
<br>
<button type="button" class="btn btn-info"
onclick="location.href='addForm.jsp'">상품추가</button>
<br>
<table class="table table-bordered">
	<tr class="table-info">
	<th width="60">번호</th>
	<th width="150">상품명</th>
	<th width="150">가격</th>
	<th width="150">입고일</th>
	<th width="200">등록일</th>
	</tr>
	
<%
for(int i = 0; i<list.size(); i++){
	quizDTO dto = list.get(i);
	%>
	<tr>
	<td align="center"><%=i+1 %></td>
	<td class ="sang" onclick="location.href='detailPage.jsp'"><%=dto.getSang_name() %></td>
	<td><%=dto.getPrice() %></td>
	<td><%=dto.getIpgoday() %></td>
	<td><%=dto.getWriteday() %></td>
	</tr>
<%}

%>	
</table>
</div>
</body>
</html>