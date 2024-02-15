package day0115;

interface InterAA{
	
	public void play();
}
//class ClassA{	
//////////////////////
interface InterBB {
	
	public void draw();
}
///////////////////////
class InterImple_01 implements InterAA,InterBB{

	@Override
	public void draw() {
		System.out.println("나는 그림을 그린다.");
	}

	@Override
	public void play() {
		System.out.println("나는 게임을 한다.");
		
	}
}
public class InheritReview_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InterImple_01 impl = new InterImple_01();
		impl.draw();
		impl.play();
		
		System.out.println("**다형성으로 출력**");
		InterImple_01 impl2;
		impl2 = new InterImple_01();
		impl2.draw();
		
		InterImple_01 impl3;
		impl3 = new InterImple_01();
		impl3.play();
		
	}
	

}
