package day0112_abs_Inherit;

import java.util.Scanner;

/*	콘솔창의 결과물 한장만 카톡으로 보낼것!!
	클래스명은 QuizMain으로 만들어주세요
	멤버클래스명은 Quiz 라고 만드세요
	메인메서드에서 학교이름 입력받아 schoolName에 넣고  인원수 입력받아서 인원수만큼 
	이름,Java,Oracle,Html 점수를 입력한후 
	총점,평균,평가 메서드를 만들어 구현하세요
	getTotal(),getAverge(),getPyungga() 
	평가는 90점이상: 장학생   80점이상: 합격  80점미만:불합격임 

	다음과 같이 구현할것
 * 학교명: 쌍용교육센터

	이름	 JAVA	ORACLE	HTML  총점	평균		평가
	=============================================
	홍현희  90    80	    70	  240	 80	     합격
	남현희  80	60	    50    190   63.5     불합격 
 */
class Quiz{
	
	String name; // 이름
	int java; // 자바점수
	int oracle; // 오라클점수
	int html; // html 점수
	static String SCHOOL = "쌍용교육센터";
	
	public Quiz(String name, int j, int o, int h) {
		this.name = name;
		this.java = j;
		this.oracle = o;
		this.html = h;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getOracle() {
		return oracle;
	}
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	
	
	public int getTotal() {
		int n;
		n = (java + oracle + html);
		return n;
	}

	public int getAverge() {
		int n;
		
		n = getTotal()/3;
		return n;
	}
	public int getPyungga() {
		if(getAverge() >= 90) {
			System.out.println("장학생");
		}else if(getAverge() >= 80) {
			System.out.println("합격");
		}else 
			System.out.println("불합격");
		return 0;
	}
	
	void showTitle() {
		{
			System.out.println("학교명: "+ SCHOOL);
			System.out.println();
			System.out.println("이름\tJAVA\tORACLE\tHTML\t총점	\t평균\t평가");
			System.out.println("=========================================");
		}
	}	
}

public class QuizMain {
		
		public static void writeData(Quiz[] arr) {
			// Quiz.showTitle
		
			System.out.println();

		}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int inwon;
		
		Quiz [] arr; 
		
		System.out.println("학교명 입력: ");
		String schoolName = sc.nextLine();

		System.out.println("평가할 인원수 입력");
		inwon =Integer.parseInt(sc.nextLine()); 
		
		arr = new Quiz[inwon]; // 배열 할당
				
		for (int i = 0; i < inwon; i++) {
			System.out.println("이름을 입력하세요.");
			String name = sc.nextLine();
			System.out.println("자바 점수는?");
			int java =Integer.parseInt(sc.nextLine()); 
			System.out.println("오라클 점수는?");
			int oracle = Integer.parseInt(sc.nextLine()); 
			System.out.println("HTML 점수는?");
			int html =Integer.parseInt(sc.nextLine()); 
		}
	}
}
