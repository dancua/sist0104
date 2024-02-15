package day0112_abs_Inherit;
/*
 * [쌍용매장 입고상품]
 * =================
 * 번호		상품명	가격		색상
 * 1		요가매트	25000원	핑크	
 * 2		아령		30000원	블랙
 * 3 		레깅스	45000원	베이지
 * 4		나시		22000원	화이트
 */

class Shop{
	String sangpum;
	String sColor;
	int sPrice;
	
	static int cnt;
	static String shopName;
	
	public Shop(String name, int price, String color) {
		this.sangpum = name;
		this.sPrice = price;
		this.sColor = color;
	}

	public static void showTitle() {
		System.out.println("["+shopName+"입고상품]");
		System.out.println("번호\t" + "상품명\t" + "가격\t" + "색상\t");
		System.out.println("===============================");
	}
	public void run()
	{
		cnt++;
		System.out.println(cnt+"\t"+ sangpum+"\t"+sPrice+"\t"+sColor);
	}
}

public class ArrReview_02 {

	public static void main(String[] args) {
		
		Shop.shopName = "쌍용매장";
		/*
		Shop sp1 = new Shop("요가매트",25000,"핑크");
		Shop sp2 = new Shop("아령",30000,"블랙");
		Shop sp3 = new Shop("레깅스",45000,"베이지");
		Shop sp4 = new Shop("나시",22000,"화이트");
		 */
		
		Shop [] sp = {
				 new Shop("요가매트",25000,"핑크"),
				 new Shop("아령",30000,"블랙"),
				 new Shop("레깅스",45000,"베이지"),
				 new Shop("나시",22000,"화이트")
		};
		Shop.showTitle();
		for(Shop e : sp)
		{
			e.run();
		}
		for(int i = 0; i < sp.length; i++)
		{
				sp[i].run();
		}

	}
}
