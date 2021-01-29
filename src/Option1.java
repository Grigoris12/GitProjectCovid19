import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Option1 {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void option1() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Option1 window = new Option1();
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
	public Option1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 464, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Does the patient need to be entranced in Icu?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(39, 50, 407, 31);
		frame.getContentPane().add(lblNewLabel);

		JRadioButton True = new JRadioButton("True");
		True.setBounds(53, 105, 127, 25);
		frame.getContentPane().add(True);

		JRadioButton False = new JRadioButton("False");
		False.setBounds(53, 157, 127, 25);
		frame.getContentPane().add(False);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(True.isSelected()) {
				JOptionPane.showMessageDialog(frame,"The addition has been successful!");
				for(int i=0; i < Person.personlist.size(); i++) {
					if (Person.personlist.get(i).getAMKA() == findAMKA.getAmka()) {
				Hospital.icuUpdate(Person.personlist.get(i), true);
				frame.dispose();
				Options.options();
					}
				}
				}else {
					JOptionPane.showMessageDialog(frame,"The patient doesnt need Icu at the moment");
					frame.dispose();
					Options.options();
				}
			}
		});
		btnSubmit.setBounds(160, 203, 97, 25);
		frame.getContentPane().add(btnSubmit);
		True.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(True.isSelected()) {
					False.setSelected(false);
				}
			}
		});
		False.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(False.isSelected()) {
					True.setSelected(false);
				}
			}
		});
	}
}
