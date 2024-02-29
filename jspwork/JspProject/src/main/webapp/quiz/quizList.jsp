<%@page import="java.text.SimpleDateFormat"%>
<%@page import="quiz.model.quizDto"%>
<%@page import="quiz.model.quizDao"%>
<%@page import="java.util.Vector"%>
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
<%quizDao dao = new quizDao();
Vector<quizDto> list=dao.infoSelect();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
<body>
<div style="margin:50px 100px;">
<button type="button" class="btn btn-info"
onclick="location.href='insertForm.jsp'">입력폼</button>
<hr>
<table class="table table-bordered" style="width: 1000px;">
   <caption align="top"><b>info 전체목록</b></caption>
   <tr class="table-success">
     <th width="80">번호</th>
     <th width="120">이름</th>
     <th width="120">나이</th>
     <th width="250">핸드폰</th>
     <th width="150">운전면허</th>
     <th width="200">가입날짜</th>
     <th width="150">수정/삭제</th>
     
   </tr>
<%
for(int i = 0; i<list.size(); i++)
{
	quizDto dto = list.get(i);
	%>

<tr>
<td align="center"><%=i+1%></td>
<td><%=dto.getName() %></td>
<td><%=dto.getAge() %></td>
<td><%=dto.getHp() %></td>
<td><%=dto.getDriver() %></td>
<td><%=sdf.format(dto.getSdate()) %></td>
<td>
<button type="button" class="btn btn-info btn-sm" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
<button type="button" class="btn btn-danger btn-sm" 
onclick="location.href='infoDelete.jsp?num=<%=dto.getNum()%>'">삭제</button>
</td>
</tr>
<%}
%>
</div>
</table>
</body>
</html>