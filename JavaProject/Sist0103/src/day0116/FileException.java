package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//BufferReader: 버퍼를 사용해서 파일읽기
//FileReader: 경로에 있는 파일로드 :반드시 exception 발생
//
public class FileException {

	public static void read() {
		String fileName="C:\\sist0103\\file\\memo.txt";
		BufferedReader br = null;
		FileReader fr = null; // 문자단위
		
		//읽기위해서 파일열기
		try {
			fr= new FileReader(fileName);
			System.out.println("파일을 열었어요!!");
			
			br= new BufferedReader(fr);
			//여러줄을 읽어야 하므로 while문으로 읽기
			while(true)
			{
				String  s= br.readLine();
				//마지막일 경우 null값을 읽는다,null값일 경우 while문 빠져나감
				if(s==null)
					break;
				
				System.out.println(s);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없어요: "+ e.getMessage());
		}catch(IOException e) {
		}finally {
			try {
				br.close(); // 생성한 반대순으로 닫아준다.
				fr.close();
				
				System.out.println("파일에 대한 자원을 모두 닫았어요!");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read();
		
		System.out.println("정상종료");

	}

}
