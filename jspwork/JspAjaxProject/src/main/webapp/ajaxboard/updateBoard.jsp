<%@page import="ajaxboard.ajaxDTO"%>
<%@page import="ajaxboard.ajaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%

request.setCharacterEncoding("utf-8");

String num = request.getParameter("unum");
String writer = request.getParameter("uwriter");
String subject = request.getParameter("usubject");
String content = request.getParameter("ucontent");
String avata = request.getParameter("uavata");

ajaxDAO dao = new ajaxDAO();

ajaxDTO dto = new ajaxDTO();

dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setAvata(avata);

dao.updateBoard(dto);
%>
