package day0109;

public class ForStar_02 {

	public static void main(String[] args) {
		
	//	quiz_1();
	//	quiz_2();
		quiz_3();
		
	}
		// TODO Auto-generated method stub
		
		public static void quiz_1() {
		System.out.println("**다중 for문으로 star 출력하기**");
		
		for(int i = 1; i<=5; i++) // 행갯수
		{
			for(int j =1; j<=5; j++) // 열갯수
			{
				System.out.print("*");
			}
			System.out.println();
		}

	}
		public static void quiz_2() {
			System.out.println("**다중 for문으로 star 삼각형 출력");
			
			for(int i = 1; i <= 5; i++)
			{
				for(int j = 1; j <= i; j++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
		public static void quiz_3() {
				System.out.println("**다중 for문으로 star 역삼각형 출력");
			
			for(int i = 1; i <= 5; i++)
			{
				for(int j = i; j <= 5; j++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
}
