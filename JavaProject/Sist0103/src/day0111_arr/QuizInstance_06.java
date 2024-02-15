package day0111_arr;

class Artist{
	//변수명
	private String g_Name;
	private String p_Song;
	
	static String agency;
	static int cnt = 0;
	
	//명시적 생성자
	public Artist(String name,String song) {
		this.g_Name = name;
		this.p_Song = song;
	}
		//출력 메서드 한번에 만들기
	public void writeData() {		
			cnt++;
			System.out.println("**아티스트 정보_ "+ cnt+"**");
			System.out.println("소속기획사: "+Artist.agency);
			System.out.println("그룹명: " + this.g_Name);
			System.out.println("대표곡: "+this.p_Song);
			System.out.println("---------------------------");
			
		}
		
	
	/*
	private String group;
	private String song;
	
	static String ment;
	static int cnt;

	//명시적생성자
	public Artist(String group, String song) {
		this.group = group;
		this.song = song;
	}
	
	//출력메서드 한번에 만들기
	void run() {
		cnt++;
		System.out.println("**아티스트 정보_ "+ cnt+"**");
			System.out.println("소속기획사: "+ Artist.ment);
			System.out.println("그룹명: " +this.group);
			System.out.println("주소: " + this.song);
			System.out.println("--------------------------");
	}
	*/
}
public class QuizInstance_06 {

	public static void main(String[] args) {
		Artist ar1 = new Artist("bts","버터");
		Artist ar2 = new Artist("뉴진스","어텐션");
		
		Artist.agency = "하이브";
		
		ar1.writeData();
		ar2.writeData();
		/*
		Artist art1 = new Artist("bts", "버터");
		Artist art2 = new Artist("뉴진스", "어텐션");
		
		Artist.ment = "하이브";
		
		art1.run();
		art2.run();
		*/
		
	}

}
