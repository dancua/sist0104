package day0105;

import java.util.Scanner;

public class KeyBoardIn_01 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 1. 변수 선언
		String name,hp,addr;
		
		// 2. 입력
		System.out.println("이름을 입력하세요");
		name = scan.nextLine();
		System.out.println("핸드폰 번호 입력하세요.");
		hp = scan.nextLine();
		System.out.println("주소를 입력하세요.");
		addr = scan.nextLine();
		
		// 최종출력
		System.out.println("=================");
		System.out.println("이름: " + name + " 님");
		System.out.println("핸드폰: " + hp );
		System.out.println("주소지: " + addr );
		
	}

}
