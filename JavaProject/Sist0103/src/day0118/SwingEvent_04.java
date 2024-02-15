package day0118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingEvent_04 extends JFrame implements ActionListener{

	Container cp;
	JButton btn1,btn2,btn3;
	
	public SwingEvent_04(String title) {
		super(title);

		cp = this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(153,102,255));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		//레이아웃
		this.setLayout(new FlowLayout());
		
		//버튼3개 생성
		btn1 = new JButton("버튼 #1");
		btn2 = new JButton("버튼 #2");
		btn3 = new JButton("버튼 #3");
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		
		btn1.setBackground(Color.yellow);
		btn2.setBackground(Color.blue);
		btn3.setBackground(Color.red);
		
		//버튼에 이벤트 발생.. 이벤트 핸들러와 이벤트 발생한 객체 연결
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource(); //버튼의 어떤 메서드 호출이지 정확히 지정해주어야함
		
		//메세지를 다이얼로그형태로 보여준다
//	C	JOptionPane.showMessageDialog(this, "버튼클릭!!");
		
		//버튼마다 다른 메세지 출력하려면 
		if(ob == btn1)
			JOptionPane.showMessageDialog(this, "1번째 버튼 클릭");
		else if(ob ==btn2)
			JOptionPane.showMessageDialog(this, "2번째 버튼 클릭");
		else if(ob==btn3)
			JOptionPane.showMessageDialog(this, "3번째 버튼 클릭");
	}
	
	public static void main(String[] args) {
		new SwingEvent_04("버튼이벤트");

	}

	

}
