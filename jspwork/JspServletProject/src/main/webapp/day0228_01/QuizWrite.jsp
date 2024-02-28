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
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String date = request.getParameter("date");
	String food = request.getParameter("Food");
	String[] food2 = request.getParameterValues("Food2");
	%>

<h4 class="alert alert-info">
사원명:<%=name %><br>
입사일자:<%=date %><br>
오늘 점심메뉴:<img alt="" src="<%=food %>" style="width:80px;"/><br>
2순위지역:
	<%
	if(food2==null)
	{%>
		<font color="red">원하는 메뉴 없음</font>
	<%}else
	{
		for(int i =0; i< food2.length; i++)
		{%>
			[<%=food2[i] %>]&nbsp;
		<%}%>
	<%}
%>
</h4>
</body>
</html>