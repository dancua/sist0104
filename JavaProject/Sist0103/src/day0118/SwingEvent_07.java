package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingEvent_07 extends JFrame implements ActionListener{
	
	Container cp;
	JButton btn1,btn2,btn3;
	
	public SwingEvent_07(String title) {
		super(title);

		cp = this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(153,0,102));
		
		initDesign();
		
		this.setVisible(true);
	}
	
	public void initDesign()
	{
//		Flow레이아웃으로 버튼 2개 생성
//		버튼색상 그레이로 변경, 버튼색상 그린으로 변경
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼색상 그레이");
		btn2 = new JButton("버튼색상 그린");
		
		this.add(btn1);
		this.add(btn2);
		
//		버튼 1생성및 이벤트 주기(익명 내부 클래스 형식)
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				getContentPane().setBackground(Color.gray);
				cp.setBackground(Color.gray);
			}
		});
        
//		버튼2
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				getContentPane().setBackground(Color.green);
				cp.setBackground(Color.green);
			}
		});
		
		
////		버튼 색상
//		btn1.setBackground(Color.gray);
//		btn2.setBackground(Color.green);
		
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob==btn1)
			JOptionPane.showMessageDialog(this,"버튼1");
		if(ob==btn2)
			JOptionPane.showMessageDialog(this, "버튼2");
	}

	public static void main(String[] args) {
	
		new SwingEvent_07("스윙기본");
	}

}
