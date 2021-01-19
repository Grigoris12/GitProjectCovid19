	
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Butt4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void butt4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butt4 window = new Butt4();
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
	public Butt4() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(46, 89, 358, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Σωτηρία(Αθήνα)", "Γ.Γεννηματά(Αθήνα)", "Αττικόν(Αθήνα)", "Βουγιουκλάκειο(Αθήνα)", "ΚΑΤ(Αθήνα)", "Ευαγγελισμός(Αθήνα)", "Ιπποκράτειο(Θεσσαλονίκη)", "ΑΧΕΠΑ(Θεσσαλονίκη)", "Άγιος Δημήτριος(Θεσσαλονίκη)", "Γ.Γεννηματά Θεσσαλονίκης", "Άγιος Λουκάς(Θεσσαλονίκη)", "Άγιος Γεώργιος(Χανιά)", "Γενικό Νοσοκομείο Λάρισας", "ΚΟΥΤΛΙΜΠΑΝΙΟ & ΤΡΙΑΝΤΑΦΥΛΛΕΙΟ Νοσοκομείο(Λάρισα)", "Άγιος Ανδρέας(Πάτρα)", "Πανεπιστημιακό Γενικό Νοσοκομείο(Πάτρα)", "ΧΑΤΖΗΚΩΣΤΑ(Ιωάννινα)", "Πανεπιστημιακό Νοσοκομείο Ιωαννίνων", "Γενικό Νοσοκομείο Καλαμάτας", "Πανεπιστημιακό Γενικό Νοσοκομείο Αλεξανδρούπολης", "Σισμανόγλειο(Κομοτηνή)"}));
		frame.getContentPane().add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(309, 87, 10, 10);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Σωτηρία(Αθήνα)")) {
					JOptionPane.showMessageDialog(frame, "The website of Hospital Σωτηρία is http://www.sotiria.gr/");
				} else if (comboBox.getSelectedItem().equals("Γ.Γεννηματά(Αθήνα)")) {
					JOptionPane.showMessageDialog(frame, "The website of Hospital Γ.Γεννηματά is http://www.gna-gennimatas.gr/");
			    } else if (comboBox.getSelectedItem().equals("Αττικόν(Αθήνα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Αττικόν is http://www.attikonhospital.gr/ ");
			    } else if (comboBox.getSelectedItem().equals("Βουγιουκλάκειο(Αθήνα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Βουγιουκλάκειο  is https://vougiouklakio.gr/web/");
			    } else if (comboBox.getSelectedItem().equals("ΚΑΤ(Αθήνα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital ΚΑΤ  is https://www.kat-hosp.gr/");
			    } else if (comboBox.getSelectedItem().equals("Ευαγγελισμός(Αθήνα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Ευαγγελισμός is https://www.evaggelismos-hosp.gr/");
			    } else if (comboBox.getSelectedItem().equals("Ιπποκράτειο(Θεσσαλονίκη)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Ιπποκράτειο is http://www.ippokratio.gr/");
			    } else if (comboBox.getSelectedItem().equals("ΑΧΕΠΑ(Θεσσαλονίκη)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital ΑΧΕΠΑ  is http://www.ahepahosp.gr/");
			    } else if (comboBox.getSelectedItem().equals("Άγιος Δημήτριος(Θεσσαλονίκη)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Άγιος Δημήτριος is http://www.oagiosdimitrios.gr/");
			    } else if (comboBox.getSelectedItem().equals("Γ.Γεννηματά Θεσσαλονίκης")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Γ.Γεννηματά Θεσσαλονίκης is http://www.gennimatas-thess.gr/");
			    } else if (comboBox.getSelectedItem().equals("Άγιος Λουκάς(Θεσσαλονίκη)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Άγιος Λουκάς is http://www.klinikiagiosloukas.gr/");
			    } else if (comboBox.getSelectedItem().equals("Άγιος Γεώργιος(Χανιά)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Άγιος Γεώργιος is http://www.chaniahospital.gr/");
			    } else if (comboBox.getSelectedItem().equals("Γενικό Νοσοκομείο Λάρισας")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Γενικό Νοσοκομείο Λάρισας  is http://www.uhl.gr/");
			    } else if (comboBox.getSelectedItem().equals("ΚΟΥΤΛΙΜΠΑΝΙΟ & ΤΡΙΑΝΤΑΦΥΛΛΕΙΟ Νοσοκομείο(Λάρισα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital ΚΟΥΤΛΙΜΠΑΝΙΟ & ΤΡΙΑΝΤΑΦΥΛΛΕΙΟ Νοσοκομείο is http://www.ghl.gr/gnl.php");
			    } else if (comboBox.getSelectedItem().equals("Άγιος Ανδρέας(Πάτρα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Άγιος Ανδρέας is http://www.agandreashosp.gr/");
			    } else if (comboBox.getSelectedItem().equals("Πανεπιστημιακό Γενικό Νοσοκομείο(Πάτρα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Πανεπιστημιακό Γενικό Νοσοκομείο  is https://www.pgnp.gr/");
			    } else if (comboBox.getSelectedItem().equals("ΧΑΤΖΗΚΩΣΤΑ(Ιωάννινα)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital ΧΑΤΖΗΚΩΣΤΑ  is https://www.gni-hatzikosta.gr/");
			    } else if (comboBox.getSelectedItem().equals("Πανεπιστημιακό Νοσοκομείο Ιωαννίνων")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Πανεπιστημιακό Νοσοκομείο Ιωαννίνων is https://www.uhi.gr/");
			    } else if (comboBox.getSelectedItem().equals("Γενικό Νοσοκομείο Καλαμάτας")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Γενικό Νοσοκομείο Καλαμάτας is https://www.nosokomeiokalamatas.gr/");
			    } else if (comboBox.getSelectedItem().equals("Πανεπιστημιακό Γενικό Νοσοκομείο Αλεξανδρούπολης")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Πανεπιστημιακό Γενικό Νοσοκομείο Αλεξανδρούπολης is https://pgna.gr/");
			    } else if (comboBox.getSelectedItem().equals("Σισμανόγλειο(Κομοτηνή)")) {
			    	JOptionPane.showMessageDialog(frame, "The website of Hospital Σισμανόγλειο is http://www.komotini-hospital.gr/");
			    } 
		}
		});
		btnNewButton.setBounds(160, 171, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Choose the hospital that you want information");
		lblNewLabel.setBounds(72, 31, 273, 16);
		frame.getContentPane().add(lblNewLabel);
	}
}
