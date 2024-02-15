package day0104;

public class book65_13 {

	public static void main(String[] args) {
		// 교재 65p 
		//실행단계에서 상품명, 수량, 단가를 입력한후 다음과 같이 출력
		/*
		 * 상품명 : 아이폰15
		 * 수량 : 2
		 * 단가 : 1200000원
		 * 총금액 : 2400000원 
		 */
		/*
		// 1. 변수선언
		String name = args[0];
		int count = Integer.parseInt(args[1]);
		int bill = Integer.parseInt(args[2]);
		
		// 2.계산
		int tot = count * bill;
		
		// 3.출력
		System.out.println("상품명 : " + args[0]);
		System.out.println("수량 : "  + args[1]);
		System.out.println("단가 : " + args[2] + "원");
		System.out.println("총금액 : " + tot + "원");
		*/
		
		// 1. 변수선언
		String sangName = args[0];
		int count = Integer.parseInt(args[1]);
		int price = Integer.parseInt(args[2]);
		
		// 2. 계산
		int total = count * price;
		
		// 3. 출력
		System.out.println("상품명: " + args[0]);
		System.out.println("수량: " + count + " 개");
		System.out.println("단가: " + price+ " 원");
		System.out.println("총금액: " + total + " 원");
		
	}
}
