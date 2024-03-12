<%@page import="myinfo.db.myinfoDAO"%>
<%@page import="myinfo.db.myinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");

String name = request.getParameter("name");
String blood = request.getParameter("blood");
String hp = request.getParameter("hp1")+"-"+ request.getParameter("hp2")+"-"+ request.getParameter("hp3");
String birth = request.getParameter("birth");

myinfoDTO dto = new myinfoDTO();

dto.setName(name);
dto.setBlood(blood);
dto.setHp(hp);
dto.setBirth(birth);

myinfoDAO dao = new myinfoDAO();

dao.insertMyInfo(dto);

response.sendRedirect("infoList.jsp");

%>