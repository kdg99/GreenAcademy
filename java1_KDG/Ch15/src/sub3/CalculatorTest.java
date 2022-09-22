package sub3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class CalculatorTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtCalc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorTest frame = new CalculatorTest();
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
	public CalculatorTest() {
		setTitle("나의 계산기 v1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCalc = new JTextField();
		txtCalc.setEditable(false);
		txtCalc.setFont(new Font("굴림", Font.BOLD, 20));
		txtCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCalc.setText("0");
		txtCalc.setBounds(12, 28, 316, 52);
		contentPane.add(txtCalc);
		txtCalc.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(12, 111, 70, 70);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(94, 111, 70, 70);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(176, 111, 70, 70);
		contentPane.add(btn9);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setBounds(258, 111, 70, 70);
		contentPane.add(btnDiv);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(12, 191, 70, 70);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(94, 191, 70, 70);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(176, 191, 70, 70);
		contentPane.add(btn6);
		
		JButton btnMulti = new JButton("X");
		btnMulti.setBounds(258, 191, 70, 70);
		contentPane.add(btnMulti);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(12, 271, 70, 70);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(94, 271, 70, 70);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(176, 271, 70, 70);
		contentPane.add(btn3);
		
		JButton btnSub = new JButton("-");
		btnSub.setBounds(258, 271, 70, 70);
		contentPane.add(btnSub);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(12, 351, 70, 70);
		contentPane.add(btn0);
		
		JButton btnCancel = new JButton("C");
		btnCancel.setBounds(94, 351, 70, 70);
		contentPane.add(btnCancel);
		
		JButton btnResult = new JButton("=");
		btnResult.setBounds(176, 351, 70, 70);
		contentPane.add(btnResult);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setBounds(258, 351, 70, 70);
		contentPane.add(btnAdd);
	}

}
