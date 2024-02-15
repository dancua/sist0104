package day0131;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//		시퀀스 	상품명		수량		단가		총금액		출력
//		테이블에서 상품부분을 클릭했을 때 우측에 이미지 나오게 Canvas내부클래스 구현
public class ShopListForm extends JFrame{
	
	ShopDbModel dbModel = new ShopDbModel();
	ImageDraw draw = new ImageDraw();
	String imageName;
	
//	테이블
	DefaultTableModel model;
	JTable table;
	Vector<shopDto> list;

	public ShopListForm()
	{
		super("상품 전체 리스트");
		this.setBounds(220, 100, 700, 400);
		initDesign();
		this.setVisible(true);
	}
	public void initDesign()
	{
		this.setLayout(null);
		list = dbModel.getAllSangpums();
		
//		table
		String [] title = {"No.","상품명","수량","단가","총금액","구입일"};
		model = new DefaultTableModel(title,0);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(10, 10, 500, 270);
		this.add(js);
		
//		이미지 위치
		draw.setBounds(520, 50, 160, 220);
		this.add(draw);
		
//		데이터 출력해주는 메서드
		this.dataWrite();
		
		
//		출력된 데이터 이벤트..익명내부클래스
		table .addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				행번호얻기
				int row = table.getSelectedRow();
				
//				list에서 rw에 해당하는 dto를 꺼내서 거기에서 이미지명을 얻는다				
				imageName = list.get(row).getPhoto();
				  System.out.println("Image Name: " + imageName);
				
				draw.repaint();
				super.mouseClicked(e);
			}
		});		
	}
	
//		데이터 출력해주는 멧드
	public void dataWrite()
	{
		
//			테이블 기존데이터 삭제
		model.setRowCount(0);
		
//		테이블에 데이터 추가
		for(shopDto dto : list) {
			Vector<String> data= new Vector<String>();
			
			data.add(dto.getNum());
			data.add(dto.getSangpum());
			data.add(String.valueOf(dto.getSu()));
			data.add(String.valueOf(dto.getDan()));
			data.add(String.valueOf(dto.getSu()*dto.getDan()));
			data.add(String.valueOf(dto.getGuipday()));
			
//			테이블 모델에 추가
			model.addRow(data);
			
			System.out.println(data);
		}
		
	}
	
	
	class ImageDraw extends Canvas{
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			if(imageName != null)
			{
				Image image = new ImageIcon(imageName).getImage();
				g.drawImage(image,0,0,160, 200,this);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new ShopListForm();
	}

}
