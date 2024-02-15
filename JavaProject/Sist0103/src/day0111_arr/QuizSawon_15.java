package day0111_arr;

/*
 * 회사이름 : 쌍용
 * 총사원수 입력
 * 2 
 * 사원명 : 손흥민
 * 월급여 : 2500000
 * 월수당 : 500000
 * 
 * [쌍용_ 1월 급여내역]
 * 사원명 	기본급	수당	실수령액
 * ===============================
 * 손흥민		2500000	500000	2700000
 * 황희찬 	1500000 500000	1800000
 * 
 * ex) 실수령액 = 기본급 + 수당 *10%(pure = (pay + su) *0.1;
 */
class Sawon{
	private String sName; // 사원명
	private int gPay; 	// 월급여
	private int gSu;	// 월수당	
	static String comment; 	// 회사이름
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getgPay() {
		return gPay;
	}
	public void setgPay(int gPay) {
		this.gPay = gPay;
	}
	public int getgSu() {
		return gSu;
	}
	public void setgSu(int gSu) {
		this.gSu = gSu;
	}
	public static String getComment() {
		return comment;
	}
	public static void setComment(String comment) {
		Sawon.comment = comment;
	}
	
	public double purePay() {
		double n = 0;
		n = (gPay + gSu)*0.1; 
		return n;
	}
	public static void showTitle()
	{
		System.out.println("[쌍용_ 1월 급여내역]");
		System.out.println();
		System.out.println("사원명\t\t기본급\t수당\t실수령액");
		System.out.println("=========================================");
	}
}
public class QuizSawon_15 {
	
	public static void writeSw(Sawon[] sw) {
		//Emp if문 , Emp[] 배열 지정해서 호출 가능
		//제목부터 출력
		Sawon.showTitle();
		for(Sawon e : sw) {
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
