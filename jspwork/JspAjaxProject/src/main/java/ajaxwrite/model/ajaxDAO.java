package ajaxwrite.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql_db.DbConnect;

public class ajaxDAO {

  DbConnect db=new DbConnect();
  
  public void insertWrite(ajaxDTO dto)
  {
	  Connection conn=db.getConnection();
	  PreparedStatement pstmt=null;
	  
	  String sql="insert into ajaxwrite values(null,?,?,?,?,0,now())";
	  
	  try {
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getWriter());
		pstmt.setString(2, dto.getSubject());
		pstmt.setString(3, dto.getStory());
		pstmt.setString(4, dto.getImage());
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
	}
	  
  }
  
  //전체출력
  public List<ajaxDTO> getAllDatas()
  {
	  List<ajaxDTO> list=new ArrayList<ajaxDTO>();
	  
	  Connection conn=db.getConnection();
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;
	  
	  String sql="select * from ajaxwrite order by num desc";
	  
	  try {
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			ajaxDTO dto=new ajaxDTO();
			
			dto.setNum(rs.getString("num"));
			dto.setSubject(rs.getString("subject"));
			dto.setStory(rs.getString("story"));
			dto.setImage(rs.getString("image"));
			dto.setLikes(rs.getInt("likes"));
			dto.setWriteday(rs.getTimestamp("writeday"));
			dto.setWriter(rs.getString("writer"));
			
			list.add(dto);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(rs, pstmt, conn);
	}
	  
	  return list;
  }
  
  public ajaxDTO getData(String num) {
	  ajaxDTO dto = new ajaxDTO();
	  
	  Connection conn = db.getConnection();
	  PreparedStatement pstmt= null;
	  ResultSet rs = null;
	  
	  String sql = "select * from ajaxwrite where num = ?";
	  
	  try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
		
		dto.setNum(rs.getString("num"));
		dto.setSubject(rs.getString("subject"));
		dto.setStory(rs.getString("story"));
		dto.setImage(rs.getString("image"));
		dto.setLikes(rs.getInt("likes"));
		dto.setWriteday(rs.getTimestamp("writeday"));
		dto.setWriter(rs.getString("writer"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(rs, pstmt, conn);
	}
	  return dto;
  }
  
  public void updateWrite(ajaxDTO dto) {
	  
	  Connection conn = db.getConnection();
	  PreparedStatement pstmt = null;
	  
	  String sql = "update ajaxwrite set subject = ?, story = ?, image = ?, writer = ? where num =?";
	  
	  try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,dto.getSubject());
		pstmt.setString(2, dto.getStory());
		pstmt.setString(3, dto.getImage());
		pstmt.setString(4, dto.getWriter());
		pstmt.setString(5,dto.getNum());
		pstmt.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
		
	}
  }
  
  public void deleteWrite(String num) {
	  
	  Connection conn = db.getConnection();
	  PreparedStatement pstmt = null;
	  
	  String sql = "delete from ajaxwrite where num = ?";
	  
	  try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
	}
  }
  
  
}