package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dto.MemberDto;
import mysql_db.DbConnect;

public class MemberDao {

	DbConnect db = new DbConnect();
	
	//아이디 체크
	
	public int idCheck(String id) {
		
		int isId = 0;
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from member where id =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				/*
				 * if(rs.getInt(1)==1) isId = 1;
				 */
				isId = rs.getInt(1);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return isId;
	}
	
	public void insertMember(MemberDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(null,?,?,?,?,?,?,now())";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPass());
			pstmt.setString(4, dto.getHp());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getEmail());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);	
		}
	}

	public List<MemberDto> getAllDatas(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member order by ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				MemberDto dto = new MemberDto();
				
			dto.setNum(rs.getString("num"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setPass(rs.getString("pass"));
			dto.setHp(rs.getString("hp"));
			dto.setAddr(rs.getString("addr"));
			dto.setEmail(rs.getString("email"));
			dto.setGaipday(rs.getTimestamp("gaipday"));
			
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
	
}
