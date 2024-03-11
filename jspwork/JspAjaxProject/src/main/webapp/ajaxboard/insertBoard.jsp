<%@page import="ajaxboard.ajaxDAO"%>
<%@page import="ajaxboard.ajaxDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

request.setCharacterEncoding("utf-8");

String writer = request.getParameter("writer");
String subject = request.getParameter("subject");
String content = request.getParameter("content");
String avata = request.getParameter("avata");

ajaxDTO dto = new ajaxDTO();

dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setAvata(avata);

ajaxDAO dao = new ajaxDAO();

dao.insertBoard(dto);

%>
