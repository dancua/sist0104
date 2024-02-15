package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizJdbcFoodOrder {
	
	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public void foodshop()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select j.order_num , f.fno 주문번호 , j.order_name , f.food_name , f.price , f.shop_name ,f.shop_loc ,j.order_addr  from foodshop f,jumun j where f.fno = j.fno";		
			try {
				conn =DriverManager.getConnection(URL, "stu", "a1234");
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				System.out.println("***배달 현황판***");
				System.out.println("주문번호    음식번호\t주문자\t음식명\t\t가격\t상호명\t상점위치\t주문자위치");
				System.out.println("----------------------------------------------------------------------------------------");
				while(rs.next()) 
				{
					int order_num = rs.getInt("order_num");
					int fno = rs.getInt("주문번호");
					String order_name = rs.getString("order_name");
					String food_name = rs.getString("food_name");
					int price = rs.getInt("price");
					String shop_name = rs.getString("shop_name");
					String shop_loc = rs.getString("shop_loc");
					String order_addr = rs.getString("order_addr");
					
					System.out.println(order_num + "\t\t" + fno + "\t" + order_name + "\t\t" + food_name + "\t" + price + "\t" + shop_name + "\t\t" + shop_loc + "\t" + order_addr);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizJdbcFoodOrder ct = new QuizJdbcFoodOrder();
			ct.foodshop();
	}

}
