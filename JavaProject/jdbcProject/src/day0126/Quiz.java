package day0126;

import oracleDb.DBConnect;
import java.sql.*;
import java.util.Scanner;

public class Quiz {

	DBConnect db = new DBConnect();
	
	public void insert() {
		
		Scanner sc = new Scanner(System.in);
		String name,gender,hp;
		int age;
		String sql = "";
		
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		System.out.println("성별을 입력하세요.");
		gender = sc.nextLine();
		System.out.println("나이를 입력하세요");
		age = Integer.parseInt(sc.nextLine());
		System.out.println("연락처를 입력하세요");
		hp = sc.nextLine();
		
		sql = "insert into stuinfo values(seq_info.nextval, ' "+name+" ',' "+gender+" ',' "+age+" ',' "+hp+" ',sysdate)";
		System.out.println(sql);
		
		Connection conn = null;
		
		Statement stmt = null;
		
		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("정보 입력 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}
	}
	
	public void select() {
		System.out.println("시퀀스\t학생명\t성별\t나이\t연락처\t\t가입날짜");
		System.out.println("-------------------------------------------------------------");
		String sql = "select * from stuinfo order by s_name";
		
		Connection conn = null;
		Statement stmt = null;	
		ResultSet rs = null;
		
		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("s_no")+"\t"+rs.getString("s_name") + "\t" + rs.getString("s_gender") 
				+"\t" +  rs.getInt("s_age")+ "\t" + rs.getString("s_hp") +"\t"+ rs.getDate("gaipday") );
			}
			System.out.println("정보 조회 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs,stmt, conn);
		}
	}
	public void delete() {
	
	Scanner sc = new Scanner(System.in);
	int num;
	String sql ="";
	
	System.out.println("삭제할 시퀀스를 입력하세요");
	num  = sc.nextInt();
	
	sql = "delete from stuinfo where s_no ="+ num;
	System.out.println(sql);
	
	Connection conn = null;
	Statement stmt = null;
	
	conn = db.getOracle();
	
	try {
		stmt = conn.createStatement();
		int a = stmt.executeUpdate(sql);
		
		if( a == 0) {
			System.out.println("번호 다시 확인해주세요");
		}else {
			System.out.println("삭제 되었습니다.");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(stmt, conn);
	}
	
}
	public boolean sDate(String num) {
		boolean flag = false;
		
		String sql = "select * from stuinfo where s_no = "+num;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) 
				flag = true;
			else 
				flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, stmt, conn);
		}
		return flag;
	}
	
	public void update() {
		
	Scanner sc = new Scanner(System.in);
	String n;
	int age;
	String name,gender,hp,sql;
	
	
	System.out.println("수정할 시퀀스를 입력하세요.");
	n = sc.nextLine();
	
	if(!this.sDate(n))
	{
		System.out.println("해당 번호는 없습니다.");
		return;
	}
	
	System.out.println("변경할 이름을 입력하세요");
	name = sc.nextLine();
	
	System.out.println("변경할  성별을 입력하세요");
	gender = sc.nextLine();
	
	System.out.println("변경할 나이를 입력하세요.");
	age = Integer.parseInt(sc.nextLine());
	
	System.out.println("변경할 연락처를 입력하세요");
	hp = sc.nextLine();
	
sql  = "update stuinfo set s_name =' "+name+" ',s_gender =' "+gender+" ',s_age =' "+age+" ',s_hp =' "+hp+" 'where s_no = "+n;
	System.out.println(sql);
	
	Connection conn = null;
	Statement stmt = null;
	
	conn = db.getOracle();
	
	try {
		stmt = conn.createStatement();
		int a = stmt.executeUpdate(sql);
		
		if(a == 0)
			System.out.println("데이터가 없습니다.");
		else 
			System.out.println("정보 수정 완료");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(stmt, conn);
	}
}
	
	public void search() {
	Scanner sc = new Scanner(System.in);
	String n,sql;
	
	boolean flag = false;
	
	System.out.println("검색할 이름를 입력하세요.");
	n = sc.nextLine();
	
	sql = "select * from stuinfo where s_name like '%" + n + "%' order by s_no";
//	System.out.println(sql);
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	conn = db.getOracle();
	
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		System.out.println("시퀀스\t학생명\t성별\t나이\t연락처\t\t가입날짜");
		System.out.println("-------------------------------------------------------------");
		
		while(rs.next()) {
			String name = rs.getString("s_name");
			if(name.contains(n)) {
				flag = true;
			System.out.println(rs.getInt("s_no")+"\t"+rs.getString("s_name") + "\t" + rs.getString("s_gender") 
			+"\t" +  rs.getInt("s_age")+ "\t" + rs.getString("s_hp") +"\t"+ rs.getDate("gaipday") );
			}
		}
		if(!flag) {
			System.out.println("해당 이름에 대한 정보가 없습니다.");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(rs, stmt, conn);
	}
}
	
	
	public static void main(String[] args) {
		Quiz q = new Quiz();
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(true)
		{
			System.out.println("학생정보시스템");
			System.out.println("1.학생정보입력   2.정보출력   3.정보삭제    4.학생정보 수정   5.학생검색   9.종료");
			n = Integer.parseInt(sc.nextLine());
			
			if(n==1)
				q.insert();
			else if(n==2)
				q.select();
			else if(n==3)
				q.delete();
			else if(n==4)
				q.update();
			else if(n==5)
				q.search();
			else if(n==9) {
				System.out.println("프로그램 종료");
				 break;
			}
		}
	}
}
