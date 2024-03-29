package intro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import info.model.InfoDto;
import mysql_db.DbConnect;
import team.model.TeamDTO;

public class introDAO {
	
	DbConnect db = new DbConnect();
	
	public void insertIntro(introDTO dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into intro(name,age,birthday,hometown,hobby,memo) values(?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getName());
			pstmt.setString(2,dto.getAge());
			pstmt.setString(3,dto.getBirthday());
			pstmt.setString(4,dto.getHometown());
			pstmt.setString(5,dto.getHobby());
			pstmt.setString(6,dto.getMemo());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
	}
	
	public ArrayList<introDTO> getAllTeams(){
		
		ArrayList<introDTO> list = new ArrayList<introDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select *from intro order by num";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			introDTO dto=new introDTO();	
			
			dto.setNum(rs.getString("num"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getString("age"));
			dto.setBirthday(rs.getString("birthday"));
			dto.setHometown(rs.getString("hometown"));
			dto.setHobby(rs.getString("hobby"));
			dto.setMemo(rs.getString("memo"));
			
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
	
	public void deleteIntro(String num)
	{
		Connection conn =db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from intro where num=?";
		
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
	public introDTO getOneData(String num) {
		
		introDTO dto = new introDTO();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from intro where num=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setHometown(rs.getString("hometown"));
				dto.setHobby(rs.getString("hobby"));
				dto.setMemo(rs.getString("memo"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void updateIntro(introDTO dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql ="update intro set name=?,age=?,birthday=?,hometown=?,hobby=?,memo=? where num =? ";
		
		try {
			pstmt= conn.prepareStatement(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
