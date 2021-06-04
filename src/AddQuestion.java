import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddQuestion {

	private JFrame frame;
	private JTextField question;
	private JTextField first;
	private JTextField second;
	private JTextField third;
	private JTextField fourth;
	private JTextField correct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion window = new AddQuestion();
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
	public AddQuestion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Question");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 782, 76);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(20, 109, 129, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		question = new JTextField();
		question.setBounds(132, 116, 600, 34);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First alternative:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 173, 138, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		first = new JTextField();
		first.setBounds(189, 179, 543, 34);
		frame.getContentPane().add(first);
		first.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Second alternative:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(20, 233, 150, 41);
		frame.getContentPane().add(lblNewLabel_3);
		
		second = new JTextField();
		second.setBounds(189, 239, 543, 34);
		frame.getContentPane().add(second);
		second.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Third alternative:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(20, 294, 150, 41);
		frame.getContentPane().add(lblNewLabel_4);
		
		third = new JTextField();
		third.setBounds(189, 300, 543, 34);
		frame.getContentPane().add(third);
		third.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fourth alternative:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(20, 357, 150, 34);
		frame.getContentPane().add(lblNewLabel_5);
		
		fourth = new JTextField();
		fourth.setBounds(189, 360, 543, 34);
		frame.getContentPane().add(fourth);
		fourth.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(330, 500, 104, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(688, 551, 104, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		correct = new JTextField();
		correct.setBounds(189, 420, 543, 34);
		frame.getContentPane().add(correct);
		correct.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Correct alternative:");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(20, 417, 150, 41);
		frame.getContentPane().add(lblNewLabel_6);
		frame.setBounds(100, 100, 818, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
