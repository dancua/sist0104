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
<body>

<%
request.setCharacterEncoding("utf-8");

String m_num = request.getParameter("m_num");
String m_pass = request.getParameter("m_pass");

MemDAO dao = new MemDAO();

boolean a = dao.isEquals(m_num ,m_pass);

if(a){
	dao.deleteMem(m_num);
	response.sendRedirect("memList.jsp");

	}else{%>
	 <script type="text/javascript">
	alert("비밀번호가 맞지않습니다.");
	history.back();
	</script>
	<%}
%>

</body>
</html>