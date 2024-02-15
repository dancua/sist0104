package Project;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;

import oracleDb.DBConnect;

//			 차 db 동작 
public class carDAO extends JFrame {
	
	DBConnect db = new DBConnect();
	
//	추가
	public boolean insert(carDTO dto) 
	{
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "insert into carManage values(car_info.nextval,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getC_name());		//차 이름
			pstmt.setString(2, dto.getCarImage());		// 차 사진
			pstmt.setInt(3,dto.getC_price());				// 차 가격
			pstmt.setDouble(4, dto.getC_fe());			// 차 연비
			pstmt.setString(5, dto.getC_fuel());			// 차 연료 
			pstmt.setString(6, dto.getC_level());			// 차 등급
			pstmt.setString(7,dto.getC_ap());				// 차 외형
			pstmt.setString(8, dto.getC_maintain());		//차 정비이력
		
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		return false;
	}
//	전체조회
	public Vector<carDTO> select() 
	{
		Vector<carDTO> list = new Vector<carDTO>();

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from carManage order by num";

		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();

			while(rs.next())
			{
//				db에서 하나의 레코드를 읽어서 dto에 넣는다.
				carDTO dto = new carDTO();

				dto.setNum(rs.getString("num"));
				dto.setC_name(rs.getString("c_name"));
				dto.setC_price(rs.getInt("c_price"));
				dto.setC_fe(rs.getDouble("c_fe"));
				dto.setC_fuel(rs.getString("c_fuel"));
				dto.setC_level(rs.getString("c_level"));
				dto.setC_ap(rs.getString("c_ap"));
				dto.setC_maintain(rs.getString("c_maintain"));
				dto.setCarImage(rs.getString("carImage"));

//				list에 dto추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
//	삭제
	public boolean delete(String num)
	{
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "delete from carManage where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		return false;	
	}
	 public boolean authenticate(String num, String c_name) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.getOracle();
	            String sql = "SELECT * FROM carManage WHERE num = ? and c_name = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, num);
	            pstmt.setString(2, c_name);
	            rs = pstmt.executeQuery();

	            return rs.next(); // ����� ������ ���� ����
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false; // ���� ����
	        }
	    }
	
	// 수정
	public boolean update(carDTO dto) {
	    Connection conn = db.getOracle();
	    PreparedStatement pstmt = null;

	    String sql = "update carManage set c_name=?, c_price=?, c_fe=?, c_fuel=?, c_level=?, c_ap=?, c_maintain=? where num=?";

	    try {
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, dto.getC_name());
	        pstmt.setInt(2, dto.getC_price());
	        pstmt.setDouble(3, dto.getC_fe());
	        pstmt.setString(4, dto.getC_fuel());
	        pstmt.setString(5, dto.getC_level());
	        pstmt.setString(6, dto.getC_ap());
	        pstmt.setString(7, dto.getC_maintain());
	        pstmt.setString(8, dto.getNum());  
	        
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pstmt, conn);
	    }
		return false;
	}
}