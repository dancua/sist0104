package day0112_abs_Inherit;
//추상 클래스
//추상클래스는 new 로 생성못함
//abstract메서드는 abstract  클래스에서만 존재 가능
//abstract 클래스는 일반메서드 추상메서드 둘다 포함 가능

//부모 
abstract class Fruit {
	
	public static final String MESSAGE = "오늘은 추상클래스 배우는날~";
	
	//일반 메서드
	public void showTitle() {
		System.out.println("일반메서드 입니다.");
	}
	
	//추상 메서드(미완의 메서드,구현부가 없다.)..오버라이딩이 목적
	abstract public void showMessage();
	
}
/////////////////////////
class Apple extends Fruit{

	@Override
	public void showMessage() {
		System.out.println(Fruit.MESSAGE);
		System.out.println("Apple_Message");
		
	}
	
}
////////////////////////////
class Banana extends Fruit {

	@Override
	public void showMessage() {
		System.out.println("Banana_Message");
		
	}
}
////////////////////////////////
class Orange extends Fruit{

	@Override
	public void showMessage() {
		System.out.println("Orange_Message");
		
	}
}
public class Abstract_11 {

	public static void main(String[] args) {
		//일반생성출력(자식으로 선언,자식으로 생성)
		Apple ap = new Apple();
		ap.showMessage();
		
		Banana bn = new Banana();
		bn.showMessage();
		
		Orange or = new Orange();
		or.showMessage();
		
		//다형성출력(부모로 선언,자식으로 생성)_장점은 변수가 하나 
		Fruit fr1;
		fr1 = new Apple();
		fr1.showMessage();
		fr1.showTitle();
		
		fr1 = new Banana();
		fr1.showMessage();
		
		fr1 = new Orange();
		fr1.showMessage();
		
//		Fruit fr = new Fruit();

	}

}
