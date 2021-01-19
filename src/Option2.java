import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Option2 {

	private JFrame frame;
	private JTextField datetext;
	private int j = 0; 
	/**
	 * Launch the application.
	 */
	public static void option2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Option2 window = new Option2();
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
	public Option2() {
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
		
		JLabel lblNewLabel = new JLabel("What is the current situation of the case: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(32, 13, 388, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton alive = new JRadioButton("Alive");
		alive.setBounds(84, 181, 127, 25);
		frame.getContentPane().add(alive);
		
		JRadioButton dead = new JRadioButton("Dead");
		dead.setBounds(260, 181, 127, 25);
		frame.getContentPane().add(dead);
		
		datetext = new JTextField();
		datetext.setBounds(188, 151, 116, 22);
		frame.getContentPane().add(datetext);
		datetext.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String status = "";
						if(alive.isSelected()) {
							status = "alive";
							for(int i=0; i < Person.personlist.size(); i++) {
								if (Person.personlist.get(i).getAMKA() == findAMKA.getAmka()) {
									 j = i; 
								}
							}
							Hospital.icuExtraction(Person.personlist.get(j), status,datetext.getText());
							JOptionPane.showMessageDialog(frame,"The hospital has one more available Icu, the extraction has been successful");
							frame.dispose();
							Options.options();
						}else if(dead.isSelected()){
							status = "dead";
							for(int i=0; i < Person.personlist.size(); i++) {
								if (Person.personlist.get(i).getAMKA() == findAMKA.getAmka()) {
									 j = i; 
								}
							}
							Hospital.icuExtraction(Person.personlist.get(j), status,datetext.getText());
							JOptionPane.showMessageDialog(frame,"The hospital has one more available Icu, the extraction has been successful");
							frame.dispose();
							Options.options();
						} else {
							  JOptionPane.showMessageDialog(frame,"Select dead or alive");
						}
				 
				}
		});
		btnNewButton.setBounds(153, 215, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblInsertThe = new JLabel("Give the date(DD/MM/YY) that the ");
		lblInsertThe.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblInsertThe.setBounds(32, 47, 355, 41);
		frame.getContentPane().add(lblInsertThe);
		
		JLabel lblPersonLeftThe = new JLabel("person left the icu :");
		lblPersonLeftThe.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblPersonLeftThe.setBounds(32, 88, 257, 34);
		frame.getContentPane().add(lblPersonLeftThe);
		
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblDate.setBounds(74, 145, 77, 27);
		frame.getContentPane().add(lblDate);
		alive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (alive.isSelected()) {
					dead.setSelected(false);
				}
			}
		});
		dead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dead.isSelected()) {
					alive.setSelected(false);
				}
			}
		});
	}
}
