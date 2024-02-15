package day0109;

import java.util.Scanner;

public class Quiz_16 {
	
	public static void main(String[] args) {
		
		quiz1();
	//	quiz2();
	//	quiz3();
		
	}
	public static void quiz1() {
		/*
		팩토리얼 구할 숫자를 입력하여 해당숫자에 대한 팩토리얼 구하기 

		팩토리얼 구할 숫자 입력
		5
		5!= 120
		*/
		
		Scanner sc = new Scanner(System.in);
		int result = 1;
		
		System.out.println("숫자를 입력하세요.");
		int fac = sc.nextInt();
		
		for(int i = 1; i <= fac; i++)
		{
			result *= i; // result *= i;
		}
		System.out.println(fac +"! 은"+ result + "입니다.");
		
		/*
		Scanner sc = new Scanner(System.in);
		int su,result = 1;
		
		System.out.println("숫자 입력");
		su = sc.nextInt();
		
		for(int i = 1; i <= su; i++)
		{
			result *= i;
		}
		System.out.println(su + "!" + result);
		*/
		
	}
	public static void quiz2() {
		/*
		 * 두수 x,y,를 입력후 x의 y승 for문을 이용하여 구하시오(x를 y횟수만큼 곱하는것)
		 * 
		 * 두수 입력
		 * 
		 * 3   3
		 * 
		 * 3의 3승은 27입니다.
		 */
		Scanner sc = new Scanner(System.in);
		int x,y;
		int result = 1;
		
		System.out.println("x를 입력하세요");
		x = sc.nextInt();
		System.out.println("y를 입력하세요");
		y = sc.nextInt();
		
		for(int i = 1; i <= y; i++)
		{
			result *= x;
		}
		System.out.printf("%d 의 %d 승은 %d 입니다",x,y,result);
		
	}

	public static void quiz3() {
		/*
		 *  1~100까지의 숫자중 짝수의 합과 홀수의 합을 나눠서 출력
		 * 
		 */
		int esum = 0; // 짝수를 구할변수
		int osum = 0; // 홀수를 구할변수
		
		for(int i = 1; i <= 100; i++)
		{
			if(i%2==0) 
			{
				esum += i;
			}else {
				osum += i;
			}
		}
		System.out.printf("짝수 합: %d\n홀수 합: %d",esum,osum);
	}
}
