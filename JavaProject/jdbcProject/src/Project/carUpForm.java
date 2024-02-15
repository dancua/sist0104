package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class carUpForm extends JFrame {

    JButton updateButton, btnImage;
    JTextField tfNum, tfName, tfNewName, tfPrice, tfFe, tfFuel, tfLevel, tfAp, tfMain;
    JLabel lblPhoto;
    String imageName;
    carDAO dao = new carDAO();
    PhotoDraw photoDraw = new PhotoDraw();

    public carUpForm() {
        super("차량 수정");

        this.setBounds(300, 500, 400, 600);
        initDesign();
        this.setVisible(true);
    }

    public void initDesign() {
        setLayout(null);

        JLabel lbl1 = new JLabel("수정할 시퀀스:");
        JLabel lbl2 = new JLabel("현재 차이름:");
        JLabel lbl3 = new JLabel("새로운 차이름:");
        JLabel lbl4 = new JLabel("새로운 가격:");
        JLabel lbl5 = new JLabel("새로운 연비:");
        JLabel lbl6 = new JLabel("새로운 연료:");
        JLabel lbl7 = new JLabel("새로운 등급:");
        JLabel lbl8 = new JLabel("새로운 외형:");
        JLabel lbl9 = new JLabel("새로운 정비이력:");

        tfNum = new JTextField();
        tfName = new JTextField();
        tfNewName = new JTextField();
        tfPrice = new JTextField();
        tfFe = new JTextField();
        tfFuel = new JTextField();
        tfLevel = new JTextField();
        tfAp = new JTextField();
        tfMain = new JTextField();

        lbl1.setBounds(10, 10, 120, 20);
        tfNum.setBounds(100, 10, 120, 20);

        lbl2.setBounds(10, 40, 120, 20);
        tfName.setBounds(100, 40, 120, 20);

        lbl3.setBounds(10, 70, 120, 20);
        tfNewName.setBounds(100, 70, 120, 20);

        lbl4.setBounds(10, 100, 120, 20);
        tfPrice.setBounds(100, 100, 120, 20);

        lbl5.setBounds(10, 130, 120, 20);
        tfFe.setBounds(100, 130, 120, 20);

        lbl6.setBounds(10, 160, 120, 20);
        tfFuel.setBounds(100, 160, 120, 20);

        lbl7.setBounds(10, 190, 120, 20);
        tfLevel.setBounds(100, 190, 120, 20);

        lbl8.setBounds(10, 220, 120, 20);
        tfAp.setBounds(100, 220, 120, 20);

        lbl9.setBounds(10, 250, 120, 20);
        tfMain.setBounds(100, 250, 120, 20);

        lblPhoto = new JLabel("이미지명");
        lblPhoto.setBorder(new LineBorder(Color.pink));
        lblPhoto.setBounds(10, 280, 250, 30);
//        this.add(lblPhoto);

        btnImage = new JButton("사진 선택");
        btnImage.setBounds(10, 320, 150, 30);
        btnImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleImageSelection();
            }
        });
        this.add(btnImage);

        photoDraw.setBounds(10, 360, 300, 150);
        this.add(photoDraw);

        updateButton = new JButton("수정하기");
        updateButton.setBounds(10, 520, 120, 30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdate();
            }
        });

        this.add(lbl1);		this.add(tfNum);
        this.add(lbl2);		this.add(tfName);
        this.add(lbl3);		this.add(tfNewName);
        this.add(lbl4);		this.add(tfPrice);
        this.add(lbl5);		this.add(tfFe);
        this.add(lbl6);		this.add(tfFuel);
        this.add(lbl7);		this.add(tfLevel);
        this.add(lbl8);		this.add(tfAp);
        this.add(lbl9);		this.add(tfMain);
        
        
        this.add(btnImage);
        this.add(updateButton);
    }

    private void handleImageSelection() {
    	FileDialog dlg = new FileDialog(this,"이미지가져오기",FileDialog.LOAD);
		dlg.setVisible(true);
		
//		취소누르면 메서드 종료
		if(dlg.getDirectory()== null)
			return;
//		이미지명 얻기
		imageName = dlg.getDirectory() + dlg.getFile();
		
//		라벨에 이미지명 출력
		lblPhoto.setText(imageName);
		
//		이미지 출력
		photoDraw.repaint();
        }


    private void handleUpdate() {
        String num = tfNum.getText();
        String c_name = tfName.getText();

        boolean isAuthenticated = dao.authenticate(num, c_name);

        if (isAuthenticated) {
            String newName = tfNewName.getText();
            int newPrice = Integer.parseInt(tfPrice.getText());
            double newFe = Double.parseDouble(tfFe.getText());
            String newFuel = tfFuel.getText();
            String newLevel = tfLevel.getText();
            String newAp = tfAp.getText();
            String newMain = tfMain.getText();
            String newImage = imageName;


            carDTO updatedCar = new carDTO(num, newName, newPrice, newFe, newFuel, newLevel, newAp, newMain,imageName);

            System.out.println(updatedCar);
            
            boolean success = dao.update(updatedCar);

            if (success) {
                JOptionPane.showMessageDialog(null, "차량 정보가 성공적으로 수정되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "수정 중 오류가 발생했습니다.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "입력한 정보가 올바르지 않습니다.");
        }
        this.setVisible(false);
        new carListForm();
        dispose();
    }

    class PhotoDraw extends Canvas {

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            if (imageName != null) {
                Image image = new ImageIcon(imageName).getImage();
                g.drawImage(image, 10, 10, 140, 140, this);
            }
        }
    }

    public static void main(String[] args) {
        new carUpForm();
    }
}
