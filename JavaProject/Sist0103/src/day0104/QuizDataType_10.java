package day0104;

public class QuizDataType_10 {

	public static void main(String[] args) {
		// 변수는 args를 이용(변수는 5개 0~4까지 선언)
		/*
		 * 학생명 : 김선호 님 지역 : 부산 나이 23세
		 * 
		 * ================================================ 
		 * 김선호님의 자바점수는 88점 오라클점수는 77점 총 165점입니다.
		 * 
		 */

		// 1.변수선언 2. 계산 3. 출력
/*
		String name = "김선호";
		String area = "부산";
		int age = 23;
		int java = 88;
		int oracle = 77;
		int result = java + oracle;

		System.out.printf("학생명 : %s님 \n 지역 : %s \n 나이 : %d세 \n %s님의 자바점수는 %d점 오라클점수는 %d점 총 %d점입니다.", name, area, age,
				name, java, oracle, result);
*/
		/*
		String name = args[0];
		String area = args[1];
		int age = Integer.parseInt(args[2]);
		int java = Integer.parseInt(args[3]);
		int oracle = Integer.parseInt(args[4]);
		int result = java + oracle;
		
		System.out.println("학생명:" + args[0]);
		System.out.println("지역 :" + args[1]);
		System.out.println("나이 :" + args[2]);
		System.out.println("=======================");
		System.out.println(args[0] + "님의 자바점수는" + args[3] + "점 오라클점수는" + args[4] + "점 총" + result +"점 입니다.");
		*/
		
		// 1. 변수선언 실행단계에서 문자열을 읽어서 변수에 저장
		
		
		String name = args[0];
		String city = args[1];
		String age = args[2];
		int java = Integer.parseInt(args[3]);
		int oracle = Integer.parseInt(args[4]);
		
		// 2. 계산
		int result = java + oracle;
		
		// 3. 출력
		System.out.println("학생명 :" + name);
		System.out.println("지역 :" + city);
		System.out.println("나이 :" + age + "세");
		System.out.println("김선호님의 자바점수는 " + java + "점 오라클점수는 " + oracle + " 점 총" + result + "점 입니다.");
	}


}
