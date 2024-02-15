package day0118;

import javax.swing.*;
import javax.swing.border.TitledBorder;import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 2개의 텍스트필드에 숫자를 넣고 버튼을 만든후 클릭하면 라벨에 2+3=5 <= 처럼 출력
public class SwingTextField_10 extends JFrame {

	Container cp;
	JTextField tfNum1, tfNum2;
	JButton btnAdd,btnPPa,btnGup,btnNa;
	JLabel lblNum1, lblNum2, lblResult;

	public SwingTextField_10(String title) {
		super("텍스트필드문제");

		cp = this.getContentPane();

		this.setBounds(270, 100, 500, 300);
		cp.setBackground(new Color(153, 102, 250));
		setDesign();
		this.setVisible(true);
	}

	public void setDesign() {
		this.setLayout(null);
		lblNum1 = new JLabel("숫자1: ");
		lblNum2 = new JLabel("숫자2: ");

		lblNum1.setBounds(20, 20, 50, 30);
		this.add(lblNum1);
		lblNum2.setBounds(20, 60, 90, 30);
		this.add(lblNum2);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(80, 20, 50, 30);
		this.add(tfNum1);
		tfNum2 = new JTextField();
		tfNum2.setBounds(80, 60, 90, 30);
		this.add(tfNum2);
		
		btnAdd = new JButton("+");
		btnAdd.setBounds(40, 110, 40, 40);
		this.add(btnAdd);
		
		btnPPa = new JButton("-");
		btnPPa.setBounds(100, 110, 40, 40);
		this.add(btnPPa);
		
		btnGup = new JButton("*");
		btnGup.setBounds(160, 110, 40, 40);
		this.add(btnGup);
		
		btnNa = new JButton("/");
		btnNa.setBounds(220, 110, 40, 40);
		this.add(btnNa);
		
		lblResult = new JLabel("결과");
		lblResult.setBounds(20, 170, 250, 60);
		lblResult.setBorder(new TitledBorder("결과확인"));
		this.add(lblResult);
		lblResult.setFont(new FontUIResource("", Font.BOLD, 20));
		
		// 익명내부클래스
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num1=Integer.parseInt(tfNum1.getText().trim());
				//trim 앞뒤 공백 제거 후 변환
				int num2=Integer.parseInt(tfNum1.getText().trim());
				
				int sum = num1+num2;
				
				String s= num1+ "+" + num2 + "=" + sum;
				lblResult.setText(s);
				
			}
		});
		btnPPa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num1 =Integer.parseInt(tfNum1.getText().trim());
				int num2 = Integer.parseInt(tfNum2.getText().trim());
				
				int PPa = num1 - num2;
				
				String s= num1+ "-" + num2 + "=" + PPa;
				lblResult.setText(s);
				
			}
		});
		btnGup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double num1 =Integer.parseInt(tfNum1.getText().trim());
				double num2 = Integer.parseInt(tfNum2.getText().trim());
				
				double Gup = num1 * num2;
				
				String s= num1+ "*" + num2 + "=" + Gup;
				lblResult.setText(s);
				
			}
		});
		
		btnNa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double num1 =Integer.parseInt(tfNum1.getText().trim());
				double num2 = Integer.parseInt(tfNum2.getText().trim());
				
				double Na = num1 / num2;
				
				String s= num1+ "/" + num2 + "=" + Na;
				lblResult.setText(s);
				
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new SwingTextField_10("텍스트필드공부_10");

	}

}
