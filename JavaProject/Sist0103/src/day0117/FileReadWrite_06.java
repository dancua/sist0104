package day0117;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class FileReadWrite_06 {

	Scanner sc = new Scanner(System.in);
	static final String FILENAME = "C:\\sist0103\\file\\shop.txt";
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter fw = null;

	public int getMenu() {
		int num;

		System.out.println("[메뉴] 1.상품추가  2.전체상품출력  3.파일삭제   5.종료");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}

	// 입력후 파일에 저장
	public void sangpumAdd() {
		String sangName;
		int su, dan;

		// 바나나,10,3500 이런식으로 파일에 저장
		System.out.println("상품명 입력");
		sangName = sc.nextLine();
		System.out.println("수량입력");
		su = Integer.parseInt(sc.nextLine());
		System.out.println("단가입력");
		dan = Integer.parseInt(sc.nextLine());
		
		
		try {
			fw = new FileWriter(FILENAME,true);
			fw.write(sangName+","+su+","+dan+"\n");
			
			System.out.println("**추가되었습니다.**");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//파일 출력
	public void fileAllDatas() {
		int total = 0;
		int num = 0;
		
		NumberFormat nf = NumberFormat.getInstance();
		
		//제목출력
		System.out.println("번호\t상품명\t수량\t단가\t총금액");
		System.out.println("--------------------------------------");
		
		try {
			fr= new FileReader(FILENAME);
			br= new BufferedReader(fr);
			
			while(true) 
			{
				try {
					String b = br.readLine();
					
					if(b==null)
						break;
					
					String [] data = b.split(",");
					String sang = data[0];
					int su = Integer.parseInt(data[1].trim());
					int dan = Integer.parseInt(data[2].trim());
					
					int sum = su * dan;
					
					//총금액에 각금액 추가
					total += sum;
					
					System.out.println(++num + "\t"+sang + "\t"+su + "개\t"+nf.format(dan) + "원\t"+ nf.format(sum)+"원");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("\t\t총금액= "+nf.format(total)+"원");
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("저장된 파일이 없습니다.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//파일삭제
	public void deleteShop()
	{
		File file = new File(FILENAME);
		
		//파일이 존재한다면 삭제
		if(file.exists())
			 try {
				 if (file.delete()) {
		                System.out.println("*** 모든 데이터가 삭제되었습니다. ***");
		            } else {
		                System.out.println("파일 삭제 실패: 파일이 사용 중이거나 권한이 없습니다.");
		            }
		        } catch (SecurityException e) {
		            System.out.println("보안 예외 발생: " + e.getMessage());
		        }
		    } 
	public void process()
	{
		while(true)
		{
			int num = 0;
			num = this.getMenu();
			
			switch(num)
			{
			case 1:
				System.out.println("상품정보를 입력합니다.");
				sangpumAdd();
				break;
			case 2:
				System.out.println("전체상품을 출력합니다.");
				fileAllDatas();
				break;
			case 3:
				System.out.println("상품을 삭제합니다.");
				deleteShop();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("숫자 확인 후 다시 입력해주세요");
			}
		}
	}
	
	public static void main(String[] args) {
			FileReadWrite_06 frw = new FileReadWrite_06();
			frw.process();
	}

}
