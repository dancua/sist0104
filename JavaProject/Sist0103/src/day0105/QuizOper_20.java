package day0105;

import java.util.Scanner;

public class QuizOper_20 {

	public static void main(String[] args) {
		/* (상품을 5개 이상 구매시 10% 할인하여 계산된다.) 
		 * 상품명: 키보드
		 * 수량: 5
		 * 가격: 20000
		 * 
		 * ========================
		 * 5개이상 구매시 10% 할인됩니다.
		 * 키보드 5개는 총 90000원 입니다.
		 * 할인된 금액 : 10000원
		 *  
		 *  수량 * 가격 * 0.9
		 *  수량이 5개이상일때 
		 *  수량이 5개미만일때
		 */
		
		double total,sale;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("상품명: ");
		String name = sc.nextLine();
		System.out.print("수량: ");
		int count = sc.nextInt();
		System.out.print("가격: ");
		int bill = sc.nextInt();
		
		total = (count*bill);
		sale = total * 0.1;
	
		System.out.println("====================");
		System.out.println("5개이상 구매시 10% 할인됩니다.");
		if(count >= 5)
			total = total*0.9;
		else
			total = total;
		System.out.println(name + count + "개는 총 " + total + " 원 입니다.");
		if(count >= 5)
			System.out.println("할인된 금액: " + sale);
		else
			System.out.println("할인적용 안되었습니다.");
		
	}
}
