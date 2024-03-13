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
<style type="text/css">

div.logform{
width:500px;
margin 0 auto;
margin-top:100px;}


</style>
<%
//세션으로부터 아이디와 체크값을 얻는다
String myid= (String)request.getParameter("idok");
String saveid = (String)request.getParameter("saveok");

boolean save = true;

if(saveid==null || saveid.equals("no")){

	myid = ""; //아이디 저장을 체크하지 않은경우
	save=false;
}

%>
<body>
<div style="margin:100px 100px;">
<h2 class="alert alert-warning">회원 로그인</h2>
<form action="LoginAction.jsp" method="post">
<input type="text" name="id" class="form-control"
style="width:200px;" placeholder="로그인할 아이디" required="required">
<br>
<input type="text" name="pass" class="form-control"
style="width:200px;" placeholder="로그인할 패스워드" required="required">
<br>
<button type="submit" class="btn btn-sucess btn-lg"
style="width:200px; height:50px;">로그인</button>
<br>
<input type="checkbox" name="savechk" <%=save?"checked":"" %>>아이디 저장
</form>
</div>
</body>
</html>