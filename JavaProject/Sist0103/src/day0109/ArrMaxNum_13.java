package day0109;

public class ArrMaxNum_13 {

	public static void main(String[] args) {
		/*
		 * 
		 * 
		 */
		int [] data = {12,5,7,96,45,30,47,61,83};
		
		System.out.println("갯수: "+ data.length);
		
		int max = data[0]; // 첫데이터를 무조건 최대값에 지정
		int min = data[0]; 
		
		//두번째 데이터 부터 끝까지 max와 비교
		for(int i= 1; i < data.length; i++)
		{
			if(max<data[i])
				max=data[i];
			
			if(min>data[i])
				min = data[i];
		}
		System.out.printf("최대값: %d  최소값: %d",max,min);
		
	}

}
