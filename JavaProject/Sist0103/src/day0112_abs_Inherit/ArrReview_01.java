package day0112_abs_Inherit;

import java.util.Scanner;

class Food {

	private String foodName;
	private int fPrice;

	static int no;

	// 명시적생성자(2개)
	public Food(String name, int price) {
		this.foodName = name;
		this.fPrice = price;
	}
	// 출력문
	public void run() {
		no++;
		System.out.println("[메뉴_" + no + "]");
		System.out.println("음식명: "+ foodName);
		System.out.println("가격: "+ fPrice);
	}
	/*
	 * [메뉴_1] 
	 * 음식명: 마르게리타 피자 
	 * 가격: 12000원 
	 * -------------------- 
	 * [메뉴_2] 
	 * 음식명: 까르보나라 스파게티
	 * 가격:15000원 
	 * --------------------- 
	 * [메뉴_3] 
	 * 음식명:리코타 샐러드 
	 * 가격: 9000원
	 * 
	 * 
	 */
}
public class ArrReview_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		int fMenu;
		
		System.out.println("추가할 메뉴 갯수는? ");
		fMenu = Integer.parseInt(sc.nextLine());
		
		System.out.println("음식명: ");
		String name = sc.nextLine();
		System.out.println("가격: ");
		int price = Integer.parseInt(sc.nextLine());
		*/
		
		/*
		Food food1 = new Food("마르게리타 피자",12000);
		food1.run();
		Food food2 = new Food("까르보나라 스파게티",15000);
		food2.run();
		Food food3 = new Food("리코타 샐러드",9000);
		food3.run();
		*/
		
		Food [] food = new Food[3];
		
		food[0] =  new Food("마르게리타 피자",12000);
		food[1] =  new Food("까르보나라 스파게티",15000);
		food[2] =  new Food("리코타 샐러드",9000);
		
		for(int i = 0; i<food.length; i++)
		{
			Food f = food[i];
			f.run();
			
			// food[i].run();
			System.out.println("-------------");
			for(Food e : food)
			{
				e.run();
			}
		}
		
	}

}
