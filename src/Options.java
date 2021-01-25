import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Options {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void options() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options window = new Options();
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
	public Options() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton option1 = new JRadioButton("Is there a new case that needs icu?");

		option1.setBounds(56, 45, 231, 25);
		frame.getContentPane().add(option1);
		
		JRadioButton option2 = new JRadioButton("Is there a new Icu open?");
		option2.setBounds(56, 85, 183, 25);
		frame.getContentPane().add(option2);
		
		JRadioButton option3 = new JRadioButton("Show the availability of the Icus of all the hospitals");
		option3.setBounds(55, 125, 383, 25);
		frame.getContentPane().add(option3);
		
		JRadioButton option4 = new JRadioButton("Show the list of the person that have been entranced in Icu");
		option4.setBounds(56, 165, 410, 25);
		frame.getContentPane().add(option4);
		
		JButton btnNewButton = new JButton("Submit");
	
		btnNewButton.setBounds(214, 285, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JRadioButton option5 = new JRadioButton("Go to main menu ");
		option5.setBounds(56, 206, 183, 25);
		frame.getContentPane().add(option5);
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(option1.isSelected()) {
					option2.setSelected(false);
					option3.setSelected(false);
					option4.setSelected(false);
					option5.setSelected(false);
				}
	
			}
		});
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(option2.isSelected()) {
					option1.setSelected(false);
					option3.setSelected(false);
					option4.setSelected(false);
					option5.setSelected(false);
				}
			}
		});
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(option3.isSelected()) {
					option1.setSelected(false);
					option2.setSelected(false);
					option4.setSelected(false);
					option5.setSelected(false);
				}
			}
		});
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(option4.isSelected()) {
					option1.setSelected(false);
					option2.setSelected(false);
					option3.setSelected(false);
					option5.setSelected(false);
				}
			}
		});
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(option5.isSelected()) {
					option1.setSelected(false);
					option2.setSelected(false);
					option3.setSelected(false);
					option4.setSelected(false);
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(option1.isSelected()) {
					Option1 opt1 = new Option1();
					opt1.option1();
					frame.dispose();
				}else if(option2.isSelected()) {
					Option2 opt2 = new Option2();
					opt2.option2();
					frame.dispose();
				}else if(option3.isSelected()) {
					JOptionPane.showMessageDialog(frame, Hospital.showAvailability());
				}else if(option4.isSelected()){
			
					JOptionPane.showMessageDialog(frame, Hospital.showEntranced());	
				} else {
					Gui.graph();
					frame.dispose();
				}
			}
		});
}
}
