<%@page import="memgaip.model.MemDTO"%>
<%@page import="memgaip.model.MemDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String m_num = request.getParameter("m_num");
String m_pass = request.getParameter("m_pass");

MemDAO dao = new MemDAO();
MemDTO dto = new MemDTO();
boolean check = dao.isEquals(m_num, m_pass);
%>

if(check)  
	<%{ 
	dao.update(dto);
	response.sendRedirect("updateForm.jsp?m_num="+m_num);
%>}else{
<script type="text/javascript">
alert("비밀번호가 맞지않습니다.");
history.back();

</script>
<%}

%>

<%-- <jsp:useBean id="dao" class="memgaip.model.MemDAO"/>
<jsp:useBean id="dto" class="memgaip.model.MemDTO"/>
<jsp:setProperty property="*" name="dto"/> --%>

