package day0119;

import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileDialog_06 extends JFrame implements ActionListener {

	Container cp;
	JTextArea area;
	JButton btn1,btn2;	// btnOpen btnSave

	public FileDialog_06(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(270, 100, 500, 500);
		cp.setBackground(new Color(153, 102, 255));

		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		this.setLayout(null);
		
		btn1 = new JButton("파일불러오기");
		btn1.setBounds(40,20,120,30);
		this.add(btn1);
		
//		불러오기 이벤트
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dlg = new FileDialog(FileDialog_06.this, "파일열기", FileDialog.LOAD);
				
				dlg.setVisible(true);
//				 선택한 디렉토리
				String  dir = dlg.getDirectory();
//				선택한 파일명
				String file = dlg.getFile();
				
				System.out.println(dir+"\n"+file);
				
//				만약 취소 누르면 메서드 종료
				if(dir == null)
					return;
				
				FileReader fr = null;
				BufferedReader br =null;
				
				try {
					fr = new FileReader(dir+file);
					br = new BufferedReader(fr);
					area.setText("");
					while(true)
					{
						String s = br.readLine();
						
						if(s==null)
							break;
						
//						읽은 데이터를 area에 출력
						area.append(s+"\n");
						
					}
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						
						if(br != null) br.close();
						if(fr != null) fr.close();
//						br.close();
//						fr.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btn2 = new JButton("파일저장하기");
		btn2.setBounds(200, 20, 120, 30);
		this.add(btn2);
		
//		저장하기 이벤트
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileDialog dlg =new FileDialog(FileDialog_06.this,"파일 저장", FileDialog.SAVE);
				dlg.setVisible(true);
				
				String dir = dlg.getDirectory();
				String file = dlg.getFile();
				
				if(dir==null)
					return;
				
//				파일저장
				FileWriter fw = null;
				try {
					fw = new FileWriter(dir+file);
					
//					area의 내용을 가져와서 파일에 저장
					fw.write(area.getText()+"\n");
//					저장
					area.setText(file+" 파일로 저장됨");
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						if(fw!=null) fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
//		출력영역
		area = new JTextArea();
		area.setFont(new Font("",Font.BOLD,20));
		
		JScrollPane js =new JScrollPane(area);
		js.setBounds(20,70,300,300);
		this.add(js);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileDialog_06("파일다이어로그6");
	}

}
