package day0111_arr;

class Shop {
	private String sangpum;
	private int price;
	private String sangColor;
	
	public Shop(String s, int p, String c) {
		sangpum = s;
		price = p;
		sangColor = c;
	}
	
	//제목
	public static void ShowTil() 
	{
		System.out.println("상품명\t가격\t색상");
		System.out.println("===================");
	}
	
	//생성한 갯수만큼 출력
	public void showShop() {
		System.out.println(sangpum + "\t" + price + "원\t" + sangColor);
		
	}
}

public class ArrObTest_11 {

	public static void main(String[] args) {
		// 4개 생성해서 출력할것
		
		Shop[]shop = new Shop[4];
		
		shop[0] = new Shop("리본",2500,"red");
		shop[1] = new Shop("리본",2500,"red");
		shop[2] = new Shop("리본",2500,"red");
		shop[3] = new Shop("리본",2500,"red");
		//4개의 shop배열에 생성자를 통해서 생성
		Shop.ShowTil();
		for(Shop s :shop) 
			s.showShop();
		System.out.println("----------------------");
		
		
		/*
		Shop [] sp = {
				new Shop("리본",2500,"red"),
				new Shop("본드",3000,"green"),
				new Shop("드라이기",10000,"blue"),
				new Shop("기구",25000,"yellow")	
			};
		/*
		for(int i = 0; i < sp.length; i++) 
		{
			sp[i].showShop();
		}
		
		for(Shop sp0 : sp) {
			sp0.showShop();
		}
		*/
	}

}
