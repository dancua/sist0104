<%@page import="myinfo.db.myinfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

String num = request.getParameter("num");
myinfoDAO dao = new myinfoDAO();
dao.deleteInfo(num);


response.sendRedirect("infoList.jsp");

%>