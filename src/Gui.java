import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void graph() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
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
		frame.getContentPane().setLayout(null);
				
				JButton btnNewButton = new JButton("Sign-up\r\n");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Butt1.butt1();
						frame.setVisible(false);
					}
				});
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton.setBounds(170, 70, 89, 23);
				frame.getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Covid Information\r\n");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Butt2.window2();
						frame.setVisible(false);
					}
				});
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton_1.setBounds(124, 104, 174, 23);
				frame.getContentPane().add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("Log in (Hospital Manager only)");
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton_2.setBounds(90, 138, 247, 23);
				frame.getContentPane().add(btnNewButton_2);
				
				JButton btnInformationAboutThe = new JButton("Information about the hospitals");
				btnInformationAboutThe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Butt4.butt4();
						frame.setVisible(false);
					}
				});
				btnInformationAboutThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnInformationAboutThe.setBounds(90, 172, 247, 23);
				frame.getContentPane().add(btnInformationAboutThe);
				
				JLabel lblMainMenu = new JLabel("Main Menu");
				lblMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 25));
				lblMainMenu.setBounds(155, 11, 150, 31);
				frame.getContentPane().add(lblMainMenu);
			}
		
	}


