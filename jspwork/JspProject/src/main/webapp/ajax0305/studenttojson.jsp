<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql_db.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
DbConnect db = new DbConnect();
Connection conn = db.getConnection();
PreparedStatement pstmt = null;
ResultSet rs =null;


String sql = "select * from student order by num";

String s = "[";

try{
pstmt = conn.prepareStatement(sql);
rs= pstmt.executeQuery();

while(rs.next()){
	
	String num = rs.getString("num");
	String name = rs.getString("name");
	String photo = rs.getString("photo");
	int java = rs.getInt("java");
	int spring = rs.getInt("spring");
	

	
	// json파싱 "num":num
			s+="{";
			s+="\"num\":"+num+",\"name\":\""+name+"\",\"photo\":\""+photo;
			s+="\",\"java\":"+java+",\"spring\":\""+photo+"\"";
			s+="},";
			
			s = s.substring(0, s.length() - 1);
}

}catch(SQLException e){
	
}finally{
	db.dbClose(rs, pstmt, conn);
}
%>

<%=s%>