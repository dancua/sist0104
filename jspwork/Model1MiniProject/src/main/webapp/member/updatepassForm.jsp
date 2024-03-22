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
String num = request.getParameter("num");
%>
<div style="margin:100px 200px;">
<form action="member/updateapassAction.jsp" method="post">
<input type="hidden" name="num" value="<%=num %>">
<b>수정시 필요한 비밀번호 입력</b>
<br><br>
<div class="d-inline-flex">
<input type="password" name="pass" class="form-control"
style="width:120px;" required="required">
<button type="submit" class="btn btn-info" style="margin-left:10px;">확인</button>


</div>


</form>
</div>
<!-- 1.mypage에서 수정버튼을 클릭하면 updatepassForm으로 이동
updatepassAction에서 처리

처리후 
비밀번호가 맞으면 updateForm으로 가고
맞지 않으면 경고창 
수정창에서 이름,핸드폰,주소,이메일을 수정한후 마이페이지로 가고 수정이됐는지 확인하면 된다
dao

1.getDataMember(String num)
2.updateMember
-->



</body>
</html>