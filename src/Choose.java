import java.awt.EventQueue;
import javax.swing.JFrame;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.JRadioButton;


public class Choose {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					Choose window = new Choose();
					window.frame.setVisible(true);		
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Choose() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new java.awt.Color(0, 0, 205));
		frame.getContentPane().setForeground(new java.awt.Color(255, 255, 240));
		frame.setBounds(100, 100, 758, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcome = new JLabel("WELCOME TO TEST ME");
		welcome.setForeground(new java.awt.Color(255, 255, 240));
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 50));
		welcome.setBackground(java.awt.Color.BLACK);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBounds(10, 33, 722, 82);
		frame.getContentPane().add(welcome);
		
		JButton teacher = new JButton("Teacher");
		teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherLogIn t = new TeacherLogIn();
				t.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		teacher.setForeground(new java.awt.Color(255, 255, 255));
		teacher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		teacher.setBackground(new java.awt.Color(255, 140, 0));
		teacher.setBounds(281, 177, 166, 82);
		frame.getContentPane().add(teacher);
		
		JButton student = new JButton("Student");
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserChoose c = new UserChoose();
				c.frame.setVisible(true);
				frame.dispose();				
			}
		});
		
		student.setForeground(new java.awt.Color(255, 255, 255));
		student.setFont(new Font("Tahoma", Font.PLAIN, 20));
		student.setBackground(new java.awt.Color(255, 140, 0));
		student.setBounds(281, 304, 166, 82);
		frame.getContentPane().add(student);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
			}
		});
		btnNewButton.setBackground(new java.awt.Color(255, 140, 0));
		btnNewButton.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(634, 465, 98, 40);
		frame.getContentPane().add(btnNewButton);
		frame.setLocationRelativeTo(null);
		
}
}
