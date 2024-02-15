package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracleDb.DBConnect;

public class QuizJdbc {
	
	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);
	
	public void process() 
	{
		while(true) {
			System.out.println("1. 사원등록   2.사원 전체출력  3.사원 삭제   4.사원 수정   5.이름검색  9.종료");
			int n = Integer.parseInt(sc.nextLine());
		
		switch(n)
		{
			case 1: 
				this.insert();
				break;
			case 2:
				this.writeMember();
				break;
			case 3:
				this.delete();
				break;
			case 4:
				this.update();
				break;
			case 5:
				this.seacrh();
				break;
			case 9:
				System.out.println("프로그램 종료");
				System.exit(0);
		}
		}
	}
	
	public void insert() {
		
		System.out.println("사원명은?");
		String name = sc.nextLine();
		System.out.println("부서는?");
		String buseo = sc.nextLine();
		System.out.println("직급은?");
		String position = sc.nextLine();
		System.out.println("성별은?");
		String gender = sc.nextLine();
		System.out.println("월급여는?");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스는?");
		int bonus = Integer.parseInt(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "insert into sawonMember(s_no,s_name,buseo,position,gender,pay,bonus,ipsaday) "
				+ "values(seq_smem.nextval,?,?,?,?,?,?,sysdate)";
		
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,name);
				pstmt.setString(2, buseo);
				pstmt.setString(3, position);
				pstmt.setString(4, gender);
				pstmt.setInt(5, pay);
				pstmt.setInt(6, bonus);

				pstmt.execute();
				System.out.println("사원 등록 완료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("사원 등록 실패");
			}finally {
				db.dbClose(pstmt, conn);
			}
	}
	public void writeMember()
	{
		System.out.println("사원번호  사원명    부서  직급\t성별\t     월급여\t보너스");
		System.out.println("-------------------------------------------------------");
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			String sql= "select s_no,s_name,buseo,position,gender,to_char(pay,'L999,999') pay,to_char(bonus,'L999,999') bonus from sawonMember ";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					System.out.println(rs.getInt("s_no") +"\t"+ rs.getString("s_name") +"\t"+
					rs.getString("buseo") +"\t"+rs.getString("position") +"\t"+ rs.getString("gender")
					 +rs.getString("pay")+rs.getString("bonus"));					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs,pstmt, conn);
				
			}	
	}
	public void delete() {
		
		System.out.println("삭제할 사원번호를 입력하세요");
		int n = Integer.parseInt(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
	
		
		String sql = "delete from sawonMember where s_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n);
			
			int num  = pstmt.executeUpdate();
			
			if(num == 1)
				System.out.println("삭제 성공");
			else
				System.out.println(n +"번은 없는 번호입니다.");
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void update() {
		
		System.out.println("수정할 사원번호를 입력하세요.");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 부서를 입력하세요");
		String buseo = sc.nextLine();
		System.out.println("수정할 직급을 입력하세요");
		String position= sc.nextLine();
		System.out.println("수정할 급여를 입력하세요");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 보너스를 입력하세요");
		int bonus = Integer.parseInt(sc.nextLine());
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		
		String sql = "update sawonMember set buseo = ?, position = ?, pay = ?, bonus = ? where s_no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
//			바인딩
			pstmt.setString(1,buseo);
			pstmt.setString(2, position);
			pstmt.setInt(3, pay);
			pstmt.setInt(4, bonus);
			pstmt.setInt(5, num);
			
			int n = pstmt.executeUpdate();
			
			if(n != 1)
				System.out.println(num + "번은 없는 번호입니다.");
			else
				System.out.println("수정완료");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
			
		}
		
		
	}
	
	public void seacrh()
	{
		System.out.println("검색할 이름을 입력하세요");
		String name = sc.nextLine();
		
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select s_name,buseo,position,gender,to_char(pay,'L999,999') pay,to_char(bonus,'L999,999') bonus from  sawonMember where s_name like ?";
		
		try {
			System.out.println("사원이름  부서\t직급\t성별\t월급여\t보너스");
			System.out.println("----------------------------------------------------");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+name+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
		System.out.println(rs. getString("s_name") + "\t" + rs.getString("buseo")
		 + "\t" + rs.getString("position") + "\t" + rs.getString("gender") + 
				rs.getString("pay") +rs.getString("bonus"));		 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,pstmt, conn);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizJdbc p = new QuizJdbc();
		p.process();
	}

}
