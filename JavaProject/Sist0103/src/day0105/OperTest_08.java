package day0105;

import java.util.Scanner;

public class OperTest_08 {
	
	public static void main(String[] args) {
		//신체검사를 하는데 이름과 키,몸무게 입력하면
		// 표준몸무게 출력(키-110)*0.9...표준몸무게는 소수점한자리로 출력
		/*
		 * 당신의 이름? 이효리
		 * 키? 165
		 * 몸무게? 55 
		 * 
		 * 이효리님의 표준몸무게는 55키로 입니다.
		 * 
		 * 
		 */
		
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 이름?");
		String name = sc.nextLine();
		System.out.println("당신의 키?");
		double tall = sc.nextDouble();
		
		double weight = (tall - 110)*0.9;
		
		System.out.printf(name +"님의 표준 몸무게는 %.1f 키로 입니다.",weight);
		*/
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		double my_height,my_weight,st_weight;
		
		System.out.println("당신의 이름은?");
		name = sc.nextLine();
		System.out.println("당신의 키는?");
		my_height = sc.nextDouble();
		System.out.println("당신의 몸무게는?");
		my_weight =sc.nextDouble();
		
		//표준
		st_weight = (my_height - 100)*0.9;
		
		//출력
		System.out.printf("%s님의 표준몸무게는 %.1f 키로 입니다.",name,st_weight);
		
		
	}

}
