package day0108;

import java.util.Scanner;

public class Quiz_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	quiz_1();
		quiz_2();
	}

	public static void quiz_1() {
		/*
		 * Q. 반복해서 숫자를 입력하여 양수의 갯수와 음수의 갯수를 구하시오(0입력시 종료) 
		 * while(true)문 사용 
		 * 6 -10 88 120 -130 0 
		 * 양수의 갯수 : 3개 음수의 갯수 : 2개
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int count;
		int yangSum = 0;
		int EmSum = 0;
		
		while(true) {
			System.out.println("숫자를 입력하세요.");
			count = sc.nextInt();
			
			if(count > 0) {
				yangSum++;
			}else if(count == 0) {
				break;
			}else {
				EmSum++;
			}
		}
			
		System.out.printf("양수의 갯수: %d   음수의 갯수: %d", yangSum,EmSum);
	}

	public static void quiz_2() {
		Scanner sc = new Scanner(System.in);
		// 반복해서 점수를 입력하고 (1~100) 0을 입력시 빠져나와 갯수와 합계를 구하시오
		// 범위에 맞지않는 점수는 횟수에서 제외되어야 한다.
		int count;
		int sum = 0;
		int cnt = 0;
		
		while(true) {
			System.out.println("숫자를 1~100사이에서 입력하세요.");
			count = sc.nextInt();
			
			if(count >= 1 && count <= 100) {
				cnt++; 
				sum += count;
			}else if(count == 0) {
				break;
			}else {
				System.err.println("다시 입력해주세요.");
				continue;
			}
		}
		System.out.printf("갯수: %d   합계: %d",cnt,sum);
	}
		
		/*
		int cnt,sum = 0;
		
		while(true) { 
			System.out.println("점수입력");
			int su = sc.nextInt();
			
			if(su==0)
				break;
			
			if(su<1 || su >100)
			{
				System.out.println("\t다시 입력바람");
				continue;
			}
			cnt++;
			sum+=su;
		}
		avg =(double)sum/cnt;
		
		System.out.println("총갯수: %d  총점:  %d",cnt,sum);
}
	*/
	public static void quiz_3() {

	}

}

