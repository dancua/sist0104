package day0110_arr1;

class Ipgo {
	private String sangName;
	private int Price;
	
	public void setSangName(String sangName) {
		this.sangName = sangName;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getSangName() {
		return sangName;
	}
	public int getPrice() {
		return Price;
	}
	
}
// 사과, 2500 오렌지,4400
public class SangpumIpgo_13 {

	public static void main(String[] args) {
	
		Ipgo ig1 = new Ipgo();
		Ipgo ig2 = new Ipgo();
		
		ig1.setSangName("사과");
		ig1.setPrice(2500);
		
		ig2.setSangName("오렌지");
		ig2.setPrice(4400);
		
		String name1 = ig1.getSangName();
		int price1 = ig1.getPrice();
		
		String name2 = ig2.getSangName();
		int price2 = ig2.getPrice();

		System.out.println(name1 + ": "+ price1);
		System.out.println(name2 + ": "+ price2);
		
		/*
		Ipgo ipgo1 = new Ipgo();
		ipgo1.setSangName("사과");
		ipgo1.setPrice(58000);
		
		Ipgo ipgo2 = new Ipgo();
		ipgo2.setSangName("오렌지");
		ipgo2.setPrice(44000);
		
		String name1 = ipgo1.getSangName();
		int price1 = ipgo1.getPrice();
		
		String name2 = ipgo2.getSangName();
		int price2 = ipgo2.getPrice();
		
		System.out.println(name1+","+ price1 + "원");
		System.out.println(name2+","+ price2 + "원");

		*/
	}

}
