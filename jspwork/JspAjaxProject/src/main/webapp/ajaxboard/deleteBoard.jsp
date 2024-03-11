<%@page import="ajaxboard.ajaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String num = request.getParameter("num");

ajaxDAO dao = new ajaxDAO();

dao.deleteBoard(num);

%>