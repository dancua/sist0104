package day0112_abs_Inherit;

//interface는 상수,추상메서드만 가질수 있다.
//class가 class를: extends 
//class가 interface를 : implements (구현한다.)
//interface가 interface를 : extends 
interface FoodShop{

	String SHOPNAME ="남소관"; // 상수? final 생략
	
	public void order(); // 추상메서드들이다 abstract 생략
	public void bedal();
}
/////////////////////
class Food2 implements FoodShop{

	@Override
	public void order() {
		
		// SHOPNAME = "남소"; 상수이므로 수정안됨
		System.out.println("음식을 주문합니다.");
		
	}

	@Override
	public void bedal() {
		System.out.println("음식을 배달합니다.");
	}
	
}
/////////////////////
class Food3 implements FoodShop{

	@Override
	public void order() {
	System.out.println("키오스크 주문");
		
	}

	@Override
	public void bedal() {
		System.out.println("쿠팡이츠 배달");
		
	}
	
}

public class Implement_13 {

	public static void main(String[] args) {
		FoodShop fs;
		fs = new Food2();
		fs.order();
		fs.bedal();
		
		fs = new Food3();
		fs.order();
		fs.bedal();
		
		

	}

}
