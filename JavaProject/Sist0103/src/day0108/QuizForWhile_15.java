package day0108;

import java.util.Scanner;

public class QuizForWhile_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	test1();
		test2();
	//	test3();
	//	test4();
	}

	public static void test1() {
		// 문제: 1~100까지의 3의 배수 구하기
		/*
		int i = 0;
		int cnt = 0;
		for(i = 0; i <= 100; i++)
		{
			if(i%3==0)
				cnt++;
		}
		*/
		int n=0;
		int cnt=0;
		while(true)
		{
			n++;
			
			//3의 배수이면 cnt변수 1증가
			if(n%3==0)
				cnt++;
			
			//n이 100이면 while문 종료
			if(n==100)
				break;
		}
		System.out.println("3의 배수 갯수: " + cnt + " 개");
		
	}

	public static void test2() {
		// 1~100까지의 짝수 합구하기(while(true))
		int i = 0;
		int sum = 0;
		
		while(true)
		{
			i++;
			
			if(i%2==0)
				continue;
				sum += i;
			
			if(i==100)
				break;
		}
		System.out.println("짝수 합: "+ sum);
		/*
		while(true)
		{
			i++;
			
			if(i%2==1)
				continue; // 홀수면 첫줄로 이동
			sum+= i;
			
			if(i==100)
				break;
				
		}
		System.out.println("1~100까지의 짝수합: "+ sum);
		*/
		
	}

	public static void test3() {
		//for문 이용 1~100까지의 홀수합 구하기

		int i = 0;
		int sum = 0;
		
		for(i = 0; i <= 100; i+=2)
		{
			sum+= i;
		}
		System.out.println("1~100까지의 홀수 총합계: "+ sum);
		
	}
	public static void test4() {
		/*
		 * (1~100까지만 입력가능) 총 5개의 점수를 입력받아 합계 구하기
		 * 1번 점수:90
		 * 2번 점수: -70
		 * 			잘못 입력했어요
		 * 2번 점수: 85
		 * 3번 점수: 120
		 * 		잘못입력했어요
		 * 3번 점수: 88
		 * 4번 점수: 98
		 * 5번 점수: 75
		 * 총점: ***
		 */
		Scanner sc = new Scanner(System.in);
		/*
		int i = 0;
		int score;
		
		System.out.println("총 5개의 점수를 입력하세요.");
		System.out.println("1번 점수: ");
		int a = sc.nextInt();
		System.out.println("2번 점수: ");
		int b = sc.nextInt();
		System.out.println("3번 점수: ");
		int c = sc.nextInt();
		System.out.println("4번 점수: ");
		int d = sc.nextInt();
		System.out.println("5번 점수: ");
		int e = sc.nextInt();
		
		
		for(i = 0; i<=100; i++)
		{
			if(a<0 || a >=100)
				System.out.println("잘못입력했어요");
		}
		*/
		int sum = 0;
		int score = 0;
		
		for(int i = 1; i<=5; i++) {
			System.out.println(i+"번 점수: ");
			score = sc.nextInt();
			
			if(score<1 || score>100)
			{
				System.out.println("\t잘못 입력했어요");
				i--; // 잘못 입력한거 횟수 제외
				continue; // i++ 로 이동
			}
			sum += score;
		}
		System.out.println("총점: "+ sum);
		
	}
	
}
