package day0104;

import java.util.Scanner;

public class KeyBoardIn_14 {
	
	public static void main(String[] args) {
		//키보드 입력에 필요한 Scanner 클래스를 import 
		
		// 1. import 
		Scanner scan = new Scanner(System.in);
		
		// 2. 변수선언
		String name;
		int age;
		
		
		// 3. 입력
		System.out.print("이름 입력 ==>");
		name = scan.nextLine(); //한둘을 문자로 읽어온다(공백사용가능)
		
		System.out.print("나이 입력 ==>");
		//age = scan.nextInt(); // 숫자로 읽어온다.
		//숫자입력후 엔터누르면 그엔터가 키보드 버퍼로 저장되어 다음문자열 읽을때 먼저 읽어버리는 현상발생
		//그래서 다음문자열 읽기전에 그엔터읽어 없애기 ... sc.nextLine();
		age = Integer.parseInt(scan.nextLine());
		
		System.out.println("당신이 사는 지역은? ");
		String city = scan.nextLine();
		
		// 4. 최종출력
		System.out.println(name + "님의 나이는 " + age + "세 이고 " + city + " 지역에 삽니다.");
		
	}

}
