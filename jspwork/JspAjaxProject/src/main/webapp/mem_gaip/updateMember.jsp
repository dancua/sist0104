<%@page import="memgaip.model.MemDTO"%>
<%@page import="memgaip.model.MemDAO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script href="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
String realPath = getServletContext().getRealPath("/upload");
int uploadSize = 1024*1024*3;

MultipartRequest multi = null;

multi = new MultipartRequest(request,realPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());

MemDAO dao = new MemDAO();

MemDTO dto = new MemDTO();

dto.setM_num(multi.getParameter("m_num"));
dto.setM_name(multi.getParameter("m_name"));
dto.setM_hp(multi.getParameter("m_hp"));

String photo = multi.getFilesystemName("m_photo");

if(photo==null){
	String oldPhoto = dao.getData(dto.getM_num()).getM_photo();
	dto.setM_photo(oldPhoto);
}else{
	dto.setM_photo("../upload/"+photo);
	
	dao.update(dto);
	
	response.sendRedirect("memList.jsp");
}


%>

</body>
</html>