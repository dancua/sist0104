package day0109;

import java.util.Scanner;

public class WhileReview_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 반복적으로 나이를 입력한다 0이되면 종료
		 * 나이가 50세 이상일 경우 a변수 증가 
		 * 나이가 30세 이상이면 b변수 증가
		 * 그이외는 c변수 증가
		 * 
		 * 빠져나온후 출력내용
		 * 50세이상 : 3명
		 * 30세이상 : 2명
		 * 그외 : 3명
		 */
	int a = 0;
	int b = 0;
	int c = 0; 
	Scanner sc= new Scanner(System.in);
	
	while(true)
	{
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		
		if(age >= 50) {
			a++;
		}else if(age >= 30) {
			b++;
		}else if(age == 0) {
			break;
		}else
			c++;
	}
	System.out.printf(" 50세 이상: %d명\n 30세 이상: %d명\n 그외: %d명",a,b,c);
		
	}
}
