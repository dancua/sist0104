<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql_db.DbConnect"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<data> 
<%

//mysql의 team테이블이 데이터를 읽어서 xml방식으로 출력

	DbConnect db = new DbConnect();
	Connection conn=db.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "select * from food order by num";
	
	try{
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			
			String num = rs.getString("num");
			String foodname = rs.getString("foodname");
			String foodphoto = rs.getString("foodphoto");
			int price = rs.getInt("price");
			int cnt = rs.getInt("cnt");
			
			%>
			<food num="<%=num%>">
			<foodname><%=foodname%></foodname>
			<foodphoto><%=foodphoto%></foodphoto>
			<price><%=price%></price>
			<cnt><%=cnt%></cnt>
			</food>
		<%}
	}catch(SQLException e){
		
	}finally{
		db.dbClose(rs,pstmt, conn);
	}
%> 
</data>
