package log.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql_db.DbConnect;

public class logDAO {

	DbConnect db= new DbConnect();
	

	//아이디를 통해 name값 얻어오기
	
	public boolean isLogin(String id, String pass) {
		boolean flag =false;
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		String sql = "select * from log where id=? and pass=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		return flag;
		
	}
	//아이디를 통해 name값 얻어오기
	public String getName(String id) {
		String name="";
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from log where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return name;
	}
	
}
