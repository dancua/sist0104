package Project;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Project.carDTO;

// 		2번째 화면 


public class carListForm extends JFrame{
	
	carDAO dao = new carDAO();
	ImageDraw draw = new ImageDraw();
	String imageName;

//	테이블
	DefaultTableModel model;
	JTable table;
	Vector<carDTO> list;

	public carListForm()
	{
		super("상품 전체 리스트");
		this.setBounds(220, 100, 700, 420);
		initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		this.setLayout(null);
		list = dao.select();
		
		
//		table
		String [] title = {"No.","차량명","가격","연비","연료","차급","외형","정비이력"};
		model = new DefaultTableModel(title,0);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(10, 50, 550, 270);
		this.add(js);
		
//		이미지 위치
		draw.setBounds(570, 50, 160, 220);
		this.add(draw);
		
//		데이터 출력해주는 메서드
		this.dataWrite();
		
		
//		출력된 데이터 이벤트..익명내부클래스
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int row = table.getSelectedRow();
		        imageName = list.get(row).getCarImage();

		        System.out.println("Image Name: " + imageName);

		        draw.repaint();
		        super.mouseClicked(e);
		    }
		});
	
		
		JButton btnAdd = new JButton("추가");
        btnAdd.setBounds(60, 330, 80, 30);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	   new carAddForm();
            	   dispose();
            }
        });
        this.add(btnAdd);

        JButton btnDel = new JButton("삭제");
        btnDel.setBounds(160, 330, 80, 30);
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new carDelForm();
               dispose();
            }
        });
        this.add(btnDel);

        JButton btnUp = new JButton("수정");
        btnUp.setBounds(260, 330, 80, 30);
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new carUpForm();
              dispose();
            }
        });
        this.add(btnUp);

        JButton btnClose = new JButton("닫기");
        btnClose.setBounds(360, 330, 80, 30);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(btnClose, "프로그램을 종료합니다.");
                System.exit(0);
            }
        });
        this.add(btnClose);
	}
	
	
//		데이터 출력해주는 멧드
	public void dataWrite()
	{
		
//			테이블 기존데이터 삭제
		model.setRowCount(0);
		
//		테이블에 데이터 추가
		for(carDTO dto : list) {
			Vector<String> data= new Vector<String>();
			
			data.add(dto.getNum());
			data.add(dto.getC_name());
			data.add(String.valueOf(dto.getC_price()));
			data.add(String.valueOf(dto.getC_fe()));
			data.add(dto.getC_fuel());
			data.add(dto.getC_level());
			data.add(dto.getC_ap());
			data.add(dto.getC_maintain());

//			테이블 모델에 추가
			model.addRow(data);
			
			System.out.println(data);
		}

        JTextField search = new JTextField(40);
        search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String val = search.getText();
                TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());

                table.setRowSorter(trs);
                trs.setRowFilter(RowFilter.regexFilter(val));
            }
        });
        
        JLabel lbl1 = new JLabel();
        lbl1.setText("검색:");
        lbl1.setBounds(10,10,300,30);
        search.setBounds(50, 10, 200, 30);
       this.add(search);
       this.add(lbl1);
}
	
	class ImageDraw extends Canvas {
	    @Override
	    public void paint(Graphics g) {
	        super.paint(g);

	        if (imageName != null) {
	            try {
	                // 상대 경로를 사용할 경우
	                // Image image = new ImageIcon(getClass().getResource(imageName)).getImage();

	                // 절대 경로를 사용할 경우
	                Image image = new ImageIcon(imageName).getImage();

	                g.drawImage(image, 0, 0, 160, 200, this);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new carListForm();
	}

}
