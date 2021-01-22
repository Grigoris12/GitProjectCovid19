import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class findAMKA {
	private static int amka;
	public static int getAmka() {
		return amka;
	}
	private JFrame frame;
	private JTextField amkatext;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void amka() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					findAMKA window = new findAMKA();
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
	public findAMKA() {
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
		
		JLabel lblInsertAmkaTo = new JLabel("Insert AMKA to find the person you want :");
		lblInsertAmkaTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsertAmkaTo.setBounds(24, 31, 408, 92);
		frame.getContentPane().add(lblInsertAmkaTo);
		
		amkatext = new JTextField();
		amkatext.setBounds(98, 136, 220, 22);
		frame.getContentPane().add(amkatext);
		amkatext.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f2 = new File("hospital_icus");
				try {
					f2.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				String amkainput = amkatext.getText();
				amka = Integer.parseInt(amkainput); 
				int x = Integer.parseInt(amkainput);
				int o = 1;  
				for(int i=0; i < Person.personlist.size(); i++) {
					if (Person.personlist.get(i).getAMKA() == x ) {
						o = 0;
						try
				        {
							FileOutputStream fos = new FileOutputStream(f2,false);
				            ObjectOutputStream oos = new ObjectOutputStream(fos);
				            oos.writeObject(Person.personlist.get(i));
				            oos.close();
				            fos.close();
				            
				        } 
				        catch (IOException ioe) 
				        {
				            ioe.printStackTrace();
				        }
					}
				}
				if (o == 0) {
					Options opt = new Options();
					opt.options();
					frame.setVisible(false);
				} else { 
					JOptionPane.showMessageDialog(frame,"There's no patient with COVID-19 with that AMKA");
				}
			}
		});
		btnSubmit.setBounds(246, 194, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("Go to Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui.graph();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(61, 194, 146, 25);
		frame.getContentPane().add(btnNewButton);
			
	}
}
