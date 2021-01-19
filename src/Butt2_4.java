import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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

	public static JComboBox comboBox = new JComboBox();
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(274, 29, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Insert day :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(66, 29, 86, 17);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 60, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insert month :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(66, 60, 104, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(274, 91, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblInsertYear = new JLabel("Insert Year :");
		lblInsertYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInsertYear.setBounds(66, 92, 86, 14);
		frame.getContentPane().add(lblInsertYear);
		
		JRadioButton rdbtnGreeceButton = new JRadioButton("Greece");
		rdbtnGreeceButton.setBounds(236, 121, 69, 23);
		frame.getContentPane().add(rdbtnGreeceButton);
		
		JRadioButton rdbtnCityButton = new JRadioButton("City");
		rdbtnCityButton.setBounds(319, 121, 109, 23);
		frame.getContentPane().add(rdbtnCityButton);
		
		rdbtnGreeceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnGreeceButton.isSelected()) {
					rdbtnCityButton.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnGreeceButton);
		
		rdbtnCityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCityButton.isSelected()) {
					rdbtnGreeceButton.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnCityButton);
		

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Athens", "Thessaloniki", "Larisa", "Xania", "Patra", "Komotini", "Alexandroupoli", "Kalamata", "Giannena"}));
		comboBox.setBounds(274, 170, 97, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dayInput = textField.getText();
				int day = Integer.parseInt(dayInput);
				String monthInput = textField_1.getText();
				int month = Integer.parseInt(monthInput);
				String yearInput = textField_2.getText();
				int year = Integer.parseInt(yearInput);
				String location;
				if(rdbtnGreeceButton.isSelected()) {
					location = "Greece";
					Statistics.todayInfected(day, month, year, location);
					JOptionPane.showMessageDialog(frame, Statistics.getCountTodayInfected() + " people infected by Covid19 in Greece on " + day + "/" + month + "/" +year);
				} else {
					location = "City";
					Statistics.todayInfected(day, month, year,location);
					JOptionPane.showMessageDialog(frame, Statistics.getCountTodayInfected() + " people infected by Covid19 in " + comboBox.getItemAt(comboBox.getSelectedIndex()) + " on " + day + "/" + month + "/" +year);
				}
				
				frame.setVisible(false);
				Butt2.window2();

			}
		});
		btnSubmit.setBounds(155, 204, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblInsertLocation = new JLabel("Choose :");
		lblInsertLocation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInsertLocation.setBounds(66, 123, 115, 14);
		frame.getContentPane().add(lblInsertLocation);
		
		
		JLabel lblNewLabel_2 = new JLabel("Choose city :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(66, 157, 86, 17);
		frame.getContentPane().add(lblNewLabel_2);
		

	}
}
