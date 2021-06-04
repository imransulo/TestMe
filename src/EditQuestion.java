import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditQuestion {

	private JFrame frame;
	private JTextField oldQuestion;
	private JTextField newQuestion;
	private JTextField first;
	private JTextField second;
	private JTextField third;
	private JTextField fourth;
	private JTextField correct;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditQuestion window = new EditQuestion();
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
	public EditQuestion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 788, 673);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Question");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 23, 752, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Old question:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 123, 135, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		oldQuestion = new JTextField();
		oldQuestion.setBounds(132, 129, 539, 35);
		frame.getContentPane().add(oldQuestion);
		oldQuestion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New question:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 186, 135, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		newQuestion = new JTextField();
		newQuestion.setBounds(132, 193, 539, 35);
		frame.getContentPane().add(newQuestion);
		newQuestion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("First alternative:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 252, 135, 42);
		frame.getContentPane().add(lblNewLabel_3);
		
		first = new JTextField();
		first.setBounds(163, 256, 508, 35);
		frame.getContentPane().add(first);
		first.setColumns(10);
		
		second = new JTextField();
		second.setBounds(163, 309, 508, 35);
		frame.getContentPane().add(second);
		second.setColumns(10);
		
		third = new JTextField();
		third.setBounds(163, 365, 508, 35);
		frame.getContentPane().add(third);
		third.setColumns(10);
		
		fourth = new JTextField();
		fourth.setBounds(163, 420, 508, 35);
		frame.getContentPane().add(fourth);
		fourth.setColumns(10);
		
		correct = new JTextField();
		correct.setBounds(163, 474, 508, 35);
		frame.getContentPane().add(correct);
		correct.setColumns(10);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(323, 547, 108, 42);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Second alternative:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 305, 150, 42);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Third alternative:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(10, 358, 155, 42);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Fourth alternative:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(10, 413, 150, 42);
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Correct alternative:");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(10, 471, 150, 35);
		frame.getContentPane().add(lblNewLabel_7);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(680, 588, 82, 35);
		frame.getContentPane().add(btnNewButton_1);
	}

}
