package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracleDb.DBConnect;

public class jdbcPstmt_01 {
	
	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);
	
	public void insertSangpum()
	{
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("type?");
		String type = sc.nextLine();
		System.out.println("상품명?");
		String sang = sc.nextLine();
		System.out.println("수량?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가?");
		int dan = Integer.parseInt(sc.nextLine());
		
//		PreparedStatement는 미완의 sql문을 작성할 수 있다.
//		변수를 ?로 표시후 나중에 바인딩 시켜주면 된다.
		String sql = "insert into sales values(seq1.nextval,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
//			?를 순서대로 바인딩한후 업데이
			pstmt.setString(1, type);
			pstmt.setString(2, sang);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			
//			업데이트 
			int n	= pstmt.executeUpdate();
			if(n==1)
				System.out.println("인서트 성공");
			else
				System.out.println("인서트 실패");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	public void writeSangpum()
	{
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sales order by num";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			System.out.println("시퀀스\t카테고리\t상품명\t수량\t단가\t입고일");
			System.out.println("--------------------------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t" + rs.getString("type")
				 + "\t" +rs.getString("sangpum")
				 + "\t" +rs.getInt("su")
				 + "\t" +rs.getInt("dan")
				 + "\t" +rs.getDate("ipgo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
	}
	public void deleteSangpum()
	{
//		삭제...시퀀스번호로 삭제
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("삭제할 시퀀스는?");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from sales where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
//			바인딩
			pstmt.setInt(1, num);
			
			int n = pstmt.executeUpdate();
			
			if(n == 1)
				System.out.println("삭제성공");
			else
				System.out.println("삭제실패");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
//	수정...num을 인자로 받아서 데이터로 있다면 true 없으면 false
	public boolean isOneDate(String num)
	{
		
		boolean  b= false;
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql = "select * from sales where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next())
					b= true;
			else 
				b = false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return b;
	}
	
//		수정..시퀀스 입력후 수정할데이터 수정
	public void updateSagnpum() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		System.out.println("수정할 시퀀스 번호?");
		String num = sc.nextLine();
		
//		여기에서 isOneDat()를 호출해서 그번호가 존재하는지 확인
		if(!this.isOneDate(num)) {
			
			System.out.println("해당번호는 존재하지 않습니다.");
		return; //메서드 종료
	}
	
		System.out.println("수정할 상품명");
		String sang = sc.nextLine();
		System.out.println("수정할 수량");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 단가");
		int dan = Integer.parseInt(sc.nextLine());
		
		String sql = "update sales set sangpum =?, su = ? , dan =? where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
//			4개 ? 를 순서대로 바인딩
			pstmt.setString(1, sang);
			pstmt.setInt(2, su);
			pstmt.setInt(3, dan);
			pstmt.setString(4, num);
			
//			업데이트 
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
	}
	public void searchSangpum()
	{
		System.out.println("검색할 이름을 입력하세요(일부)");
		String sang = sc.nextLine();
		
		String sql = "select num,sangpum,su,dan from sales where sangpum like ?";
		
		System.out.println("시퀀스\t상품명\t수량\t단가");
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
//			바인딩
			pstmt.setString(1, "%"+sang+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t"+ rs.getString("sangpum") + "\t"+
				rs.getInt("su") + "\t"+ rs.getInt("dan"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		jdbcPstmt_01 sales = new jdbcPstmt_01();
		Scanner sc = new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("***상품입고***");
			System.out.println("1상품추가  2.상품전체출력  3.상품삭제  4.상품수정 5.검색(이름일부)  9.종료");
			
			System.out.println("선택할 메뉴는?====>");
			n = Integer.parseInt(sc.nextLine());
			
			if(n==1)
				sales.insertSangpum();
			else if(n==2)
				sales.writeSangpum();
			else if(n==3)
				sales.deleteSangpum();
			else if(n==4)
				sales.updateSagnpum();
			else if(n ==5)
				sales.searchSangpum();
			else if(n==9)
			{
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

}
