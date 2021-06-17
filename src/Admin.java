import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Admin {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 781, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton2 = new JButton("Sign Out");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AdminLogIn().frame.setVisible(true);
				frame.dispose();			
			}
		});
		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setBackground(new Color(255, 140, 0));
		btnNewButton2.setBounds(664, 445, 91, 36);
		frame.getContentPane().add(btnNewButton2);
		
		JLabel lblNewLabel = new JLabel("Admin Section");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 11, 745, 90);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("List Contesters");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setBounds(293, 286, 188, 66);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("List Teachers");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton1.setBackground(new Color(255, 140, 0));
		btnNewButton1.setBounds(293, 186, 188, 66);
		frame.getContentPane().add(btnNewButton1);
	}

}
