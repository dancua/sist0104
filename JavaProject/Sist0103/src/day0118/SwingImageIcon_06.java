/*package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingImageIcon_06 extends JFrame implements ActionListener{
	
	Container cp;	
	JButton btn1,btn2,btn3,btn4;
	
// 	이미지 아이콘 가져온다
	ImageIcon icon1 = new ImageIcon("C:\\sist0103\\image\\swingimage\\LEFT.gif");
	ImageIcon icon2 = new ImageIcon("C:\\sist0103\\image\\swingimage\\LEFTDown.gif");
	ImageIcon icon3 = new ImageIcon("C:\\sist0103\\image\\swingimage\\leftRollover.gif");
	ImageIcon icon4 = new ImageIcon("C:\\sist0103\\image\\swingimage\\chick.gif");
	ImageIcon icon5 = new ImageIcon("C:\\sist0103\\image\\swingimage\\RIGHT.gif");
	public SwingImageIcon_06(String title) {
		super(title);

		cp = this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(153,102,12));
		
		initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		this.setLayout(new GridLayout(2, 2));
		btn1 = new JButton("hello",icon1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		this.add(btn1);
		
		btn1.setRolloverIcon(icon2);
		btn1.setPressedIcon(icon3);
		
//		버튼2
		btn2= new JButton(icon4);
		this.add(btn2);
		
//		버튼3
		btn3 = new JButton("스윙버튼");
		this.add(btn3);
		
//		버튼4
		btn4= new JButton("안녕",icon5);
		this.add(btn4);
		
//		메시지 출력
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == btn1)
			JOptionPane.showMessageDialog(this, "안녕하세요");
		else if(ob ==btn2)
			JOptionPane.showMessageDialog(this, "병아리에요");
		else if(ob == btn3)
			JOptionPane.showMessageDialog(this, "스윙버튼이에요");
		else if(ob == btn4)
			JOptionPane.showMessageDialog(this, "안녕하세요");
		
	}
	public static void main(String[] args) {
		
		new SwingImageIcon_06("이미지버튼6");
		
	}
	

}
*/