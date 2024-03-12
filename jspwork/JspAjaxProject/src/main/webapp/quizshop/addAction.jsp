<%@page import="quizShop.model.quizDAO"%>
<%@page import="quizShop.model.quizDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("utf-8");

String name = request.getParameter("sang_name");
String photo = request.getParameter("photo");
int price = Integer.parseInt(request.getParameter("price"));
String ipgoday = request.getParameter("ipgoday");

quizDTO dto = new quizDTO();

dto.setSang_name(name);
dto.setPhoto(photo);
dto.setPrice(price);
dto.setIpgoday(ipgoday);

quizDAO dao = new quizDAO();

dao.insert(dto);

response.sendRedirect("shopList.jsp");

%>