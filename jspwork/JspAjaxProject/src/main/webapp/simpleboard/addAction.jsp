<%@page import="simple.model.simDAO"%>
<%@page import="simple.model.simDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
%>
    
<%-- <%
String writer = request.getParameter("writer");
String pass = request.getParameter("pass");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

simDTO dto = new simDTO();

dto.setWriter(writer);
dto.setPass(pass);
dto.setSubject(subject);
dto.setContent(content);

simDAO dao = new simDAO();

dao.insert(dto);

response.sendRedirect("boardList.jsp");

%> --%>
<jsp:useBean id ="dao" class="simple.model.simDAO"/>
<jsp:useBean id="dto" class="simple.model.simDTO"/>
<jsp:setProperty property ="*" name="dto"/>

<%

dao.insert(dto);

// 목록
// response.sendRedirect("boardList.jsp");
// 인서트후 내용보기로 이동하려면 방금 isert된 num값을 알아야한다.
int num = dao.getMaxNum();


 response.sendRedirect("contentView.jsp?num="+num);







%>
