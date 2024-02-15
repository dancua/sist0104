package day0108;

public class For_07 {
	
	public static void main(String[] args) {
		//while문과 for문 비교
		
		System.out.println("**while문으로 10~0출력**");
		int i=10;
		
		while(i>=0)
		{
			System.out.println(i--+" ");
		}
		
		System.out.println("**for문으로 10~0출력**");
		for(int a=10; a >=0; a--)
		{
			System.out.println(a+ " ");
		}
		
		System.out.println("** for문으로 1~10 종료**");
		for(int a= 1; a <= 10; a++)
		
			System.out.print(a +" ");
			System.out.println("종료");
			
			System.out.println("**while문 1~10 종료**");
			int s = 1;
			while(true)
			{
				System.out.print(s++ +" " );
				if(s > 10)
					break;
			}
			System.out.println("종료");
			
			System.out.println("** for문 1,4,7,10**");
			for(int q = 1; q <= 10; q+=3) {
				System.out.print(q +" ");
			}
			System.out.println("종료");
			
			System.out.println("** for문 5,4,3,2,1**");
			for(int b = 5; b >= 1; b--) {
				System.out.print(b+ " ");
			}
			System.out.println("종료");
			
			System.out.println("** while문 5,4,3,2,1**");
			int d = 5;
			while(true) {
				System.out.print(d-- + " ");
				if(d <= 0)
				break;
			}
			
			System.out.println("종료");
			
			/*
			System.out.println("for문 HelloJava 를 5번 반복");
			for(i = 0; i < 5; i++) {
				System.out.print("HelloJava"+ "  ");
			}
			*/
			
			int e;
			for(e=1;e<=5;e++)
			{
				System.out.print("HelloJava"+ " ");
			}
			
	}
}
