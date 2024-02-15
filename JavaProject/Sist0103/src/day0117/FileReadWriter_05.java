package day0117;

import java.io.*;
import java.util.*;

public class FileReadWriter_05 {
	
	static final String FILENAME = "C:\\sist0103\\file\\sungjuk.txt";
	FileReader fr = null;
	BufferedReader br= null;
	FileWriter fw = null;
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() {
		int num = 0;
		System.out.println("1.추가 | 2.전체출력 |9.종료");
		num = Integer.parseInt(sc.nextLine());
		return num;
		
	}
	
	//정보를 입력해서 파일에 저장
	public void sungjukWrite()
	{
		//이름 점수 입력
		System.out.println("학생명을 입력하세요");
		String name = sc.nextLine();
		System.out.println("점수를 입력하세요");
		int score = Integer.parseInt(sc.nextLine());
		
		//파일에 저장
		try {
			fw = new FileWriter(FILENAME,true);
			
			//입력된 내용 파일에 저장
			fw.write(name+"\n");
			fw.write(score+"\n");

			
			System.out.println("**학생 성적이 저장되었습니다.**");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//파일읽어서 계산후 출력
	public void sungjukRead()
	{
		//제목부터 출력
		System.out.println("\t**학생성적정보**");
		System.out.println();
		System.out.println("번호\t학생명\t점수\t학점");
		System.out.println("=============================");
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			int num = 0;
			
			while(true) {
				String name =br.readLine();
				
				if(name==null)
					break;
				
				int score = Integer.parseInt(br.readLine());
				String grade = getGrade(score);
				
			System.out.println(++num + "\t" +name + "\t" +score + "\t" +grade);
				
			}
			System.out.println("**출력끝**");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
		} finally {
			try {
				br.close();
				fr.close();
			}catch(IOException e) {
				
			}
		}
	}
	
	//점수에 대한 학점에 반환하는 메서드 
	public String getGrade(int score)
	{
		String grade;
		
		if(score>=90)
			grade ="A";
		else if(score >= 80)
			grade = "B";
		else if(score>= 70)
			grade = "C";
		else if (score >= 60)
			grade = "D";
		else 
			grade = "F";
		
		return grade;
	}

	public static void main(String[] args) {
		FileReadWriter_05 frw = new FileReadWriter_05();
		
		while(true)
		{
			int num = frw.getMenu();
			
			switch(num)
			{
			case 1:
				System.out.println("학생 정보 입력");
				frw.sungjukWrite();
				break;
			case 2:
				frw.sungjukRead();
				break;
			case 9:
				System.out.println("**프로그램을 종료합니다.");
				System.exit(0);
				default:
					System.out.println("번호를 다시 입력해주세요");
			}
		}

	}

}
