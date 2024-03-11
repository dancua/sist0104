<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ajaxboard.ajaxDTO"%>
<%@page import="java.util.List"%>
<%@page import="ajaxboard.ajaxDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ajaxDAO dao = new ajaxDAO();
List<ajaxDTO> list = dao.getAllDatas();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

JSONArray arr = new JSONArray();

for(ajaxDTO dto : list){
	JSONObject ob = new JSONObject();
	ob.put("num",dto.getNum());
	ob.put("writer",dto.getWriter());
	ob.put("subject",dto.getSubject());
	ob.put("content",dto.getContent());
	ob.put("avata",dto.getAvata());
	ob.put("writeday",sdf.format(dto.getWriteday()));
	

	arr.add(ob);
}
%>
<%=arr.toString() %>
