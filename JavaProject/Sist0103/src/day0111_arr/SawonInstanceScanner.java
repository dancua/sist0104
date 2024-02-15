package day0111_arr;

import java.util.Scanner;

/* getFamilySudang(0 : 가족수당 = 가족수 *50000(단 2인이상은 무조건 10만원)
 * getTimeSudang() : 시간수당 = 초과시간*3000(단 10시간 이상은 30만원으로 통일)
 * getTotalPay() : 실수령액 = 기본급 + 가족수당 + 시간수당
 * 
 * 메인에서는 인원수 입력후 해당사원에 대한 이름,기본급,가족수,시간수 입력받고 출력
 */

class Emp{
	private String sName; //사원명
	private int gPay; 	  //기본급여
	private int fSu;	 // 가족수 
	private int tSu;	//오버타임시간
	
	//명시적생성자
	public Emp(String name, int pay, int fs, int ts) {
		this.sName = name;
		this.gPay = pay;
		this.fSu = fs;
		this.tSu = ts;
	}
	//setter getter
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
	public int getfSu() {
		return fSu;
	}
	public void setfSu(int fSu) {
		this.fSu = fSu;
	}
	public int gettSu() {
		return tSu;
	}
	public void settSu(int tSu) {
		this.tSu = tSu;
	}
	
	public int getFamiltySudang() {
		//getFamilySudang(0 : 가족수당 = 가족수 *50000(단 2인이상은 무조건 10만원)
		int n = 0;
		if(fSu >= 2) {
			n = 100000;
		}else {
			n = 50000*fSu;
		}
		return n;
	}
	
	public int getTimeSudang() {
	//	getTimeSudang() : 시간수당 = 초과시간*3000(단 10시간 이상은 30만원으로 통일
		int n = 0;
		if(tSu >= 10) {
			n = 300000;
		}else {
			n = tSu * 3000;
		}
		return n;
	}
	
	public int getTotalPay() {
	// getTotalPay() : 실수령액 = 기본급 + 가족수당 + 시간수당
		int n = 0;
		n = gPay + getFamiltySudang() + getTimeSudang();
		return n;
	}
	
	//제목 
	public static void showTitle()
	{
		System.out.println("**쌍용 01월 직원 급여현황***");
		System.out.println();
		System.out.println("사원명\t기본급\t자녀수\t초과근무시간\t가족수당\t시간수당\t총급여");
		System.out.println("==========================================================");
	}
}

public class SawonInstanceScanner {

	public static void writeEmp(Emp[] emp) {
		//Emp if문 , Emp[] 배열 지정해서 호출 가능
		//제목부터 출력
		Emp.showTitle();
		for(Emp e : emp) {
			System.out.println(e.getsName()+ "\t" + e.getgPay() + 
					"\t" + e.getfSu() + "\t" + e.gettSu() + 
					"\t" +e.getFamiltySudang()+ "\t" +e.getTimeSudang()+ 
					"\t" + e.getTotalPay());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int inwon;
		Emp [] emp;
		
		System.out.println("입력할 직원수는?");
		inwon = Integer.parseInt(sc.nextLine());
		
		//배열할당
		emp = new Emp[inwon];
		
		// 인원수만큼 데이터 입력
		for(int i = 0; i < inwon; i++)
		{
	//		emp[i] = new Emp();
			
			System.out.println("이름");
			String name = sc.nextLine();
			System.out.println("기본급은?");
			int pay = Integer.parseInt(sc.nextLine());
			System.out.println("자녀수는?");
			int fs = Integer.parseInt(sc.nextLine());
			System.out.println("초과근무시간은?");
			int ts = Integer.parseInt(sc.nextLine());
			
			emp[i] = new Emp(name, pay, fs, ts);
			
			/*
			//setter로 emp클래스에 데이터 넣기
			emp[i].setsName(name);
			emp[i].setgPay(pay);
			emp[i].setfSu(fs);
			emp[i].settSu(ts);
			*/
			
			System.out.println();
		}
		//출력
		writeEmp(emp);
	}
}