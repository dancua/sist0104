<%@page import="data.dao.AnswerGuestDao"%>
<%@page import="data.dto.AnswerGuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

request.setCharacterEncoding("utf-8");

AnswerGuestDto dto = new AnswerGuestDto();

String num = request.getParameter("num");
String myid = request.getParameter("myid");
String content = request.getParameter("content");

dto.setNum(num);
dto.setMyid(myid);
dto.setContent(content);

AnswerGuestDao dao = new AnswerGuestDao();

dao.insertAnswer(dto);

response.sendRedirect("memberguest/guestList.jsp");


 %>