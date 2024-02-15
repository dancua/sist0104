package day0119;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.Action;

public class Quiz extends JFrame implements ActionListener,ItemListener{
	
	Container cp;
	JCheckBox cb;
	JCheckBox [] cbTrip = new JCheckBox[4];
	JRadioButton rb;
	JRadioButton [] rbColor = new JRadioButton[3];
	Color[] colors = {Color.blue,Color.green,Color.yellow};
	JLabel lbl;
	JButton btn;
	
	
	public Quiz(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(270, 100, 500, 500);
		cp.setBackground(new Color(153, 102, 255));

		initDesign();
		this.setVisible(true);
	}

	
	public void initDesign() {
		this.setLayout(null);
		
		//남자 여자 바뀌는 체크박스
		cb = new JCheckBox("남자");
		cb.setBounds(20, 20, 100, 30);
		cb.setOpaque(false);
		cb.addItemListener(this); 
		
		this.add(cb);
		
		String[] trips = {"일본","필리핀","독일","미국"};
		int xpos1 = 20;
		for(int i = 0; i < cbTrip.length; i++) {
			cbTrip[i] = new JCheckBox(trips[i]);
			cbTrip[i].setBounds(xpos1, 100, 80, 30);
			cbTrip[i].setOpaque(false);
			xpos1 += 80;
			this.add(cbTrip[i]);
		}
		
		String[] color = {"파랑","초록","노랑"};
		int xpos2 = 20;
		for(int i = 0; i< rbColor.length; i++) {
			rbColor[i] = new JRadioButton(color[i]);
			rbColor[i].setBounds(xpos2, 150, 80, 30);
			rbColor[i].setOpaque(false);
			xpos2 += 80;
			this.add(rbColor[i]);
		}
		
		btn = new JButton("내가 가본나라");
		btn.setBounds(600,160,200,30);
		this.add(btn);
		
	}

	public static void main(String[] args) {
	
		new Quiz("퀴즈");
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
