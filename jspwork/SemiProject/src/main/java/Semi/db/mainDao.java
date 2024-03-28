package Semi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mysql_db.DbConnect;

public class mainDao {
	
	DbConnect db = new DbConnect();
	
	public void MainInsert(mainDto dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into main values(null,?,?,?,?,?,?,?,?,?,?,now())";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4, dto.getHp());
			pstmt.setInt(5, dto.getPostcode());
			pstmt.setString(6,dto.getAddr());
			pstmt.setString(7,dto.getAddrDetail());
			pstmt.setString(8,dto.getEmail());
			pstmt.setString(9, dto.getBirthday());
			pstmt.setString(10, dto.getGender());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		
	}
	//전체 출력
	public List<mainDto> getAllDatas(){
		
		List<mainDto> list = new ArrayList<mainDto>();
		
		return list;
	}
	

}
