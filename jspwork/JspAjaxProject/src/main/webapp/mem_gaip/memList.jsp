<%@page import="java.text.SimpleDateFormat"%>
<%@page import="memgaip.model.MemDAO"%>
<%@page import="memgaip.model.MemDTO"%>
<%@page import="java.util.List"%>
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
<style type="text/css">


</style>
</head>
<body>
<%
MemDAO dao = new MemDAO();
request.setCharacterEncoding("utf-8");
List<MemDTO> list = dao.getAllDatas();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<div style="margin:50px 100px; width:1000px;">
<b>총 <%=list.size() %>명의 회원이 가입되었습니다.</b>
<button type="button" class="btn btn-warning"
onclick="location.href='addForm.jsp'" style="float:right; margin-right:50px;">회원가입</button>
<br>
<table class="table table-bordered">
<caption align="top"><b>전체 회원 명단</b></caption>
<tr class="table-success">
<th width="80">번호</th>
<th width="180">아이디</th>
<th width="180">회원명</th>
<th width="200">핸드폰</th>
<th width="200">가입일</th>
<th width="150">편집</th>
</tr>
<%
int i = 1;
for(MemDTO dto : list)
{%>
<tr>
<td><%=i++ %></td>
<td><%=dto.getM_id() %></td>
<td>
<%
if(dto.getM_id()==null)
{%>
<img alt="" src="../image/연예인사진/noimage.png" class="rounded-circle">
<%}else{
	%>
<img alt="" src="../upload/<%=dto.getM_photo() %>" class="rounded-circle">
<%}
%>
<br>
<b><%=dto.getM_name() %></b>
</td>
<td align="center" valign="middle"><%=dto.getM_hp() %></td>
<td align="center" valign="middle"><%=sdf.format(dto.getGaipday()) %></td>
<td>
<button type="button" class="btn btn-success btn-sm">수정</button>

<button type="button" class="btn btn-success btn-sm" 
onclick="location.href='deletepassForm.jsp?num=<%=dto.getM_num()%>'">삭제</button>
</td>
</tr>
<%
}%>
</table>
</div>
</body>
</html>