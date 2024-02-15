package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuizFileException_15 {
	
	public static void fruit() throws FileNotFoundException,IOException
	{
	/*
		String fileName ="C:\\sist0103\\file\\fruitShop.txt";
		FileReader fr = null;
		BufferedReader br = null;
		int cnt = 0;
		
		fr = new FileReader(fileName);
		System.out.println("**과일입고 목록**");
		System.out.println("번호\t과일명\t수량\t단가\t총금액");
		System.out.println("==========================================");
		
		br = new BufferedReader(fr);
		
		while(true)
		{
			String n = br.readLine();
			
			if(n==null)
				break;
			// split으로 분리
			String [] data = n.split(",");
			cnt++;
			String name = data[0];
			int su = Integer.parseInt(data[1]);
			int dan = Integer.parseInt(data[2]);
			int total = su * dan;
			
			//StringTokenizer로 분리
			/*
			StringTokenizer st = new StringTokenizer(n,",");
			cnt++;
		 String name = st.nextToken();
		 int su = Integer.parseInt(st.nextToken());
		 int dan = Integer.parseInt(st.nextToken());
		 int total = su*dan;
		 
	System.out.println(cnt +"\t"+ name +"\t"+ su + "\t"+dan+"\t"+ total);
		}
		
		br.close();
		fr.close();
		*/
		String fileName ="C:\\sist0103\\file\\fruitShop.txt";
		FileReader fr =null;
		BufferedReader br =null;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			System.out.println("과일입고목록");
			System.out.println("번호\t과일명\t수량\t단가\t총금액");
			System.out.println("-------------------------------");
			
			int n =0;
			
			while(true)
			{
				String s =br.readLine();
				
				//종료
				if(s==null)
					break;
				//분리 tokeneizer
				/*
				StringTokenizer st = new StringTokenizer(s,","); //s의 구분자 ,로 지정
				
				//배열의 갯수만큼 반복
				String sang = st.nextToken();
				int su = Integer.parseInt(st.nextToken().trim());
				int dan = Integer.parseInt(st.nextToken().trim());
				int total = su*dan;
				*/
				//분리 split
				String [] data = s.split(",");
				String sang = data[0];
				int su = Integer.parseInt(data[1]);
				int dan = Integer.parseInt(data[2]);
				int total = su*dan;
				
				
				//출력
				System.out.println(n++ +"\t"+sang +"\t"+su+"개\t"+dan +"원\t"+total+"원");
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		try {
			fruit();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

