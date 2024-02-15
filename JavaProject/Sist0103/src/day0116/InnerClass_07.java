package day0116;

class OuterObject{
	int a =10;
	static int b = 20;
	
	class InnerObject{
		int c= 30;
		
		public void write() {
			System.out.println("외부 인스턴스 변수 a="+a);
			System.out.println("외부 정적변수 b="+b);
			System.out.println("내부 인스턴스 변수c="+c);
		}
	}
	static class InnerObject2{
		
		//내부 클래스에서 멤버를 static으로 선언하고 싶으면 내부클래스 타입을 static으로 주면 된다.
		int d = 40;
		static int e = 50;
		
		public void write2() {
			//System.out.println("외부 인스턴스 변수 a="+a); //외부일반변수 접근 안됌
			System.out.println("외부 정적변수 b="+b);
			System.out.println("내부 일반변수 d="+d);
			System.out.println("내부 정적변수 e="+e);
		}
	}
}

public class InnerClass_07 {

	public static void main(String[] args) {
		OuterObject.InnerObject inobj =new OuterObject().new InnerObject();
		inobj.write();
		
		OuterObject.InnerObject2 inobj2 =new OuterObject.InnerObject2();
		inobj2.write2();
	}

}
