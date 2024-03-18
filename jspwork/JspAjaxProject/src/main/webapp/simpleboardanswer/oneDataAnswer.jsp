<%@page import="org.json.simple.JSONObject"%>
<%@page import="simpleanswer.model.simaDTO"%>
<%@page import="simpleanswer.model.simaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String idx = request.getParameter("idx");
simaDAO dao = new simaDAO();
simaDTO dto = dao.getData(idx);

JSONObject ob = new JSONObject();

ob.put("idx",dto.getIdx());
ob.put("nick",dto.getNickname());
ob.put("content",dto.getContent());

%>

<%=ob.toString()%>