import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
			@Override
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

		//Field for day insertion
		JLabel lblNewLabel = new JLabel("Insert day :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(66, 29, 86, 17);
		frame.getContentPane().add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(274, 60, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		//Field for month insertion
		JLabel lblNewLabel_1 = new JLabel("Insert month :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(66, 60, 104, 17);
		frame.getContentPane().add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBounds(274, 91, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		//Field for year insertion
		JLabel lblInsertYear = new JLabel("Insert year :");
		lblInsertYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInsertYear.setBounds(66, 92, 86, 14);
		frame.getContentPane().add(lblInsertYear);

		//Creation of buttons Greece,City
		JRadioButton greecebutton = new JRadioButton("Greece");
		greecebutton.setBounds(236, 121, 69, 23);
		frame.getContentPane().add(greecebutton);

		JRadioButton citybutton = new JRadioButton("City");
		citybutton.setBounds(319, 121, 109, 23);
		frame.getContentPane().add(citybutton);

		greecebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(greecebutton.isSelected()) {
					citybutton.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(greecebutton);

		citybutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(citybutton.isSelected()) {
					greecebutton.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(citybutton);

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Athens", "Thessaloniki", "Larisa", "Xania", "Patra", "Komotini", "Alexandroupoli", "Kalamata", "Giannena"}));
		comboBox.setBounds(274, 170, 97, 20);
		frame.getContentPane().add(comboBox);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int k = 0;
				String dayInput = textField.getText();
				String monthInput = textField_1.getText();
				String yearInput = textField_2.getText();
				try {
					 int y = Integer.parseInt(dayInput);
					if (y>31 || y<=0) {
						k++;
					}
				}catch(NumberFormatException es) {
					k++;
					JOptionPane.showMessageDialog(frame, "Invalid day insert");
				}
				try {
					int x = Integer.parseInt(monthInput);
					if (x>12 || x<=0 ) {
						k++;
					}
				}catch(NumberFormatException es) {
					JOptionPane.showMessageDialog(frame, "Invalid month insert");
					k++;
				}
				try {
					int year = Integer.parseInt(yearInput);
					if (year < 2020 || year>2023) {
						k++;
					}
				}catch(NumberFormatException es) {
					JOptionPane.showMessageDialog(frame, "Invalid year insert");
					k++;
				}
				String location = "";
				if(greecebutton.isSelected()) {
					location = "Greece";
				} else if(citybutton.isSelected()) {
					location = "City";
				}
				 if (location.equals("")) {
					 JOptionPane.showMessageDialog(frame, "Select Greece or city");
				 }
				if (k!=0 || location.equals(""))
					JOptionPane.showMessageDialog(frame, "Try again");
					else if(k==0 && location.equals("Greece")){
						int day = Integer.parseInt(dayInput);
						int month = Integer.parseInt(monthInput);
						int year = Integer.parseInt(yearInput);
						Statistics.todayInfected(day, month, year, location);
						JOptionPane.showMessageDialog(frame, Statistics.getCountTodayInfected() + " people infected by Covid19 in Greece on " + day + "/" + month + "/" +year);
						frame.setVisible(false);
						Butt2.window2();
					}else if (k==0 && location.contentEquals("City")) {
						int day = Integer.parseInt(dayInput);
						int month = Integer.parseInt(monthInput);
						int year = Integer.parseInt(yearInput);
						Statistics.todayInfected(day, month, year,location);
						JOptionPane.showMessageDialog(frame, Statistics.getCountTodayInfected() + " people infected by Covid19 in " + comboBox.getItemAt(comboBox.getSelectedIndex()) + " on " + day + "/" + month + "/" +year);
						frame.setVisible(false);
						Butt2.window2();
					}
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
