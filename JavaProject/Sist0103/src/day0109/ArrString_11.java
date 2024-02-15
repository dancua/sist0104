package day0109;

public class ArrString_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//문자열 배열
		String [] str1 = {"텀블러","키보드","핸드크림","칫솔","우산"};
		String [] strColors = {"red","pink","blue","yellow","gray","white"};

		//str1은 1번째: 텀블러 
		
		//strColors 0번째색 : red
		
		System.out.println("str1_출력1_for문");
		for(int i =0; i<str1.length; i++)
		{
			System.out.printf((i+1) +"번째: "+ str1[i]);
		}
		System.out.println();
		
		System.out.println("strColors_출력2_foreach문");
		for(int i = 0; i < strColors.length; i++)
		{
			System.out.print((i+1)+"번째색: " + strColors[i]);
		}
		System.out.println();
	
	for(String a : strColors)
	{
		System.out.print(a);
	}
	}
}


