import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Butt2_5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void window2_5() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butt2_5 window = new Butt2_5();
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
	public Butt2_5() {
		initialize();
	}

	public static JComboBox comboBox = new JComboBox();
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total infected :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(42, 34, 124, 36);
		frame.getContentPane().add(lblNewLabel);
		

		JRadioButton rdbtnGreece = new JRadioButton("Greece");
		rdbtnGreece.setBounds(264, 43, 82, 23);
		frame.getContentPane().add(rdbtnGreece);
		
		JRadioButton rdbtnCity = new JRadioButton("City");
		rdbtnCity.setBounds(362, 43, 109, 23);
		frame.getContentPane().add(rdbtnCity);
		
		rdbtnGreece.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnGreece.isSelected()) {
					rdbtnCity.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnGreece);
		
		rdbtnCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCity.isSelected()) {
					rdbtnGreece.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnCity);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Athens", "Thessaloniki", "Larisa", "Xania", "Patra", "Komotini", "Alexandroupoli", "Kalamata", "Giannena"}));
		comboBox.setBounds(267, 89, 142, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String location;
				if(rdbtnGreece.isSelected()) {
					location = "Greece";
					Statistics.totalInfected(location);
					JOptionPane.showMessageDialog(frame, "Total people infected by Covid19 in Greece are  " + Statistics.getCountTotalInfected());
				} else {
					location = "City";
					Statistics.totalInfected(location);
					JOptionPane.showMessageDialog(frame, "Total people infected by Covid19 in " + comboBox.getItemAt(comboBox.getSelectedIndex()) + " are " + Statistics.getCountTotalInfected());
				}
				
				frame.setVisible(false);
				Butt2.window2();
					
			}
		});
		btnSubmit.setBounds(218, 169, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblSelectCity = new JLabel("Select city\r\n\r\n");
		lblSelectCity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelectCity.setBounds(42, 88, 109, 19);
		frame.getContentPane().add(lblSelectCity);
		
		JLabel lblincaseYouSelcted = new JLabel("(incase you selcted the above button)");
		lblincaseYouSelcted.setBounds(42, 107, 195, 14);
		frame.getContentPane().add(lblincaseYouSelcted);
		
	}
}

