package day0112_abs_Inherit;

//클래스를 객체 생성할때는 자동으로 부모=> 자식순 그래야 자식이 부모의 멤버를 사용할 수 있기 때문
public class Manager_04 extends Employee_04 {

	String depart;
	public Manager_04(String name, int sal,String d) {
		super(name, sal);  //부모생성자 호출
		this.depart = d;  //초기화
	}
	//재정의된 메서드_하위클래스에서 부모클래스의 메서드를 수정해서 사용하는 것
	//상속이 전제조건(Override), 메서드명,메서드 리턴타입이 동일해야함
	@Override
	public String getEmployee() {
		// TODO Auto-generated method stub
		return super.getEmployee()+","+depart;
	}

}
