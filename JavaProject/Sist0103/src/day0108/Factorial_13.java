package day0108;

import java.util.Scanner;

public class Factorial_13 {

	public static void main(String[] args) {
		// 1~10까지의 팩토리얼 구하기
		
		Scanner sc = new Scanner(System.in);
		int result = 1;
/*		
		for(int i = 1; i<= 10; i++)
		{
			result*=i;
			System.out.println(i+"!"+result);
			
			*/
			//Q. 합계를 구할 숫자를 입력시 1부터 여러분이 입력한 숫자까지의 합을 구허시오
			int migisu;
			int sum = 0;
			System.out.println("숫자를 입력하세요.");
			migisu = sc.nextInt();
			
			for(int e = 1; e<=migisu; e++) {
				sum += e;
				System.out.println(sum);
			
			}
			
		}

	}


