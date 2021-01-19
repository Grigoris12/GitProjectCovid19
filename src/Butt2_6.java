import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Butt2_6 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void window2_6() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Butt2_6 window = new Butt2_6();
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
	public Butt2_6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 205);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDate = new JLabel("Date (DD/MM/YYYY) :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(36, 67, 168, 14);
		frame.getContentPane().add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(287, 66, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSumbit = new JButton("Sumbit");
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date = textField.getText();
				JOptionPane.showMessageDialog(frame,"Total deaths in Greece on " + date + " are " + Hospital.deadInADay(date));
			}
		});
		btnSumbit.setBounds(252, 115, 89, 23);
		frame.getContentPane().add(btnSumbit);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gui.graph();
				frame.setVisible(false);
			}
		});
		btnMainMenu.setBounds(86, 115, 118, 23);
		frame.getContentPane().add(btnMainMenu);
	}

}
