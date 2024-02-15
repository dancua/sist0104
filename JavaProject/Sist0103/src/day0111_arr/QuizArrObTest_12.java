package day0111_arr;

/*
 * 이름	MBTI	나이
 * =====================
 * 이효리	ENTP	26세
 * 이상순	ISFJ	33세
 * 이영자	ENFJ	28세
 * 
 */
class MyInfo{
	
	private String name;
	private String mbti;
	private int age;

	public MyInfo(String name, String mbti, int age) {
		this.name = name;
		this.mbti = mbti;
		this.age = age;
	}
	public static void showTitle() 
	{
		System.out.println("이름\tMBTI\t나이");
		System.out.println("-------------------");
	}

	public void run() {
		System.out.println(name + "\t" + mbti + "\t" + age + "세");
		
	}
}
public class QuizArrObTest_12 {

	public static void main(String[] args) {
		
		MyInfo [] info = new MyInfo[3];
				
			info[0] = new MyInfo("이효리","ENTP",26);
			info[1] = new MyInfo("이상순","ISFJ",33);
			info[2] = new MyInfo("이영자","ENFJ",28);
			
		MyInfo.showTitle();
		for(MyInfo info1 : info)
			info1.run();
			
	}

}
