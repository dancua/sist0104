package day0118;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test1 extends JFrame implements ActionListener{

	Container cp;
	JButton [] btn = new JButton[6];
	String [] btnLabel= {"Red","Green","Blue","Magenta","Gray","Yellow"};
	Color [] btnColors={Color.RED,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.GRAY,Color.YELLOW};
	
	public test1(String title) {
		super(title);

		cp = this.getContentPane();
		
		this.setBounds(300, 100, 600, 300);
		cp.setBackground(new Color(153,102,250));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		// Panel은 기본이 FlowLayout
		JPanel panel = new JPanel();
		panel.setBackground(Color.orange);
		
		this.add(panel,BorderLayout.NORTH);
		
		for(int i =0; i < btn.length; i++) 
		{
			//버튼 6개 생성
			btn[i] = new JButton(btnLabel[i]);
			
//			버튼 6개에 각각의 버튼색상 변경	
			btn[i].setBackground(btnColors[i]);
			
			// 버튼 6개에 이벤트 추가
				btn[i].addActionListener(this);
			
//			panel에 버튼6개 추가
			panel.add(btn[i]);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		//각각의 버튼을 누르면 프레임의 배경색 변경
		for(int i =0; i < btn.length; i++) {
		
				if(ob == btn[i]) { // 괄호때문에 if 같이 안돌아감
				cp.setBackground(btnColors[i]);
//				창제목변경 (Color: Red)
				this.setTitle("Color: "+btnLabel[i]);
				}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test1("스윙기본");
	}

	

}
