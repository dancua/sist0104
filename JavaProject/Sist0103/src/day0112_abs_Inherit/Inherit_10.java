package day0112_abs_Inherit;

//부모 클래스
class Work{
	
	public void goodmorning()
	{
		System.out.println("좋은 아침입니다.");
	}
	
	public void proc()
	{
		System.out.println("아무것도 안하고 있음.");
	}
}
///////////////////
//자식 클래스
class Food1 extends Work{
	
	@Override
	public void proc() {
		System.out.println("***음식당담***");	
	}
}
//////////////////////
class Clean extends Work{
	
	@Override
	public void proc() {
		System.out.println("***청소담당***");
	}
}
//////////////////////
class Sing extends Work{
	@Override
	public void proc() {
		System.out.println("***노래담당***");
	}
}

public class Inherit_10 {

	public static void main(String[] args) {
		//다형성
		//부모클래스로 선언하고 자식클래스로 생성하는 경우
		Work work = null; //선언
		work = new Food1(); // 생성
		
		work.goodmorning();
		work.proc();
		System.out.println();
		
		work = new Clean();
		work.goodmorning();
		work.proc();
		System.out.println();
		
		work = new Sing();
		work.goodmorning();
		work.proc();
	
	
	}
	
}
