package Project;

import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class carAddForm extends JFrame implements ActionListener {
	
	JTextField tfName,tfPrice,tfFe,tfFuel,tfLevel,tfAp,tfMaintain;
	JLabel lblPhoto;
	String imageName;
	JButton btnImage,btnInsert;
	
//	db모델 생성
	carDAO dao = new carDAO();
	
//	내부클래스
	PhotoDraw photoDraw = new PhotoDraw();
	
	public carAddForm() {
		super("차량 등록");
		
		this.setBounds(300, 500, 400, 500);
		initDesign();
		this.setVisible(true);
	
	}
	public void initDesign()
	{
		this.setLayout(null);
		
//		1. 차량명
		JLabel lbl1 = new JLabel("차량명");
		lbl1.setBounds(20, 10, 60, 30);
		this.add(lbl1);
		
		tfName = new JTextField();
		tfName.setBounds(110,10,100,30);
		this.add(tfName);

		
//		사진선택
		JLabel  lbl2 = new JLabel("참고 사진:");
		lbl2.setBounds(20,60,60,30);
		this.add(lbl2);
		
		btnImage =new JButton("사진 선택");
		btnImage.setBounds(110, 60, 100, 30);
		this.add(btnImage);
		btnImage.addActionListener(this);
		
		photoDraw.setBounds(250, 10, 300, 300);
		this.add(photoDraw);
		
//		2. 가격
		JLabel lbl3 = new JLabel("가격");
		lbl3.setBounds(30, 160, 50, 30);
		this.add(lbl3); 
		
		tfPrice = new JTextField();
		tfPrice.setBounds(110,160,50,30);
		this.add(tfPrice);
		
//		3. 연비
		JLabel lbl4 = new JLabel("연비:");
        lbl4.setBounds(30, 200, 50, 30);
        this.add(lbl4);

        tfFe = new JTextField();
        tfFe.setBounds(110, 200, 50, 30);
        this.add(tfFe);

//      4. 연료
        JLabel lbl5 = new JLabel("연료:");
        lbl5.setBounds(30, 240, 50, 30); 
        this.add(lbl5);

        tfFuel = new JTextField();
        tfFuel.setBounds(110, 240, 100, 30); 
        this.add(tfFuel);

//      5. 등급
        JLabel lbl6 = new JLabel("차급:");
        lbl6.setBounds(30, 280, 50, 30); 
        this.add(lbl6);

        tfLevel = new JTextField();
        tfLevel.setBounds(110, 280, 100, 30); 
        this.add(tfLevel);

//      6. 외형
        JLabel lbl7 = new JLabel("외형:");
        lbl7.setBounds(30, 320, 50, 30); 
        this.add(lbl7);

        tfAp = new JTextField();
        tfAp.setBounds(110, 320, 100, 30); 
        this.add(tfAp);

//      7. 정비이력
        JLabel lbl8 = new JLabel("정비이력:");
        lbl8.setBounds(30, 360, 70, 30); 
        this.add(lbl8);

        tfMaintain = new JTextField();
        tfMaintain.setBounds(110, 360, 100, 30); 
        this.add(tfMaintain);

        lblPhoto = new JLabel("이미지명");
        lblPhoto.setBorder(new LineBorder(Color.pink));
        lblPhoto.setBounds(20, 120, 300, 30);
//        this.add(lblPhoto);
		
//		차 등록버튼
		btnInsert = new JButton("차량 등록");
        btnInsert.setBounds(110, 400, 100, 30); 
        btnInsert.addActionListener(this);
        this.add(btnInsert);
		
	}
	class PhotoDraw extends Canvas {
		
		@Override
		public void paint(Graphics g) {
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
//			carDTO 생성
			carDTO dto = new carDTO();

//			dto에 8의 데이터를 넣는다.
				dto.setC_name(tfName.getText());
	            dto.setCarImage(imageName);
	            dto.setC_price(Integer.parseInt(tfPrice.getText()));
	            dto.setC_fe(Double.parseDouble(tfFe.getText()));
	            dto.setC_fuel(tfFuel.getText());
	            dto.setC_level(tfLevel.getText());
	            dto.setC_ap(tfAp.getText());
	            dto.setC_maintain(tfMaintain.getText());

	            boolean cars = dao.insert(dto);

	            if (cars) {
	                JOptionPane.showMessageDialog(null, "차량 정보가 등록되었습니다.");
	            } else {
	                JOptionPane.showMessageDialog(null, "등록 중 오류가 발생했습니다.");
	            }

	            this.setVisible(false);
	            new carListForm();
	            dispose();
	        }
	}
	public static void main(String[] args) {
		
		new carAddForm();
	}
}
