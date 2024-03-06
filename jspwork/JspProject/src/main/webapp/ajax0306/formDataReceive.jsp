<%@page import="org.json.simple.JSONObject"%>
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
	String photo = request.getParameter("foodphoto");
	String fname = request.getParameter("foodname");
	String like1 = request.getParameter("like1");
	String like2 = request.getParameter("like2");
	String like3 = request.getParameter("like3");
	
	//총점
	int tot = Integer.parseInt(like1)+Integer.parseInt(like2)+Integer.parseInt(like3);
	
	//평균
	double avg = tot/3.0;
	
	//front형태로 만들어서 보내기
	JSONObject ob = new JSONObject();
	ob.put("photo","../image'/Food"+photo+".jpg");
	ob.put("food",fname);
	ob.put("tot",tot);
	ob.put("avg",avg);
%>

<%=ob.toString()%>

</script>

</body>
</html>