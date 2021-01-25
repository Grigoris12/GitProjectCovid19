import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


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
						try
				        {
				            FileInputStream fis = new FileInputStream("persondata");
				            ObjectInputStream ois = new ObjectInputStream(fis);
				 
				            Person.personlist = (ArrayList) ois.readObject();
				 
				            ois.close();
				            fis.close();
				        } 
				        catch (IOException ioe) 
				        {
				            ioe.printStackTrace();
				            return;
				        } 
				        catch (ClassNotFoundException c) 
				        {
				            System.out.println("Class not found");
				            c.printStackTrace();
				            return;
				        } 
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
						
						try
				        {
				            FileInputStream fis = new FileInputStream("persondata");
				            ObjectInputStream ois = new ObjectInputStream(fis);
				 
				            Person.personlist = (ArrayList) ois.readObject();
				 
				            ois.close();
				            fis.close();
				        } 
				        catch (IOException ioe) 
				        {
				            ioe.printStackTrace();
				            return;
				        } 
				        catch (ClassNotFoundException c) 
				        {
				            System.out.println("Class not found");
				            c.printStackTrace();
				            return;
				        } 
						try
				        {
				            FileInputStream fis = new FileInputStream("hospital_icus");
				            ObjectInputStream ois = new ObjectInputStream(fis);
				 
				            Hospital.entrancedPerson = (ArrayList) ois.readObject();
				 
				            ois.close();
				            fis.close();
				        } 
				        catch (IOException ioe) 
				        {
				            ioe.printStackTrace();
				            return;
				        } 
				        catch (ClassNotFoundException c) 
				        {
				            System.out.println("Class not found");
				            c.printStackTrace();
				            return;
				        }
						try
				        {
				            FileInputStream fis = new FileInputStream("deadPerson");
				            ObjectInputStream ois = new ObjectInputStream(fis);
				 
				            Hospital.deadPerson = (ArrayList) ois.readObject();
				 
				            ois.close();
				            fis.close();
				        } 
				        catch (IOException ioe) 
				        {
				            ioe.printStackTrace();
				            return;
				        } 
				        catch (ClassNotFoundException c) 
				        {
				            System.out.println("Class not found");
				            c.printStackTrace();
				            return;
				        }
						try
				        {
				            FileInputStream fis = new FileInputStream("alivePerson");
				            ObjectInputStream ois = new ObjectInputStream(fis);
				 
				            Hospital.alivePerson = (ArrayList) ois.readObject();
				 
				            ois.close();
				            fis.close();
				        } 
				        catch (IOException ioe) 
				        {
				            ioe.printStackTrace();
				            return;
				        } 
				        catch (ClassNotFoundException c) 
				        {
				            System.out.println("Class not found");
				            c.printStackTrace();
				            return;
				        }
						
						Butt2.window2();
						frame.setVisible(false);
					}
				});
				btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton_1.setBounds(124, 104, 174, 23);
				frame.getContentPane().add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("Log in (Hospital Manager only)");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						Butt3.Butt3();
					}
				});
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnNewButton_2.setBounds(90, 138, 247, 23);
				frame.getContentPane().add(btnNewButton_2);
				
				JButton btnInformationAboutThe = new JButton("Information about the hospitals");
				btnInformationAboutThe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						Butt4.butt4();
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


