<%@page import="simpleanswer.model.simaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String idx = request.getParameter("idx");
simaDAO dao = new simaDAO();
dao.delete(idx);

%>