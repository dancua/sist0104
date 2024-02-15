package Project;

//			 	db getter setter
public class carDTO {

	private String num; // 차 고유번호
	private String c_name; // 자동차명
	private int c_price; // 차 가격
	private double c_fe; // 차 연비
	private String c_fuel; // 차 연료
	private String c_level; // 차 등급
	private String c_ap; // 차 외형
	private String c_maintain; // 차 정비 이력
	private String carImage; 	// 이미지

//			car_info.nextval 차 시퀀스 

	public carDTO(String num,String c_name,int c_price, double c_fe, String c_fuel, String c_level, 
				String c_ap,String c_maintain,String carImage) {
		this.num = num;
		this.c_name = c_name;
		this.c_price = c_price;
		this.c_fe = c_fe;
		this.c_fuel = c_fuel;
		this.c_level = c_level;
		this.c_ap = c_ap;
		this.c_maintain = c_maintain;
	}
	
	public carDTO() {

	}
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_price() {
		return c_price;
	}

	public void setC_price(int c_price) {
		this.c_price = c_price;
	}

	public double getC_fe() {
		return c_fe;
	}

	public void setC_fe(double c_fe) {
		this.c_fe = c_fe;
	}

	public String getC_fuel() {
		return c_fuel;
	}

	public void setC_fuel(String c_fuel) {
		this.c_fuel = c_fuel;
	}

	public String getC_level() {
		return c_level;
	}

	public void setC_level(String c_level) {
		this.c_level = c_level;
	}

	public String getC_ap() {
		return c_ap;
	}

	public void setC_ap(String c_ap) {
		this.c_ap = c_ap;
	}

	public String getC_maintain() {
		return c_maintain;
	}

	public void setC_maintain(String maintain) {
		this.c_maintain = maintain;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	
	@Override
	public String toString() {
		return "[번호:" + num + ", 자동차명:" + c_name + ", 가격:" + c_price + " 만원, 연비:" + c_fe + "km/ℓ, 연료:" + c_fuel 
				+ ", 차급" + c_level +",외형"+c_ap +",정비이력"+c_maintain+"]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
