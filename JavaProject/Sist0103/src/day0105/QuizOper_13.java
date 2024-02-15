package day0105;

import java.util.Scanner;

public class QuizOper_13 {

	public static void main(String[] args) {
		// 3개의 숫자를 입력하여 가장 큰 값 max값을 구하시오
		// if 문, 삼항연산자 
		Scanner sc = new Scanner(System.in);
		
		int a,b,c;
		int max;
		
		System.out.println("3개의 숫자를 입력하세요.");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		
		// if문
		/*
		if(a > b && a > c) 
			System.out.println(a +"가 가장큽니다");
		else if(b > a && b > c) 
			System.out.println(b +"가 가장큽니다.");
		else if(c > a && c > b)
			System.out.println(c + "가 가장큽니다.");
		else
			System.out.println("숫자가 똑같습니다.");
		 */
		
		//삼항연산자
		// max = ( a > b && a > c)?
		
		
		System.out.println("**if문**");
		if(a>b && a>c)
			max =a;
		else if(b>a && b>c)
			max = b;
		else 
			max =c;
		
		System.out.println("max=" +max);
		
		System.out.println("**조건연산자**");
		max = a>b&&a>c?a:b>a&&b>c?b:c;
		System.out.println("max=" +max);
		
	}

}
