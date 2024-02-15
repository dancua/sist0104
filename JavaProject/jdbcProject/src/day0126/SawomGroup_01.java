package day0126;

import java.sql.*;

import oracleDb.DBConnect;

public class SawomGroup_01 {
	
	DBConnect db = new DBConnect();
	
	public void connectSawonGroup() 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select gender, count(buseo) count, to_char(round(avg(pay),0),'L999,999,999') avgpay, "
				+ "to_char(max(pay),'L999,999,999') maxpay, to_char(min(pay),'L999,999,999') minpay from sawon group by gender";
		
		conn = db.getOracle();
		System.out.println("오라클 계정연결성공");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("\t***회사 남녀별 급여통계\t");
			System.out.println();
			System.out.println("성별\t인원수\t평균급여\t\t최고급여\t최저급여");
			System.out.println("---------------------------------------------------------------------------");
			while(rs.next()) {
				String gender = rs.getString("gender");
				int count = rs.getInt("count");
				String avgpay = rs.getString("avgpay");
				String maxpay = rs.getString("maxpay");
				String minpay = rs.getString("minpay");
				
				System.out.println(gender + "\t" + count  +avgpay +  maxpay +  minpay);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		
	}
	
 public void personGroup() 
 {
//	 job별 인원수와 평균나이 구하기
	 Connection conn = null;
	 Statement stmt = null;
	 ResultSet rs = null;
	 
	 String sql ="select job , count(*) count , avg(age) avgage from person group by job";
	 
	 conn = db.getOracle();
	 
	 try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		System.out.println("\t***회사 직업별 인원수와 평균나이***\t");
		System.out.println();
		System.out.println("직업\t인원수\t\t평균나이");
		System.out.println("-----------------------------------------------------------");
		
		while(rs.next()) {
		String job = rs.getString("job");
		int count = rs.getInt("count");
		double age = rs.getDouble("avgage");
		
		System.out.println(job + "\t" + count + "\t" + age);
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
 }
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SawomGroup_01 sg  = new SawomGroup_01();
		sg.personGroup();
		
	}

}
