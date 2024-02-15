package day0105;

import java.util.Scanner;

public class book114_21 {
	
	public static void main(String[] args) {
		
		//int score = 75;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요.");
		int score = sc.nextInt();
		
		if(score>=90) {
			System.out.println("점수가 100~90입니다.");
			System.out.println("등급은 A입니다.");
		}
		else if(score>=80) {
			System.out.println("점수가 80~89입니다.");
			System.out.println("등급은 B입니다.");
		}
		else if(score>=70) {
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C입니다.");
		}
		else if(score>=80) {
			System.out.println("점수가 70 미만입니다.");
			System.out.println("등급은 D입니다.");
		}
		}

	}


