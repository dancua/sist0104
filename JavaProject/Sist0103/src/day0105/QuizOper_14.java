package day0105;

import java.util.Scanner;

public class QuizOper_14 {

	public static void main(String[] args) {
		/*
		 * (점수에 대한 조건은 90점 이상: 매우잘함 80점 이상 잘함 
		 * 이름 입력
		 * 김민아
		 * 자바시험점수 입력
		 * 88
		 * 
		 * =======================
		 * 김민아님의 시험결과는 잘함 입니다.
		 * =======================
		 */

		String name,result;
		int score;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 입력하세요");
		name = sc.nextLine();
		System.out.println("점수를 입력하세요");
		score = sc.nextInt();
		
		/*
		if(score >= 90)
			result = "매우 잘함";
		else if(score >= 80)
			result = "잘함";
		else if(score >= 70)
			result = "노력할것";
		else 
			result = "꽝!!";
		*/
		result = score>=90?"매우 잘함":score>=80?"잘함":score>=70?"노력할것":"꽝";
		
		System.out.println("=======================");
		System.out.println(name + "님의 시험평가는 " + result + " 입니다");
		System.out.println("=======================");
		
		
		
	}

}
