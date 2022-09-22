package sub2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class ComponentTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComponentTest frame = new ComponentTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComponentTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("컴포넌트 실습하기");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 164, 15);
		contentPane.add(lblNewLabel);
		
		JButton btn1 = new JButton("버튼1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "버튼1 클릭...");
			}
		});
		btn1.setBounds(24, 59, 71, 23);
		contentPane.add(btn1);
	
		
		JButton btn2 = new JButton("버튼2");
		btn2.setBounds(107, 59, 71, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("버튼3");
		btn3.setBounds(190, 59, 71, 23);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("버튼4");
		btn4.setBounds(273, 59, 71, 23);
		contentPane.add(btn4);
		
		JLabel lblNewLabel_1 = new JLabel("Button 컴포넌");
		lblNewLabel_1.setBounds(20, 35, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TxtField 컴포넌트");
		lblNewLabel_2.setBounds(20, 92, 86, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 110, 144, 24);
		contentPane.add(textArea);
		
		JLabel lblTxtf1Result = new JLabel("결과");
		lblTxtf1Result.setBounds(287, 115, 57, 15);
		contentPane.add(lblTxtf1Result);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = textArea.getText();
				lblTxtf1Result.setText("결과 : " + txt);
			}
		});
		btnNewButton.setBounds(176, 111, 97, 23);
		contentPane.add(btnNewButton);
		
		JCheckBox chk1 = new JCheckBox("등산");
		chk1.setBounds(24, 186, 115, 23);
		contentPane.add(chk1);
		
		JLabel lblNewLabel_3 = new JLabel("CheckBox컴포넌트");
		lblNewLabel_3.setBounds(20, 165, 174, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnChck = new JButton("확인");
		btnChck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chk1.isSelected()) {
					List<String> chks = new ArrayList<>();
					chks.add(chk1.getText());
				}
			}
		});
		btnChck.setBounds(95, 186, 97, 23);
		contentPane.add(btnChck);
		
		JRadioButton rd = new JRadioButton("male");
		rd.setBounds(18, 232, 121, 23);
		contentPane.add(rd);
		
		JRadioButton rd2 = new JRadioButton("female");
		rd2.setBounds(143, 232, 121, 23);
		contentPane.add(rd2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rd);
		bg.add(rd2);
		
		JButton btnRd = new JButton("New button");
		btnRd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rd.isSelected()) {
					lblNewLabel.setText(rd.getText());
				}else if (rd2.isSelected()) {
					lblNewLabel.setText(rd2.getText());
					
				}
			}
		});
		btnRd.setBounds(291, 232, 97, 23);
		contentPane.add(btnRd);

		
		
	}
}
