package day0115;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ListEx_07 {

	public static void main(String[] args) {
		// 1.순차적으로 데이터 들어간다
		// 2.중복데이터도 허용한다.
		// 3.처음 생성시 일정한 갯수로 생성되는데 그이상의 데이터를 넣으면 자동으로 공간이 늘어남.
		
		// List<String> list = new Vector<String>(); //List는 interface
		 Vector<String> list = new Vector<String>(); 
		//생성자가 디폴트인 경우 기본 할당 크기가 10
		System.out.println("초기데이터갯수: "+ list.size());
		System.out.println("초기할당크기: " + list.capacity());
		
		list.add("장미");
		list.add("수국");
		list.add("프리지아");
		list.add("안개");
		list.add("장미");
		list.add("수국");
		list.add("프리지아");
		list.add("안개");
		
		System.out.println("초기데이터갯수: "+ list.size());
		System.out.println("초기할당크기: " + list.capacity());
		
		System.out.println("출력_#1");
		for(int i = 0; i < list.size(); i++)
		{
			String s = list.get(i);
			System.out.printf("%3s",s);
			System.out.println();
		}
		System.out.println("출력_#2");
		for(String s: list)
		{
			System.out.printf(s+" ");
			System.out.println();
		}
		System.out.println("출력_#3");
		Iterator <String> iter = list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next()+ " ");
		System.out.println();
		
		System.out.println("출력_#4");
		
		Object[] ob = list.toArray();
		for(int i = 0; i<ob.length; i++) {
			String s = (String)ob[i];
			System.out.println(s+" ");
		}
	}

}
