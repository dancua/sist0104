<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="simpleanswer.model.simaDAO"%>
<%@page import="simpleanswer.model.simaDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");
	simaDAO dao=new simaDAO();
	List<simaDTO> list=dao.getAllDatas(num);
	
	JSONArray arr=new JSONArray();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(simaDTO dto:list)
	{
		JSONObject ob=new JSONObject();
		
		ob.put("idx", dto.getIdx());
		ob.put("num", dto.getNum());
		ob.put("nick", dto.getNickname());
		ob.put("content", dto.getContent());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr.toString()%>