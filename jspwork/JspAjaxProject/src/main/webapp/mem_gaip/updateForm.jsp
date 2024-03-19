<%@page import="memgaip.model.MemDTO"%>
<%@page import="memgaip.model.MemDAO"%>
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
String num = request.getParameter("m_num");
MemDAO dao = new MemDAO();
MemDTO dto = dao.getData(num);
%>
<body>
<div style="margin:50px 100px; width:500px;">
	<form action="updateMember.jsp" method="post" enctype="multipart/form-data" name="mfrm">
		<input type="hidden" name="m_num" value="<%=num %>">
		<table class="table table-bordered">
			<caption align="top"><b>회원수정</b></caption>
			
		 <tr>
			<td width="120" class="table-primary">아이디</td>
			<td>
				<b><%=dto.getM_id() %></b>
			</td>
			</tr> 
			
			<tr>
			<td width="120" class="table-primary">회원명</td>
			<td>
				<input type="text" class="form-control"
				style="width:120px;" name="m_name" required="required"
				value="<%=dto.getM_name() %>">
			</td>
			</tr>
			  
			<tr>
			<td width="120" class="table-primary">사진</td>
			<td>
				<input type="file" class="form-control"
				style="width:200px;" name="m_photo">
			</td>
			</tr> 
			<tr>
			<td width="120" class="table-primary">핸드폰</td>
			<td>
				<input type="text" class="form-control"
				style="width:180px;" name="m_hp" required="required"
				value="<%=dto.getM_hp()%>">
			</td>
			</tr>
			
			<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-info" id="btnsubmit">회원가입 수정</button>
			</td>
			</tr>
			
		</table>
	</form>
</div>
</body>
</html>