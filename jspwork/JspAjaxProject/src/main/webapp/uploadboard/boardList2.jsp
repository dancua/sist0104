<%@page import="java.text.SimpleDateFormat"%>
<%@page import="uploadboard.data.upDTO"%>
<%@page import="java.util.List"%>
<%@page import="uploadboard.data.upDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
 <style>
  .album {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}
.photo {
    margin: 10px;
    text-align: center;
    border: 1px solid #ccc;
    padding: 10px;
    
}
    </style>
<body>
<%
String num = request.getParameter("num");
upDAO dao = new upDAO();

List<upDTO> list = dao.getAllDatas();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

%>
<h6 class="alert alert-info">
			총<%=list.size()%>개의 게시글이 있습니다.
		</h6>
<div class="album">
<%
for( int i = 0; i< list.size(); i++){
	upDTO dto = list.get(i);
%>
<div class="photo">
<img alt="" src="../save/<%=dto.getImgname() %>">
<div>제목: <%=dto.getSubject() %> </div><br>
<div>작성자: <%=dto.getWriter() %> </div><br>
<div>작성일: <%=sdf.format(dto.getWriteday()) %></div><br>
<div>조회수: <%=dto.getReadcount() %> </div><br>
</div>
<% } %>
</div>
</body>
</html>