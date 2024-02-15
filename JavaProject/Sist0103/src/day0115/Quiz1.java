package day0115;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Quiz1 {
	
	List<ShopArrayList> list = new Vector<ShopArrayList>();
	
	//입력메서드
	public void ipgo(){
		Scanner sc = new Scanner(System.in);
		String name;
		int su,dan;
		
		System.out.println("상품명?");
		name = sc.nextLine();
		System.out.println("가격?");
		su = Integer.parseInt(sc.nextLine());
		System.out.println("수량?");
		dan = Integer.parseInt(sc.nextLine());
		
		Quiz1 sp = new Quiz1();
		
		ShopArrayList data = new ShopArrayList(name,su,dan);
		list.add(data);
		System.out.println("현재 입고된 상품은"+ list.size() + "개 입니다.");
	
	}
	
	public void jego() {
		System.out.println("상품재고 현황");
		System.out.println();
		System.out.println("번호\t상품명\t상품가격\t수량\t총액");
		System.out.println("==================================================");
		for(int i = 0; i< list.size(); i++) {
			ShopArrayList b = list.get(i);
			System.out.println((i+1) +"\t"+ b.getSangName()+"\t"+ b.getDan() +"\t"+ b.getSu() +"\t"+ b.getTot() );
		}
	}

	public static void main(String[] args) {
		
			Quiz1 q = new Quiz1();
			Scanner sc = new Scanner(System.in);
			int n;
			
		while(true) {
			
		System.out.println("1.상품입고   2.상품재고   9.종료");
		n = Integer.parseInt(sc.nextLine());
		
		if(n==1)
			q.ipgo();
		else if(n==2)
			q.jego();
		else if(n==9) {
			System.out.println("종료합니다.");
			break;
			}
		}
	}
}
