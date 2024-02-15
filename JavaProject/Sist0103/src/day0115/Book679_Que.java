package day0115;

import java.util.*;

public class Book679_Que {

	public static void main(String[] args) {
			Queue<Message> mq = new LinkedList<Message>();
			
			mq.offer(new Message("sendMail","홍길동"));
			mq.offer(new Message("sendSMS","신용권"));
			mq.offer(new Message("sendKakaotalk","감자바"));
			
			while(!mq.isEmpty()) {
				Message ms = mq.poll();
			
			switch(ms.command) {
			case "sendMail":
				System.out.println(ms.to+"님에게 메일을 보냅니다.");
				break;
			case "sendSMS":
				System.out.println(ms.to+"님에게 SMS을 보냅니다.");
				break;
			case "sendKakaotalk":
				System.out.println(ms.to+"님에게 카카오톡을 보냅니다.");
				break;
			}
		}
	}
}
