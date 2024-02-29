package quiz.model;

import quiz.model.quizDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import info.model.InfoDto;
import oracle.db.DbConnect;

public class quizDao {
	
	DbConnect db = new DbConnect();
	
	public void infoInsert(quizDto dto)
	{
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into quizinfo values(seq2_nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1,dto.getName());
			pstmt.setString(2, dto.getHp());
			pstmt.setString(3, dto.getAge());
			pstmt.setString(4, dto.getDriver());
			//업데이트
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		
	}
	public Vector<quizDto> infoSelect(){
		
		Vector<quizDto> list=new Vector<quizDto>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from quizinfo where num = ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				quizDto dto = new quizDto();
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setHp(rs.getString("hp"));
				dto.setAge(rs.getString("age"));
				dto.setDriver(rs.getString("driver"));
				dto.setSdate(rs.getTimestamp("sdate"));
//			백터에 추가	
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
	public void infoDelete(String num) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from quizinfo where num = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public quizDto getData(String num) {
		
		quizDto dto = new quizDto();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from quizinfo where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setName(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setHp(rs.getString("hp"));
				dto.setAge(rs.getString("age"));
				dto.setDriver(rs.getString("driver"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,pstmt, conn);
		}
		return dto;
	}
	
	public void infoUpdate(quizDto dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update quizinfo set name =?,age =?,hp=?,driver=? where num =?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getDriver());
			pstmt.setString(5, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
}
