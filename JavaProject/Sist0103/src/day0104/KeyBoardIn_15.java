package day0104;

import java.util.Scanner;

public class KeyBoardIn_15 {
	
	public static void main(String[] args) throws Exception {
		//이름,국,영,수 점수를 입력하고 결과출력해보기
		
		// 1. import 
	Scanner scan = new Scanner(System.in);
	
	//변수는 미리 선언하거나 입력할때 주어도된다.
		// 2. 변수선언
	
	String stuName;
	int kor,eng,mat;
	int tot;
	double avg;
	
	//입력
	System.out.println("학생명?");
	stuName = scan.nextLine();
	System.out.println("국 영 수 점수 입력");
	kor = scan.nextInt();
	eng = scan.nextInt();
	mat = scan.nextInt();
	
	// 계산
	tot = kor + eng + mat;
	avg = tot/3.0;
	
	//최종출력 
	System.out.println("===========================");
	System.out.println("학생명: "+stuName);
	System.out.println("국어: " +kor );
	System.out.println("영어: " +eng );
	System.out.println("수학: " +mat );
	System.out.println("합계: " +tot );
	System.out.println("평균: " +avg );
	
/*
	System.out.print("x 값 입력");
	String strX = scan.nextLine();
	int x = Integer.parseInt(strX);
	
	System.out.print("Y 값 입력");
	String strY = scan.nextLine();
	int y = Integer.parseInt(strY);
	
	int result = x + y;
	System.out.println("x + y" + result);
	System.out.println();
	
	while(true) { 
		System.out.print("입력 문자열: ");
		String data = scan.nextLine();
		if(data.equals("q")) { 
			break;
		}
		System.out.println("출력 문자열:" + data);
		System.out.println();
		
		}
	System.out.println("종료");
	*/
	}
	
	}


