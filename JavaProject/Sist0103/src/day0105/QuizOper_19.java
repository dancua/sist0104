package day0105;

import java.util.Scanner;

public class QuizOper_19 {

	public static void main(String[] args) {
		/*
		 * (평가 90점 이상은 잘함 80점 이상은 좀더 노력하세요 80점 미만 불합격
		 * 이름을 입력하세요
		 * 손흥민
		 * 국,영,수 점수를 입력하세요
		 * 88
		 * 99
		 * 77
		 * 
		 * =========================
		 * [손흥민 님의 기말고사 성적]
		 * 총점: **점
		 * 평균: **.*점
		 * 평가: 좀더 노력하세요
		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 ==>");
		String name = sc.nextLine();
		System.out.print("국,영,수 점수를 입력하세요 ==>");
		int gu = sc.nextInt();
		int eng = sc.nextInt();
		int mat = sc.nextInt();
		
		int tot = (gu + eng + mat);
		double mean = tot / 3.0;
		
		if(mean >= 90)
			System.out.println("");
			
		System.out.println("========================");
		System.out.printf("[%s님의 기말고사 성적]\n",name);
		System.out.println("총점: " + tot);
		System.out.printf("평균: %.1f\n",mean);
		if(mean >= 90)
			System.out.println("잘함");
		else if(mean < 90 && mean >= 80)
			System.out.println("좀더 노력하세요");
		else 
			System.out.println("불합격");
	
	}
}
