import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Butt3 {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void Butt3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butt3 window = new Butt3();
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
	public Butt3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame();
		frame.setBounds(100, 100, 492, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your password ");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPleaseEnterYour.setBounds(66, 37, 334, 36);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Password.setBounds(66, 135, 159, 16);
		frame.getContentPane().add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 138, 145, 16);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String psd = passwordField.getText();
				if (psd.equals("104")) {
					JOptionPane.showMessageDialog(frame,"You are succesfully logined");
					frame.setVisible(false);
					findAMKA f = new findAMKA();
					f.amka();
					
				}else {
					JOptionPane.showMessageDialog(frame,"Invalid password");
					
				}
			}
		});
		btnLogin.setBounds(251, 209, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnGoToMain = new JButton("Go to Main Menu");
		btnGoToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui.graph();
				frame.dispose();
			}
		});
		btnGoToMain.setBounds(74, 209, 145, 25);
		frame.getContentPane().add(btnGoToMain);
	}
}
