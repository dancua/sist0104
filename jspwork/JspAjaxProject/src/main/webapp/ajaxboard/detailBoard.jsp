<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="ajaxboard.ajaxDTO"%>
<%@page import="java.util.List"%>
<%@page import="ajaxboard.ajaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String num = request.getParameter("num");

ajaxDAO dao = new ajaxDAO();

ajaxDTO dto = dao.getData(num);

//dto를 json으로 변환
  JSONObject ob=new JSONObject();
//날짜타입 문자열 지정
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

ob.put("num", dto.getNum());
ob.put("writer", dto.getWriter());
ob.put("subject", dto.getSubject());
ob.put("content", dto.getContent());
ob.put("avata", dto.getAvata());
ob.put("writeday", sdf.format(dto.getWriteday()));

%>

<%=ob.toString()%>