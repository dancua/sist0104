package day0112_abs_Inherit;
/*
 * **디폴트 생성자로 생성**
 * 회사명: 현대
 * 종류: 전기차
 * 자동차명: 아이오닉5
 * 색상: 블랙
 * 가격: 35000000
 * 
 * **명시적 생성자로 생성**
 * 회사명: 기아
 * 종류: 가솔린
 * 자동차명: 코나
 * 색상: 화이트
 * 가격: 25000000
 * 
 */

class Car {
	
	private String carCompany; // 제조회사
	private String carKind; // 종류

	public Car() {
		super();
	}
	
	public Car(String comp, String kind) {
		this.carCompany = comp;
		this.carKind = kind;
	}
	
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarKind() {
		return carKind;
	}
	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}
	public void writeCar() {
		System.out.println("회사명: "+ carCompany);
		System.out.println("차 종류: "+ carKind);
	}
}
	
class MyCar extends Car {
	private String carName;
	private String carColor;
	private int carPrice;
	
	public MyCar() {
		super();
		carName = "아이오닉5";
		
	}
	public MyCar(String comp, String kind ,String name, String color, int price) {
		super(comp, kind);
		this.carName = name;
		this.carColor = color;
		this.carPrice = price;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	//메서드
	@Override
	public void writeCar() {
		// TODO Auto-generated method stub
		super.writeCar();
		
		System.out.println("자동차명: "+ carName);
		System.out.println("색상: " + carColor);
		System.out.println("가격: " + carPrice);
	}
}

public class Inheri_08 {

	public static void main(String[] args) {
		
		System.out.println("**디폴트 생성자로 생성**");
		MyCar car1= new MyCar();
		car1.setCarCompany("현대");
		car1.setCarKind("전기차");
		car1.setCarColor("블랙");
		car1.setCarPrice(3500000);
		car1.writeCar();
		
		System.out.println("**명시적 생성자로 생성**");
		MyCar car2 = new MyCar("기아","가솔린","코나","화이트",250000000);
		car2.writeCar();
		
		System.out.println("**부모 메서드 출력**");
		Car c1 = new Car();
		c1.writeCar();
	}

}
