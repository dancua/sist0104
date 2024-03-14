<%@page import="uploadboard.data.upDAO"%>
<%@page import="uploadboard.data.upDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
request.setCharacterEncoding("utf-8");

//업로드에 필요한 변수선언
//업로드할 경로(톰캣에 올라가는 프로젝트경로)
String realFolder =  getServletContext().getRealPath("/save");
System.out.println(realFolder);

//업로드 사이즈
	int uploadSize = 1024*1024*3; // 3메가바이트
	
	//생성자 파라메터(request,업로드폴더,업로드사이즈,한글,같은이름일 경우 중복 방지 1,2,3붙히기)
	try{
	MultipartRequest multi= new MultipartRequest(request,realFolder,uploadSize,"utf-8",
			new DefaultFileRenamePolicy());
	
	//입력값 읽기
	String writer = multi.getParameter("writer");
	String subject = multi.getParameter("subject");
	String content = multi.getParameter("content");
	String pass = multi.getParameter("pass");
	String num = multi.getParameter("num");
	
	//실제 업로드 이미지 이름 읽어오기
	String imgname = multi.getFilesystemName("photo");
	
	//dto에 담기
	upDTO dto = new upDTO();
	
	dto.setWriter(writer);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setPass(pass);
	dto.setImgname(imgname);
	
	//dao생성
	upDAO dao = new upDAO();
	//비번이 맞으면 수정후 디테일페이지로 이동
	//비번이 틀리면 스크립트로 경고
	boolean b = dao.isEqualPass(num, pass);
	
	if(b){
		dao.update(dto);
		
		response.sendRedirect("content.jsp?num="+num);
	}else{
		%>
		<script type="text/javascript">
		alert("비밀번호가 틀렸어요");
		history.back();
		</script>
	
	<%}
	}catch(Exception e){
	
	}
%>
</body>
</html>