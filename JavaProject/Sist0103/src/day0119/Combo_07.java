package day0119;

import javax.swing.*;
import javax.swing.border.LineBorder;

import day0118.SwingBtnEvent_05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class Combo_07 extends JFrame implements ActionListener, ItemListener {
	
	JComboBox<String> combo;
	String [] names = {"박나래","전현무","덱스","기안"};
	JTextField tfName;
	JButton btn1,btn2; // btnAdd, btnDel
	JLabel lblResult;
	Container cp;
	
	int idx = -1; //멤버변수는 0으로 자동 초기화 되는데 0번 삭제를 막기위해서 지정
	
	public Combo_07(String title) {
		super(title);
		cp = this.getContentPane();	
		this.setBounds(270, 100, 500, 500);
		cp.setBackground(new Color(153,102,255));
//		this.getContentpane().setBackground(new Color(153,102,255));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(null);
		
		combo = new JComboBox<String>(names); 
		combo.setBounds(30,30,100,30);
		this.add(combo);
		
		tfName = new JTextField();
		tfName.setBounds(30, 90, 80, 30);
		this.add(tfName);
			
		btn1 = new JButton("추가");
		btn1.setBounds(150,90,80,30);
		btn2 = new JButton("삭제");
		btn2.setBounds(250,90,80,30);
		
		this.add(btn1);
		this.add(btn2);
		
		lblResult = new JLabel("결과",JLabel.CENTER);
		lblResult.setBorder(new LineBorder(Color.pink,8));
		lblResult.setBounds(20,200,350,60);
		this.add(lblResult);
		
		combo.addItemListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob==btn1)
		{
//			입력한 이름을 앞뒤공백 제거 후 읽어옴
			String text = tfName.getText().trim();
			
			if(text.length() == 0)
			{
				JOptionPane.showMessageDialog(this, "이름 입력후 시도해주세요");
			}else {
				combo.addItem(text); 	//콤보에 추가
				tfName.setText(""); 	//입력값 초기화
			}
		}else if(ob==btn2)
		{
			if(idx== -1)
				JOptionPane.showMessageDialog(this, "삭제할 항목 선택후 시도해주세요");
		}else {
			combo.removeItemAt(idx);  
			lblResult.setText("해당 항목을 삭제했습니다.");
			idx = -1;
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		idx = combo.getSelectedIndex();
		String item = (String)combo.getSelectedItem();
		
		lblResult.setText(idx+"번 인덱스의 " + item + "선택됨!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Combo_07("콤보박스7");
	}

	

}
