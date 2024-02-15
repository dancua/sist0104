package day0110_arr1;

import java.util.Scanner;

public class ArraySearchName_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		String [] names = {"홍길동","이길동","삼길동","사길동","오길동","육길동","칠길동","팔길동","구길동"};
		String name;
		boolean flag;
		
		while(true) {
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		
		if(name.equalsIgnoreCase("q")) {
			System.out.println("프로그램 종료");
			break;
		}
		
		flag = false;
		
		for(int i = 0; i < names.length; i++)
		{
			if(name.equals(names[i])) 
			{
				flag = true;
				System.out.println((i+1)+"번째에서 검색");
			}
		}
		if(!flag) {
			System.out.println(name+ "은 데이터에 없음");
		}
		}
	}
}