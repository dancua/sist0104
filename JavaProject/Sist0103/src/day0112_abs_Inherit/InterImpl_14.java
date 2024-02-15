package day0112_abs_Inherit;

interface InterA {
	// 미완 메서드
	public void singasong();

	public void draw();
}

/////////////////////
interface InterB extends InterA {
	public void playgame();

	public void write();

}

/////////////////////
class Imple implements InterB  { // implements InterA, InterB 도 가능

	@Override
	public void singasong() {
		System.out.println("노래를 부릅니다.");

	}

	@Override
	public void draw() {
		System.out.println("그림을 그립니다.");

	}

	@Override
	public void playgame() {
		System.out.println("게임을 합니다.");

	}

	@Override
	public void write() {
		System.out.println("공부를 합니다.");

	}
}
/////////////////////
public class InterImpl_14 {

	public static void main(String[] args) {
		// 하위클래스
		/*
		Imple im;
		im = new Imple();
		*/
		Imple im = new Imple(); 
		im.singasong();
		im.draw();
		im.playgame();
		im.write();

		//다형성
		InterB inb = new Imple();
		inb.draw();
		inb.singasong();
		inb.playgame();
		inb.write();
	}

}
