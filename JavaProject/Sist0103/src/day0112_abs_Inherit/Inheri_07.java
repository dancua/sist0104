package day0112_abs_Inherit;

class School {

	public static final String SCHOOLNAME = "쌍용고등학교";
	private String schoolAddr;
	private int countStu;
	private int countTeacher;

	public School() {
		this("강남구 역삼동", 120, 10);
	}

	public School(String saddr, int cntStu, int cntTeacher) {
		this.schoolAddr = saddr;
		this.countStu = cntStu;
		this.countTeacher = cntTeacher;
	}
	
	public String getSchoolAddr() {
		return schoolAddr;
	}
	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}
	public int getCountStu() {
		return countStu;
	}
	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}
	public int getCountTeacher() {
		return countTeacher;
	}
	public void setCountTeacher(int countTeacher) {
		this.countTeacher = countTeacher;
	}
	public static String getSchoolname() {
		return SCHOOLNAME;
	}

	// 메서드
	public void writeData() {
		System.out.println("학교주소: " + this.schoolAddr);
		System.out.println("학생수: " + this.countStu + ", 선생님수: " + this.countTeacher);
	}
}

class Student extends School {

	private String stuName;
	private int grade;

	public Student() {

	}

	public Student(String sAddr, int cntStu, int cntTea, String stuname, int gra) {
		super(sAddr, cntStu, cntTea);
		this.stuName = stuname;
		this.grade = gra;
	}
	//각각의 setter & getter
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	//재정의메서드
	@Override
	public void writeData() {
		// TODO Auto-generated method stub
		System.out.println("학교명 :"+ SCHOOLNAME); //상속받았으므로 클래스명 생략 가능
		super.writeData();
		System.out.println("학생명 : " + stuName);
		System.out.println("학년 : "+grade+ "학년");
	}
}

public class Inheri_07 {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.writeData();
		System.out.println();
		
		Student s2 = new Student("영등포구",300,35,"김숙",4);
		s2.writeData();
		
		System.out.println();
		System.out.println("1번째 학생 학생명과 학년 변경 후 출력");
		s1.setStuName("이영자");
		s1.setGrade(1);
		s1.writeData();

	}

}
