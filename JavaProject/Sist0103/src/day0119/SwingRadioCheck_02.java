package day0119;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import day0118.SwingBtnEvent_05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingRadioCheck_02 extends JFrame implements ActionListener {

	Container cp;
	JRadioButton[] rb = new JRadioButton[4]; // 하나만 선택하고 싶을때
	JCheckBox[] cb = new JCheckBox[4];
	Color[] colors = { Color.RED, Color.GREEN, Color.MAGENTA, Color.CYAN };
	JLabel lblMessage;

	public SwingRadioCheck_02(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(270, 100, 500, 500);
		cp.setBackground(new Color(153, 102, 255));

		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
//		상단패널 보더로 감싸서 4개의 라디오버튼 생성
		String[] str = { "Red", "Green", "Magenta", "Cyan" };
		JPanel pTop = new JPanel();
		pTop.setBorder(new TitledBorder("글자색"));
		this.add("North", pTop);

//		라디오버튼 하나만 선택되도록 하려면 그룹 지정해야함
		ButtonGroup bg = new ButtonGroup();

		for (int i = 0; i < rb.length; i++) {
			rb[i] = new JRadioButton(str[i], i == 1 ? true : false); // 라디오버튼생성(텍스트,기본체크)
			pTop.add(rb[i]); // 탑패널에 추가
			bg.add(rb[i]); // 버튼그룹에 추가
			rb[i].addActionListener(this); // 액션추가
		}

//		가운데 라벨
		lblMessage = new JLabel("안녕하세요!~즐거운 금요일", JLabel.CENTER);
		lblMessage.setFont(new Font("", Font.BOLD, 20));
		this.add(lblMessage, BorderLayout.CENTER);
		lblMessage.setBorder(new LineBorder(Color.RED, 2)); // 라인 굵기

//		하단패널에 보더로감싼 4개의 체크박스 만들기
		JPanel pBottom = new JPanel();
		pBottom.setBorder(new TitledBorder("가능언어"));
		this.add(pBottom, "South");

		String[] str2 = { "자바", "오라클", "HTML", "JSP" };
		for (int i = 0; i < cb.length; i++) {
			cb[i] = new JCheckBox(str2[i]);
			cb[i].addActionListener(this); // 액션추가
			pBottom.add(cb[i]);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		// 라디오버튼 호출처리,메세지 출력이 컬러별로 출력되도록
		for (int i = 0; i < rb.length; i++) {

			if (ob == rb[i]) {
				lblMessage.setForeground(colors[i]); // 글자색 변경
//				cp.setBackground(colors[i]);  배경색 변경    
			}
		}
//		체크박스 호출처리(다중선택 : 자바	JSP	또는 없음)
		String msg = "";
		for (int i = 0; i < cb.length; i++) {
			if (cb[i].isSelected() == true) {
				msg += cb[i].getText() + "  ";
			}
		}
		lblMessage.setText(msg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingRadioCheck_02("스윙_라이도_체크박스2");
	}

}
