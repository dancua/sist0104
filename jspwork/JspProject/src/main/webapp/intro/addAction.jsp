<%@page import="intro.model.introDAO"%>
<%@page import="intro.model.introDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<script href="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>

	<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String birthday = request.getParameter("birthday");
	String hometown = request.getParameter("hometown");
	String[] hobby = request.getParameterValues("hobby");
	String memo = request.getParameter("memo");
	
	introDTO dto = new introDTO();
	
	dto.setName(name);
	dto.setAge(age);
	dto.setBirthday(birthday);
	dto.setHometown(hometown);
	if(hobby==null){
		dto.setHobby("취미생활 없음");
	}else{
		String hobbies = String.join(",",hobby);
		dto.setHobby(hobbies);
	}
	
	dto.setMemo(memo);
	
	introDAO dao = new introDAO();
	
	dao.insertIntro(dto);
	
	response.sendRedirect("introList.jsp");
	%>

</body>
</html>