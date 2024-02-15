package day0131;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopAddForm extends JFrame implements ActionListener {
	
	JTextField tfSang,tfSu,tfDan;
	JLabel lblPhoto;
	String imageName;
	JButton btnImage,btnInsert;
	
//	db모델 생성
	ShopDbModel model = new ShopDbModel();
	
//	내부클래스
	PhotoDraw photoDraw = new PhotoDraw();
	
	public ShopAddForm() {
		super("상품 추가폼");
		
		this.setBounds(270, 100, 400, 400);
		initDesign();
		this.setVisible(true);
	
	}
	public void initDesign()
	{
		this.setLayout(null);
		
//		상품명
		JLabel lbl1 = new JLabel("상품명");
		lbl1.setBounds(20, 10, 60, 30);
		this.add(lbl1);
		
		tfSang = new JTextField();
		tfSang.setBounds(110,10,100,30);
		this.add(tfSang);
		
//		사진선택
		JLabel  lbl2 = new JLabel("사진선택:");
		lbl2.setBounds(20,60,60,30);
		this.add(lbl2);
		
		btnImage =new JButton("사진선택");
		btnImage.setBounds(110, 60, 100, 30);
		this.add(btnImage);
		btnImage.addActionListener(this);
		
		photoDraw.setBounds(250, 10, 300, 300);
		this.add(photoDraw);
	
		lblPhoto = new JLabel("이미지명");
		lblPhoto.setBorder(new LineBorder(Color.pink));
		lblPhoto.setBounds(20, 120, 300, 30);
		this.add(lblPhoto);
		
//		수량
		JLabel lbl3 = new JLabel("수량");
		lbl3.setBounds(30, 160, 50, 30);
		this.add(lbl3); 
		
		tfSu = new JTextField();
		tfSu.setBounds(110,160,50,30);
		this.add(tfSu);
		
//		단가
		JLabel lbl4 = new JLabel("단가");
		lbl4.setBounds(30, 200, 50, 30);
		this.add(lbl4); 
		
		tfDan = new JTextField();
		tfDan.setBounds(110, 200, 50, 30);
		this.add(tfDan);
		
//		db추가버튼
		btnInsert = new JButton("DB추가");
		btnInsert.setBounds(110, 240, 100, 30);
		btnInsert.addActionListener(this);
		this.add(btnInsert);
		
	}
	class PhotoDraw extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			if(imageName!=null)
			{
				Image image = new ImageIcon(imageName).getImage();
				g.drawImage(image, 10, 10, 60, 70, this);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob==btnImage)
		{
			FileDialog dlg = new FileDialog(this,"이미지가져오기",FileDialog.LOAD);
			dlg.setVisible(true);
			
//			취소누르면 메서드 종료
			if(dlg.getDirectory()== null)
				return;
//			이미지명 얻기
			imageName = dlg.getDirectory() + dlg.getFile();
			
//			라벨에 이미지명 출력
			lblPhoto.setText(imageName);
			
//			이미지 출력
			photoDraw.repaint();
		}else if (ob==btnInsert)
		{
//			shopDto 생성
			shopDto dto = new shopDto();
			
//			dto에 4개의 데이터를 넣는다.
			dto.setSangpum(tfSang.getText());
			dto.setPhoto(imageName);
			dto.setSu(Integer.parseInt(tfSu.getText()));
			dto.setDan(Integer.parseInt(tfDan.getText()));
			
//			db모델에서 insert메서드 호출
			model.insertShop(dto);
			
			this.setVisible(false);
		}
	}
//	public static void main(String[] args) {
//		
//		new ShopAddForm();
//	}
}
