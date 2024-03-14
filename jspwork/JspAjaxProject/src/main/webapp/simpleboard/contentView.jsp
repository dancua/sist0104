<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simple.model.simDTO"%>
<%@page import="simple.model.simDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Insert title here</title>
</head>
<style type="text/css">
body *{
font-family: 'Noto Serif KR';
font-size: 11pt;
}

span.day{
color:#ccc;
font-size: 0.8em;}
</style>
<body>
<%
String num = request.getParameter("num");
simDAO dao = new simDAO();
//dto
simDTO dto = dao.getContent(num);
//조회수 1증가
dao.updateReadCount(num);
//날짜
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<div style="margin:50px 100px; width:500px;">
<table class="table table-bordered">
<caption align ="top"><b style="font-size:15pt;"><%=dto.getSubject() %></b></caption>
<tr>
<td>
<b>작성자: <%=dto.getWriter() %></b><br>
   <span class="day"><%=sdf.format(dto.getWriteday()) %></span>
&nbsp;&nbsp;&nbsp;&nbsp;조회:<%=dto.getReadcount() %>
</td>
</tr>

<tr height="250">
<td>
<%=dto.getContent().replace("\n","<br>") %>
</td>
</tr>

<tr>
<td align="center">
<button type="button" class="btn btn-outline-info"
onclick="location.href='addForm.jsp'"><i class="bi bi-pencil"></i>글쓰기</button>
<button type="button" class="btn btn-outline-success"
onclick="location.href='boardList.jsp'"><i class="bi bi-list-check"></i>목록</button>
<button type="button" class="btn btn-outline-warning"
onclick="location.href='updatepassForm.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-pencil-square"></i>수정</button>
<button type="button" class="btn btn-outline-danger"
onclick="location.href='deletepassForm.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-trash"></i>삭제</button>
</table>
</div>
</body>
</html>