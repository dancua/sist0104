<%@page import="ajaxwrite.model.ajaxDTO"%>
<%@page import="ajaxwrite.model.ajaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

String writer = request.getParameter("writer");
String subject = request.getParameter("subject");
String story = request.getParameter("story");
String image = request.getParameter("image");

ajaxDTO dto = new ajaxDTO();
dto.setWriter(writer);
dto.setSubject(subject);
dto.setStory(story);
dto.setImage(image);

ajaxDAO dao = new ajaxDAO();

dao.insertWrite(dto);

%>