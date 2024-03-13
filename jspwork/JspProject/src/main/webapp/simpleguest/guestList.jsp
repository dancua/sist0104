<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="simpleguest.model.GuestDAO"%>
<%@page import="simpleguest.model.GuestDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 2pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script href="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style>
span.day{
float: right;
color: #aaa;
}
body{
font-family:'Noto Sans KR';
}
div.edit{
float:right;
}

</style>
</head>
<body>
<%
GuestDAO dao = new GuestDAO();
ArrayList<GuestDTO> list = dao.getAllDatas();
%>

<div style="margin:50px 100px; width:600px;">
<button type="button" class="btn btn-info btn-sm"
onclick="location.href='insertForm.jsp'">글쓰기</button>
<br><br>

<%
	for(int i = 0; i<list.size(); i++)
	{
		GuestDTO dto = list.get(i);
		int no =  list.size()-i;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
		%>
		<div class="edit">
		<i class="bi bi-pencil-square" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'"></i>			
		<i class="bi bi-trash" onclick="location.href='deleteGuest.jsp?num=<%=dto.getNum()%>'"></i>
		</div>
		<table class="table table-bordered" style="width:600px;">
			<tr>
				<td>
				<b>No.<%=no %></b>&nbsp;&nbsp;
				<b><%=dto.getNickname() %></b>
				<span class="day"><%=sdf.format(dto.getWriteday()) %></span>
				</td>
			</tr>
			<tr>
			<td>
			<div style="width:400px;">
			<img alt="" src="../image/avata/b<%=dto.getImage()%>.png"
			align="left" hspace="20">                      
			<pre><%=dto.getContent() %></pre>
			</div>
			</td>
			</tr>
		</table>
			
	<%}
%>

</div>
</body>
</html>