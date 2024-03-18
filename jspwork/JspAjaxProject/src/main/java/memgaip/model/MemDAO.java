package memgaip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql_db.DbConnect;

public class MemDAO {
	
	DbConnect db = new DbConnect();
	
	//아이디가 존재하면 true리턴
	public boolean isIdCheck(String m_id) {
		
		boolean b = false;
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from memgaip where m_id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				b= true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		return b;
	}
	
	
	public void insertMem(MemDTO dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into memgaip values(null,?,?,?,?,?,now())";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getM_id());
			pstmt.setString(2, dto.getM_pass());
			pstmt.setString(3, dto.getM_name());
			pstmt.setString(4, dto.getM_hp());
			pstmt.setString(5, dto.getM_photo());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);	
		}
	}
	public List<MemDTO> getAllDatas(){
		ArrayList<MemDTO> list = new ArrayList<MemDTO>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from memgaip order by m_id asc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				MemDTO dto = new MemDTO();
				
				dto.setM_num(rs.getString("m_num"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_pass(rs.getString("m_pass"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_hp(rs.getString("m_hp"));
				dto.setM_photo(rs.getString("m_photo"));
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
	public void deleteMem(String m_num) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from memgaip where m_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,m_num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
	}
	public boolean isEquals(String m_num,String m_pass) {
		
		boolean a = false;
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM memgaip WHERE m_num = ? AND m_pass = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num);
			pstmt.setString(2, m_pass);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1)==1)
				a = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return a;
	}
}
