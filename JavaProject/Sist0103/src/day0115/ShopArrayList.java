package day0115;

public class ShopArrayList {
	
	private String sangName;
	private int su;
	private int dan;
	
	//디폴트
	public ShopArrayList(){
		
	}
	
	//명시적
	public ShopArrayList(String name, int su, int dan) {
		this.sangName = name;
		this.su = su;
		this.dan = dan;
	}
	
	public String getSangName() {
		return sangName;
	}
	public void setSangName(String sangName) {
		this.sangName = sangName;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public int getTot() {
		int s = this.dan * this.su;
		return s;
	}

}
