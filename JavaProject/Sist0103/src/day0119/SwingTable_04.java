package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SwingTable_04 extends JFrame {
	
	Container cp;
	
	JTable table;
	JLabel lblTitle,lblOut;
	
	public SwingTable_04(String title) {
		super(title);

		cp = this.getContentPane();
		
		this.setBounds(270, 100, 500, 500);
		cp.setBackground(new Color(153,102,255));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		String [][] data = {
				{"송혜교","서울","010-1111-2222"},
				{"전지현","인천","010-1111-3333"},
				{"이효리","부산","010-1111-4444"}
		};
		String [] title = {"이름","주소","연락처"};
		
		lblTitle = new JLabel("JTable연습",JLabel.CENTER);
		lblOut = new JLabel("결과출력하는곳",JLabel.CENTER);
		
		table = new JTable(data,title);
		JScrollPane pane = new JScrollPane(table);
		
//		테이블에 마우스 이벤트 추가
		table.addMouseListener(new TableEvent());
		
		this.add(lblTitle,"North");
		this.add(pane,"Center");
		this.add(lblOut,"South");
	}
//     내부클래스 (상속 받을 수 있음)
	class TableEvent extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			super.mouseClicked(e);
			
//			System.out.println("테스트");
//			선택한 행번호 얻기
			int rowNum = table.getSelectedRow();
			
//			JOptionPane.showMessageDialog(SwingTable_04.this,"행번호:"+rowNum);
			String str = "이름: " + table.getValueAt(rowNum, 0)
						+ ", 주소: " + table.getValueAt(rowNum, 1) 
						+	",연락처: " + table.getValueAt(rowNum, 2);
			lblOut.setText(str);
		}
	}
	public static void main(String[] args) {
		new SwingTable_04("스윙테이블");
	}

}
