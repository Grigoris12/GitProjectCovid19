import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Butt2_4 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void window2_4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butt2_4 window = new Butt2_4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Butt2_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(274, 56, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Insert day :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(66, 56, 86, 17);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 87, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insert month :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(66, 89, 104, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(274, 118, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblInsertYear = new JLabel("Insert Year :");
		lblInsertYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInsertYear.setBounds(66, 121, 86, 14);
		frame.getContentPane().add(lblInsertYear);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dayInput = textField.getText();
				int day = Integer.parseInt(dayInput);
				String monthInput = textField.getText();
				int month = Integer.parseInt(monthInput);
				String yearInput = textField.getText();
				int year = Integer.parseInt(yearInput);
				Statistics.todayInfected(day, month, year);
				frame.setVisible(false);
			}
		});
		btnSubmit.setBounds(154, 183, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
}

