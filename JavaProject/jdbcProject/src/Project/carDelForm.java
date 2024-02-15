package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class carDelForm extends JFrame {

    private JTextField tfNum;
    private JButton deleteButton;
    private carDAO dao = new carDAO();

    public carDelForm() {
        super();

        this.setBounds(300, 500, 400, 200);
        initDesign();
        this.setVisible(true);
    }

    private void initDesign() {
        setLayout(null);

        JLabel lbl1 = new JLabel("삭제할 차량번호:");
        lbl1.setBounds(10, 10, 120, 20);
        tfNum = new JTextField();
        tfNum.setBounds(140, 10, 150, 20);

        deleteButton = new JButton("삭제하기");
        deleteButton.setBounds(10, 40, 120, 30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					handleDelete();
					new carListForm();
					 dispose();
				} catch (SQLException q) {
					// TODO Auto-generated catch block
					q.printStackTrace();
				}
            }
        });

        this.add(lbl1);
        this.add(tfNum);
        this.add(deleteButton);
    }

    private void handleDelete() throws SQLException {
        String num = tfNum.getText();

        boolean success = dao.delete(num);

		if (success) {
		    JOptionPane.showMessageDialog(null, "차량 정보가 성공적으로 삭제되었습니다.");
		} else {
		    JOptionPane.showMessageDialog(null, "삭제 중 오류가 발생했습니다.");
		}	
    }

    public static void main(String[] args) {
        new carDelForm();
    }
}
