package day0105;

import java.util.Calendar;
import java.util.Scanner;

public class QuizMyAgeInOut_08 {
	
	public static void main(String[] args) {
		/*
		 * 당신의 이름은? ==> 이수연
		 * 당신이 태어난 연도는 ==> 1988
		 * 당신이 사는 지역은? ==> 경기
		 * 
		 * ==========================
		 * [이수연 님의 개인정보]
		 * ==========================
		 * 이름: 이수연
		 * 태어난년도: 1988
		 * 나이: **세
		 * 지역: 경기
		 */
		
		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		String name;
		int curYear,myBirthYear, myAge;
		String area;
		
		System.out.print("당신의 이름은? ==>");
		name = scan.nextLine();
		System.out.print("당신이 태어난 연도는 ==>");
		myBirthYear = Integer.parseInt(scan.nextLine());
		//Integer.parseInt("1988)= 1980 : String -> Int
		// scan.nextLine() 는 키보드의 버퍼나 엔터를 먼저읽어서 없애준다.
		System.out.print("당신이 사는 지역은? ==>");
		area = scan.nextLine();
		
		// 4. 계산
		curYear = cal.get(cal.YEAR); // 2024
		myAge = curYear - myBirthYear;
		
		System.out.println("=======================");
		System.out.println("["+name+"님의 개인정보]");
		System.out.println("=======================");
		System.out.println("이름: " + name);
		System.out.println("태어난년도: "+ myBirthYear );
		System.out.println("나이: " + myAge + "세");
		System.out.println("나이: " + area);
		
		
		
	}
}
