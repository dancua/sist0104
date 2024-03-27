package Semi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import mysql_db.DbConnect;

public class mainDao {
	
	DbConnect db = new DbConnect();
	
	public void MainInsert(mainDto dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into main values(null,?,?,?,?,?,?,?,?,now())";
		
		
		
	}

}
