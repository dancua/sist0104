<%@page import="java.io.File"%>
<%@page import="uploadboard.data.upDAO"%>
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
//num,pass 읽기
String num = request.getParameter("num");
String pass = request.getParameter("pass");

upDAO dao = new upDAO();

boolean b = dao.isEqualPass(num, pass);

if(b)
{
	
	//게시글 지우기전 업로드된 이미지 지우기
	String imgName = dao.getData(num).getImgname();
	
	String uploadPath = getServletContext().getRealPath("/save");
	//파일생성
	File file = new File(uploadPath+"\\"+imgName);
	
	if(file.exists())
		file.delete();
	
	//db삭제
	
	dao.delete(num);
	response.sendRedirect("boardList.jsp");
}else{
	%>
	<script type="text/javascript">
	alert("비밀번호가 맞지않습니다.")
	history.back();
	</script>
<% }

%>
</body>
</html>