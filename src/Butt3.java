import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 569, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your password ");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPleaseEnterYour.setBounds(105, 75, 334, 36);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Password.setBounds(92, 184, 159, 16);
		frame.getContentPane().add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(307, 185, 145, 16);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String psd = passwordField.getText();
				if (psd.equals("104")) {
					JOptionPane.showMessageDialog(frame,"You are succesfully logined");
				}else {
					JOptionPane.showMessageDialog(frame,"Invalid password");
					
				}
			}
		});
		btnLogin.setBounds(197, 259, 97, 25);
		frame.getContentPane().add(btnLogin);
	}
}
