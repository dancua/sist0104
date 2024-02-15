package day0108;

import java.util.Scanner;

public class YoonYear_03 {

	public static void main(String[] args) {
		//1. 연도가 4로 나누어 떨어지면 윤년이다. ==> 4로 나누어 나머지가 0
		//2. 연도가 100으로 나누어 떨어지면 윤년이 아니다. 
		//3. 연도가 400으로 나누어 떨어지면 윤년이다.
		
		//연도 입력후 평년인지 윤년인지 구분
		
		Scanner sc = new Scanner(System.in);
		int year;
		
		System.out.println("입력연도");
		year=sc.nextInt();
		
		if(year%4 == 0 && year%100!= 0 || year%400 == 0)
			System.out.println(year +"는 윤년입니다.");
		else 
			System.out.println(year + "는 평년입니다.");

	}

}
