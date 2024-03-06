package team.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mysql_db.DbConnect;

public class TeamDAO {
	
	DbConnect db = new DbConnect();
	
	public void insertTeam(TeamDTO dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into team (name,driver,addr,writeday) values(?,?,?,now())";
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getName());
			pstmt.setString(2,dto.getDriver());
			pstmt.setString(3, dto.getAddr());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//전체출력
	public ArrayList<TeamDTO> getAllTeams()
	{
		ArrayList<TeamDTO> list = new ArrayList<TeamDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from team order by num";
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				TeamDTO dto = new TeamDTO();
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setDriver(rs.getString("driver"));
				dto.setAddr(rs.getString("addr"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list에 추가
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
	
	//삭제
	public void deleteTeam(String num)
	{
		Connection conn =db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from team where num=?";
		
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
	
	//하나의 dto조회
	public TeamDTO getOneData(String num) {
		
		TeamDTO dto = new TeamDTO();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from team where num=?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setDriver(rs.getString("driver"));
				dto.setAddr(rs.getString("addr"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void updateTeam(TeamDTO dto) {
		
		Connection conn =db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update team set name=?,driver=?,addr=? where num=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getName());
			pstmt.setString(2,dto.getDriver());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4,dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		
		
	}

}
