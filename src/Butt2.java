import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

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
			public void actionPerformed(ActionEvent e) {

				if(comboBox.getSelectedItem().equals("1)Printing the symptoms of Covid19")) {
					JOptionPane.showMessageDialog(frame,CovidInformation.covidSymptoms());
				}else if(comboBox.getSelectedItem().equals("2)Printing the instructions for protecting from Covid19")) {
					JOptionPane.showMessageDialog(frame,CovidInformation.covidGuide());
					
				} else if(comboBox.getSelectedItem().equals("3)Printing the instructions if you have symptoms of Covid19")) {
					JOptionPane.showMessageDialog(frame,CovidInformation.instructionsForInfected());
				
				} else if(comboBox.getSelectedItem().equals("4)Printing the number of people infected by Covid19 a specific day")) {
					Butt2_4.window2_4();
					frame.setVisible(false);
				
				} else if(comboBox.getSelectedItem().equals("5)Printing total people infected by Covid19")) {
					//
					
				} else if(comboBox.getSelectedItem().equals("6)Printing the deaths from Covid19 on a specific day")) {
					
				} else if (comboBox.getSelectedItem().equals("7)Printing total deaths from Covid19")) {
					JOptionPane.showMessageDialog(frame, "Total deaths in Greece are " + Hospital.getNumberDead());
					
				} else if (comboBox.getSelectedItem().equals("8)Printing the percentage of mortality")) {
					//JOptionPane.showMessageDialog(frame, Statistics.mortalityrate());
					
				} else if (comboBox.getSelectedItem().equals("9)Printing the number of people infected by Covid19" + 
						 "that are into icus")) {
					JOptionPane.showMessageDialog(frame, "The number of people infected by Covid19 that are into icus is " 
				    + (int)(Hospital.getTotalIcuCases() - Hospital.getNumberAlive() - Hospital.getNumberDead()));
					
				} else if (comboBox.getSelectedItem().equals("10)Printing the percentage of people infected by Covid19 that" + 
						"have enter icus")) {
					
				} else if (comboBox.getSelectedItem().equals("11)Printing the percentage of people infected by Covid19 that" + 
						"have exit icus")) {
					
				} else if (comboBox.getSelectedItem().equals("12)Printing the available icus of every hospital")){
					//JOptionPane.showMessageDialog(frame, "Hospital Availability:" + Hospital.showAvailability());
				
				} else if (comboBox.getSelectedItem().equals("13)Printing the percentage of female and male infected by Covid19")){
					//JOptionPane.showMessageDialog(frame, Statistics.gendercount());
					
				} else if (comboBox.getSelectedItem().equals("14)Printing the percentage of infections in every city right now")){
					Statistics.regionnames();
		            Statistics.infperregioninitialise();
					Statistics.countinfperregion();
		            Statistics.infrateperregion();
		            JOptionPane.showMessageDialog(frame, "The region with the most infections is " +  Statistics.mostinfregion());
					
				} else if (comboBox.getSelectedItem().equals("15)Printing the month with the most infections")) {
					Statistics.countinfpermonth();
					Statistics.infratepermonth();
					Statistics.mostinfmonth();
					JOptionPane.showMessageDialog(frame, "The month with the most infections is " + Statistics.mostinfmonth());
					
				} else if (comboBox.getSelectedItem().equals("16)Printing the percentage of infections per season")){
					Statistics.infpermonthinitialise();
					Statistics.countinfpermonth();
					Statistics.infratepermonth();
					Statistics.infrateperseason();
					Statistics.seasonPercentages();
					JOptionPane.showMessageDialog(frame, "The season with the most infections is " + Statistics.mostinfseason());
					
				} else if (comboBox.getSelectedItem().equals("17)Printing the percentage of infections in age category")){
					
				} 
	
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