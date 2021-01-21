import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Butt1 {

	private JFrame frame;
	private JTextField nametext;
	private JTextField surnametext;
	private JTextField daytext;
	private JTextField monthtext;
	private JTextField yeartext;
	private JTextField amkatext;

	/**
	 * Launch the application.
	 */
	public static void butt1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butt1 window = new Butt1();
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
	public Butt1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :\r\n");
		lblNewLabel.setBounds(31, 34, 124, 14);
		frame.getContentPane().add(lblNewLabel);
		
		nametext = new JTextField();
		nametext.setBounds(352, 31, 126, 20);
		frame.getContentPane().add(nametext);
		nametext.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Surname :");
		lblNewLabel_5.setBounds(31, 60, 124, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		surnametext = new JTextField();
		surnametext.setBounds(352, 57, 126, 20);
		frame.getContentPane().add(surnametext);
		surnametext.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Age :\r\n");
		lblNewLabel_1.setBounds(31, 86, 124, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextField agetext = new JTextField();
		agetext.setBounds(352, 83, 126, 20);
		frame.getContentPane().add(agetext);
		agetext.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender :");
		lblNewLabel_4.setBounds(31, 113, 124, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(342, 110, 73, 23);
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(420, 110, 96, 23);
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFemale.isSelected()) {
					rdbtnMale.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnFemale);
		
		
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnMale.isSelected()) {
					rdbtnFemale.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnMale);
		

		
		JLabel lblNewLabel_2 = new JLabel("Region :");
		lblNewLabel_2.setBounds(31, 141, 124, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(352, 138, 126, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Athens", "Thessaloniki", "Larisa", "Xania", "Patra", "Komotini", "Alexandroupoli", "Kalamata", "Giannena"}));
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Test day :\r\n");
		lblNewLabel_3.setBounds(31, 167, 124, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		daytext = new JTextField();
		daytext.setBounds(352, 164, 126, 20);
		frame.getContentPane().add(daytext);
		daytext.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Test month :");
		lblNewLabel_8.setBounds(31, 193, 124, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		monthtext = new JTextField();
		monthtext.setBounds(352, 190, 126, 20);
		frame.getContentPane().add(monthtext);
		monthtext.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Test year :");
		lblNewLabel_6.setBounds(31, 219, 124, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		yeartext = new JTextField();
		yeartext.setBounds(352, 216, 126, 20);
		frame.getContentPane().add(yeartext);
		yeartext.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("AMKA :");
		lblNewLabel_7.setBounds(31, 245, 124, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		amkatext = new JTextField();
		amkatext.setBounds(352, 242, 126, 20);
		frame.getContentPane().add(amkatext);
		amkatext.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Test COVID-19(positive) :");
		lblNewLabel_9.setBounds(31, 272, 203, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JRadioButton rdbtnFalse = new JRadioButton("false");
		rdbtnFalse.setBounds(414, 268, 96, 23);
		JRadioButton rdbtnTrue = new JRadioButton("true\r\n");
		rdbtnTrue.setBounds(342, 268, 70, 23);
		rdbtnTrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTrue.isSelected()) {
					 rdbtnFalse.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnTrue);
		
		
		rdbtnFalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFalse.isSelected()) {
					 rdbtnTrue.setSelected(false);
				}
			}
		});
		frame.getContentPane().add(rdbtnFalse);
		
		JButton btnSumbit = new JButton("Submit");
		btnSumbit.setBounds(299, 294, 96, 23);
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				String ageinput = agetext.getText();
				int k = 0;
				int i = 0; 
				int j = 0;
				String monthinput = monthtext.getText();
				if(!nametext.getText().matches("^[a-zA-Z]+$")) {
					JOptionPane.showMessageDialog(frame,"Invalid name ");
				}
				if (!surnametext.getText().matches("^[a-zA-Z]+$")){
					JOptionPane.showMessageDialog(frame,"Invalid surname ");
				}
				try {
					int z = Integer.parseInt(ageinput);
					if (z<0 || z>110) {
						JOptionPane.showMessageDialog(frame,"Invalid age ");
						k++;
					}
				}catch(NumberFormatException es) {
					JOptionPane.showMessageDialog(frame,"Invalid age ");
					k++;
				}
				if (rdbtnMale.isSelected()){
					j++;
				}
				if (rdbtnFemale.isSelected()) {
					j++;
				}
				if( j == 0) {
					JOptionPane.showMessageDialog(frame,"Select gender");
				}
				String dayinput = daytext.getText();
				try {
					int y = Integer.parseInt(dayinput);
					if (y>31 || y<=0) {
						JOptionPane.showMessageDialog(frame,"Invalid day insert");
						k++;
					}
				}catch(NumberFormatException es) {
					JOptionPane.showMessageDialog(frame,"Invalid day insert");
					k++;
				}
				try {
					int x = Integer.parseInt(monthinput);
					if (x>12 || x<=0 ) {
						JOptionPane.showMessageDialog(frame,"Invalid month insert");
						k++;
					}
				}catch(NumberFormatException es) {
					JOptionPane.showMessageDialog(frame,"Invalid month insert");
					k++;
				}
				String yearinput = yeartext.getText();
				try {
					int x = Integer.parseInt(yearinput);
					if (x < 2019 || x>2023) {
						JOptionPane.showMessageDialog(frame,"Invalid year insert");
						k++;
					}
				}catch(NumberFormatException es) {
					JOptionPane.showMessageDialog(frame,"Invalid year insert");
					k++;
				}
				String amkainput = amkatext.getText();
				try {
					int x = Integer.parseInt(amkainput);
				}catch(NumberFormatException es) {
					JOptionPane.showMessageDialog(frame,"Invalid amka insert");
					k++;
				}
				
				if (rdbtnFalse.isSelected()) {
					i++;
				}
				if (rdbtnTrue.isSelected()) {
					i++;
				}
				if (i == 0) {
					JOptionPane.showMessageDialog(frame,"Select true or false");
				}
				Gui.graph();
				if (!surnametext.getText().matches("^[a-zA-Z]+$") ||!nametext.getText().matches("^[a-zA-Z]+$") || i!=1 || j!=1 || k!=0){
					JOptionPane.showMessageDialog(frame,"Invalid inserts, try again");
				}else {
					JOptionPane.showMessageDialog(frame,"Successfully added");
					String nameInput = nametext.getText();
					String surnameInput = surnametext.getText();
					int age = Integer.parseInt(ageinput);
					int month = Integer.parseInt(monthinput);
					int day = Integer.parseInt(dayinput);
					int year = Integer.parseInt(yearinput);
					int amka = Integer.parseInt(amkainput);
					String gender = "male";
					if(rdbtnMale.isSelected()) {
						gender = "male";
					} else if(rdbtnFemale.isSelected()) {
						gender = "female";
					}
					String region = comboBox.getName();
					boolean test = true;
					if(rdbtnTrue.isSelected()) {
						test = true;
					} else if(rdbtnFalse.isSelected()) {
						test = false;
					}
					Person p = new Person(nameInput , surnameInput, age ,gender , region, day, month, year, amka,test );
					
					File f = new File("persondata");
					try {
						f.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
					try
			        {
						FileOutputStream fos = new FileOutputStream(f,false);
			            ObjectOutputStream oos = new ObjectOutputStream(fos);
			            oos.writeObject(Person.personlist);
			            oos.close();
			            fos.close();
			            
			        } 
			        catch (IOException ioe) 
			        {
			            ioe.printStackTrace();
			        }
					
					
				}
			}
		});
		frame.getContentPane().add(btnSumbit);
		
		JButton btnNewButton = new JButton("Go to main menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Gui.graph();
			}
		});
		btnNewButton.setBounds(97, 293, 154, 25);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}