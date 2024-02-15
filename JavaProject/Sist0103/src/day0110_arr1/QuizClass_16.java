package day0110_arr1;

class Mart{
	private String sangpum;
	int su;
	int dan;
	static String SHOPNAME="롯데마트";
	
	//sangpum은 메서드가 아니면 다른클래스에서 접근불가
	//su,dan은 private이 아니므로 다른 클래스에서 생성시 변수접근 가능
	//static은 다른클래스에서 접근시 클래스명.변수명으로 접근 가능
	
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	public static String getSHOPNAME() {
		return SHOPNAME;
	}
	public static void setSHOPNAME(String sHOPNAME) {
		SHOPNAME = sHOPNAME;
	}
}
public class QuizClass_16 {
	
	/*
	 * 생성후 초기값 준후 출력 
	 * 상점명: 롯데마트 입고물품
	 * ==========================================
	 * 상품명 : 쵸코파이 
	 * 수량: 10개 
	 * 가격: 4500원 
	 * ------------------------
	 * 상품명: 엄마손파이
	 * 수량:5개
	 * 가격:2500원
	 */
	public static void main(String[] args) {
		// su,dan이 접근 불가능 할때 코드 
		/*
		Mart mart1 = new Mart();
		Mart mart2 = new Mart();
		
		  mart1.setSangpum("쵸코파이");
		  mart1.setSu(10);
		  mart1.setDan(4500);
		  
		  mart2.setSangpum("엄마손파이");
		  mart2.setSu(5);
		  mart2.setDan(2500);
		  
		  String name1 = mart1.getSangpum();
		  int su1 = mart1.getSu();
		  int dan1 = mart1.getDan();
		  
		  String name2 = mart2.getSangpum();
		  int su2 = mart2.getSu();
		  int dan2 = mart2.getDan();
		  
		  
		  System.out.println(Mart.SHOPNAME+ " 입고물품");
		  System.out.println("====================");
		  System.out.println("상품명 :" + name1 +"\n수량" + su1 + "개\n가격: "+ dan1+"원");
		  System.out.println("--------------------");
		  System.out.println("상품명 :" + name2 +"\n수량" + su2 + "개\n가격: "+ dan2+"원");
*/
		// su,dan 이 접근 가능할 때 코드
			Mart m1 = new Mart();
			m1.setSangpum("쵸코파이");
			m1.su = 10;
			m1.dan = 4500;
			
			Mart m2 = new Mart();
			m2.setSangpum("엄마손파이");
			m2.su = 5;
			m2.dan = 2500;
			
			System.out.println("***"+Mart.SHOPNAME + "입고상품***");
			System.out.println("=============================");
			System.out.println("상품명: "+m1.getSangpum() + "\n수량: "+ m1.su + "개\n가격: " + m1.dan +"원" );
			System.out.println("-----------------------------");
			System.out.println("상품명: "+m2.getSangpum() + "\n수량: "+ m2.su + "개\n가격: " + m2.dan +"원" );
			
	}

}
