package day0109;

import java.util.Scanner;

public class StringIn_01 {

	public static void main(String[] args) {
			// 반복적으로 이름을 입력해서 김씨가 몇명인지?...끝이라고하면 종료
		
		Scanner sc = new Scanner(System.in);
		String name;
		int cnt = 0;
		
		while(true)
		{
			System.out.println("이름입력(종료:끝)");
			name = sc.nextLine();
			
			//break
			if(name.equals("끝"))
				break;
			
			//조건
			//startsWith : 첫 글자를 인식 endsWith : 마지막 글자를 인식
			if(name.startsWith("김"))
				cnt++;
		}
		System.out.printf("김씨성을 가진 사람은 총 %d 명입니다.",cnt);
	}

}
