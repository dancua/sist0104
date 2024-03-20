<%@page import="ajaxwrite.model.ajaxDAO"%>
<%@page import="ajaxwrite.model.ajaxDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");

String num = request.getParameter("unum");
String writer = request.getParameter("uwriter");
String subject = request.getParameter("usubject");
String story = request.getParameter("ustory");
String image = request.getParameter("uimage");

ajaxDTO dto = new ajaxDTO();

ajaxDAO dao = new ajaxDAO();

dto.setNum(num);
dto.setWriter(writer);
dto.setSubject(subject);
dto.setStory(story);
dto.setImage(image);

dao.updateWrite(dto);

%>