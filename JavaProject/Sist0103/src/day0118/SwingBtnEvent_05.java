package day0118;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingBtnEvent_05 extends JFrame implements ActionListener {

	Container cp;
	JButton btn1,btn2;
	
	public SwingBtnEvent_05(String title) {
		super(title);

		cp = this.getContentPane();
		
		this.setBounds(270, 100, 500, 500);
		cp.setBackground(new Color(153,102,255));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(new FlowLayout());
		
		btn1= new JButton("◀");
		btn2= new JButton("▶");
		
		this.add(btn1);
		this.add(btn2);
		
		//버튼색상
		btn1.setBackground(Color.blue);
		btn2.setBackground(Color.red);
		
		//글자색상
		btn1.setForeground(Color.YELLOW);
		btn2.setForeground(Color.black);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if(ob == btn1)
			JOptionPane.showMessageDialog(this, "1번째 버튼 클릭");
		else if(ob ==btn2)
			JOptionPane.showMessageDialog(this, "2번째 버튼 클릭");
		
	}
	public static void main(String[] args) {
		
		new SwingBtnEvent_05("버튼이벤트5");

	}

	
}
