<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dao" class="simpleanswer.model.simaDAO"/>
<jsp:useBean id="dto" class="simpleanswer.model.simaDTO"/>
<jsp:setProperty property="*" name="dto"/>

<%
dao.updateAnswer(dto);

%>