package day0118;

import javax.swing.*;
import java.awt.*;

public class SwingStart extends JFrame {

	Container cp;

	public SwingStart(String title) {
		super(title);

		cp = this.getContentPane();
		
		this.setBounds(270, 100, 500, 300);
		cp.setBackground(new Color(153,102,250));
		 initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new SwingStart("스윙시작");

	}

}
