<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
String pass = request.getParameter("pass");

//dao 선언

MemberDao dao = new MemberDao();

//비밀번호 체크


boolean b = dao.isEqualPass(num, pass);

if(b){
	dao.delete(num);
	
	//세션삭제
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
		session.removeAttribute("saveok");
	
	%>
	<script type="text/javascript">
	
	alert("회원탈퇴 성공");
	location.href="../index.jsp";
	</script>
<%}else{%>
<script type="text/javascript">
alert("회원탈퇴 실패");
history.back();

</script>

 <%}

%>


