package day0108;

import java.util.Scanner;

public class QuizFor_12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 1.
		
		System.out.println("**1. 1  2  4  5  7  8  10(continue활용)**");
		int i = 0;
		for(i = 1; i <= 10; i++)
		{
			if(i%3==0)
				continue;
			System.out.print(i+ " ");
		}
		System.out.println();
		
		System.out.println("2. 홀수값:1 홀수값:3 홀수값:5 홀수값:7 홀수값:9");

		for(i = 0; i<= 10; i++) {
			if(i%2==1)
				System.out.print(i+" ");
		}
		System.out.println();
		int sum =0;
		int score;
		System.out.println("3. 점수 입력후 합계 구하는데 0을 입력하면 빠져나와서 합계출력_while(true)");
		/*
		while(true) 
		{
		System.out.println("점수를 입력하세요.");
		score = sc.nextInt();
			if(score != 0)
				sum += score;
			else
			System.out.println("합계: "+ sum);
		}
		*/
		/*
		while(true) {
			System.out.println("점수를 입력하세요.");
			score = sc.nextInt();
			
			if(score ==0)
				break;
			
			sum+= score;
		}
		System.out.println("총합계: "+ sum);
		*/
	}

}
