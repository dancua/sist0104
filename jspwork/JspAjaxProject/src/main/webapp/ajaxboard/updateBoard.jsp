<%@page import="ajaxboard.ajaxDTO"%>
<%@page import="ajaxboard.ajaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String num = request.getParameter("num");
String writer = request.getParameter("writer");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
String avata = request.getParameter("avata");

ajaxDAO dao = new ajaxDAO();

ajaxDTO dto = new ajaxDTO();

dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setAvata(avata);

dao.updateBoard(dto);
%>
