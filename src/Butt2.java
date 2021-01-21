import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;


public class Butt2 {

	private JFrame frame, frame2;

	/**
	 * Launch the application.
	 */
	public static void window2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butt2 window = new Butt2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	
	/**
	 * Create the application.
	 */
	public Butt2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 563, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCovid = new JLabel("Choose from 1 to 17\r\n");
		lblCovid.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCovid.setBounds(146, 40, 287, 41);
		frame.getContentPane().add(lblCovid);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1)Printing the symptoms of Covid19", "2)Printing the instructions for protecting from Covid19", "3)Printing the instructions if you have symptoms of Covid19", "4)Printing the number of people infected by Covid19 a specific day", "5)Printing total people infected by Covid19", "6)Printing the deaths from Covid19 on a specific day", "7)Printing total deaths from Covid19", "8)Printing the percentage of mortality", "9)Printing the number of people infected by Covid19 that are into icus", "10)Printing the percentage of people infected by Covid19 that have enter icus", "11)Printing the percentage of people infected by Covid19 that have exit icus", "12)Printing the available icus of every hospital", "13)Printing the percentage of female and male infected by Covid19", "14)Printing the percentage of infections in every city right now", "15)Printing the month with the most infections", "16)Printing the percentage of infections per season", "17)Printing the percentage of infections in age category"}));
		comboBox.setBounds(51, 143, 437, 41);
		frame.getContentPane().add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			// 	implementation of the menu and the different choices
			public void actionPerformed(ActionEvent e) {
				//Deserialize list//
			/*	try
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
		        } */
				// first choice
				if(comboBox.getSelectedItem().equals("1)Printing the symptoms of Covid19")) {
					JOptionPane.showMessageDialog(frame,CovidInformation.covidSymptoms());
					
				// second choice
				}else if(comboBox.getSelectedItem().equals("2)Printing the instructions for protecting from Covid19")) {
					JOptionPane.showMessageDialog(frame,CovidInformation.covidGuide());
				
				// third choice
				} else if(comboBox.getSelectedItem().equals("3)Printing the instructions if you have symptoms of Covid19")) {
					JOptionPane.showMessageDialog(frame,CovidInformation.instructionsForInfected());
				
				// fourth choice
				} else if(comboBox.getSelectedItem().equals("4)Printing the number of people infected by Covid19 a specific day")) {
					Butt2_4.window2_4();
					frame.setVisible(false);
				
				
				// fifth choice
				} else if(comboBox.getSelectedItem().equals("5)Printing total people infected by Covid19")) {
					Butt2_5.window2_5();
					frame.setVisible(false);
					
				// sixth choice
				} else if(comboBox.getSelectedItem().equals("6)Printing the deaths from Covid19 on a specific day")) {
					Butt2_6.window2_6();
					frame.setVisible(false);
					
				// seventh choice
				} else if (comboBox.getSelectedItem().equals("7)Printing total deaths from Covid19")) {
					JOptionPane.showMessageDialog(frame, "Total deaths in Greece are " + Hospital.getNumberDead());
				
				// eigth choice
				} else if (comboBox.getSelectedItem().equals("8)Printing the percentage of mortality")) {
					double pdeath = Hospital.getNumberDead()/ Statistics.getTotalInfections()* 100; 
					JOptionPane.showMessageDialog(frame,"The mortality rate of Covid19 is " + df2.format(pdeath) + "%");
					
				// ninth choice
				} else if (comboBox.getSelectedItem().equals("9)Printing the number of people infected by Covid19" + 
						 " that are into icus")) {
						JOptionPane.showMessageDialog(frame, "The number of people infected by Covid19 that are into icus is " 
								+ (int)(Hospital.getTotalIcuCases() - Hospital.getNumberAlive() - Hospital.getNumberDead()));
				
				// tenth choice
				} else if (comboBox.getSelectedItem().equals("10)Printing the percentage of people infected by Covid19 that have enter icus")) {
					double pentrance = Hospital.getTotalIcuCases() / Statistics.getTotalInfections()* 100; 
					JOptionPane.showMessageDialog(frame,df2.format(pentrance) + " % of the confirmed cases needed icu");
					
				// eleventh choice
				} else if (comboBox.getSelectedItem().equals("11)Printing the percentage of people infected by Covid19 that have exit icus")) {
					double pexit = Hospital.getNumberAlive()/Hospital.getTotalIcuCases() * 100; 
					JOptionPane.showMessageDialog(frame, df2.format(pexit) + " % of people infected by Covid 19 have exit icus ");
					
				// twelfth choice
				} else if (comboBox.getSelectedItem().equals("12)Printing the available icus of every hospital")){
					JOptionPane.showMessageDialog(frame, Hospital.showAvailability());
					
					
				// thirteenth choice
				} else if (comboBox.getSelectedItem().equals("13)Printing the percentage of female and male infected by Covid19")){
					Statistics.gendercount();
					JOptionPane.showMessageDialog(frame, df2.format(Statistics.getPmale()) + " % of people infected by Covid 19 have exit icus \r\n" 
						+	df2.format(Statistics.getPfemale()) + " % of the confirmed cases are female");
					
				// forteenth choice
				} else if (comboBox.getSelectedItem().equals("14)Printing the percentage of infections in every city right now")){
					Statistics.regionnames();
		            Statistics.infperregioninitialise();
					Statistics.countinfperregion();
		            Statistics.infrateperregion();
		            JOptionPane.showMessageDialog(frame, "The region with the most infections is " +  Statistics.mostinfregion());
					
		        // fifteenth choice
				} else if (comboBox.getSelectedItem().equals("15)Printing the month with the most infections")) {
					Statistics.countinfpermonth();
					Statistics.infratepermonth();
					Statistics.mostinfmonth();
					JOptionPane.showMessageDialog(frame, "The month with the most infections is " + Statistics.mostinfmonth());
					
				// sixteenth choice
				} else if (comboBox.getSelectedItem().equals("16)Printing the percentage of infections per season")){
					Statistics.infpermonthinitialise();
					Statistics.countinfpermonth();
					Statistics.infratepermonth();
					Statistics.infrateperseason();
					Statistics.seasonPercentages();
					JOptionPane.showMessageDialog(frame, "The season with the most infections is " + Statistics.mostinfseason() + "\r\n" 
									+ df2.format(Statistics.getPwinter()) + "% of the confirmed cases appeared in winter \r\n" 
									+ df2.format(Statistics.getPspring()) + "% of the confirmed cases appeared in spring \r\n"
									+ df2.format(Statistics.getPsummer()) + "% of the confirmed cases appeared in summer \r\n"
									+ df2.format(Statistics.getPautumn()) + "% of the confirmed cases appeared in autumn");
				
				// seventeenth choice
				} else if (comboBox.getSelectedItem().equals("17)Printing the percentage of infections in age category")){
					Statistics.ageofPatients();
					JOptionPane.showMessageDialog(frame,df2.format(Statistics.getPkids()) + "% of the confirmed cases are kids\r\n"
							+ df2.format(Statistics.getPadults()) + "% of the confirmed cases are adults\r\n"
							+ df2.format(Statistics.getPelders()) + "% of the confirmed cases are elders");
				} 
				// back to main menu
				if(comboBox.getSelectedItem().equals("18)Go to main menu")) {
					Gui.graph();
					frame.setVisible(false);
				}
			}
		});
		btnSubmit.setBounds(296, 220, 110, 23);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnNewButton = new JButton("Go to Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui.graph();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(110, 219, 129, 25);
		frame.getContentPane().add(btnNewButton);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

