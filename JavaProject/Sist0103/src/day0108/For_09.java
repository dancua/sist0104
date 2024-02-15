package day0108;

public class For_09 {

	public static void main(String[] args) {
		// 가로로 1~10까지 출력 

		int i = 0;
		
		System.out.println("**가로 1~10 출력 결과**");
		for(i = 1; i <= 10; i++)
		{
			System.out.print(i+ " ");
		}
		System.out.println("종료");

		System.out.println("**가로 10~1 출력 결과**");
		//10~1까지 출력
		int e = 10;
		while(true)
		{
			System.out.print(e-- + " ");
			if(e < 1 )
				break;
		}
		System.out.println("종료");

		//배수, continue
		for(i = 5; i <= 50; i+=5)
		{
			System.out.print(i+ " ");
		}
		System.out.println("종료");
		
		for(i =1; i<=20; i++)
		{
		//5의 배수 빼고 출력
			if(i%5 == 0)
				continue; //continue아래 문장은 수행하지 않고 i++로 이동 (증감식으로 이동한다)
			System.out.print(i+ " ");
		}
		
		
	}

}
