import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Teacher {

	JFrame frame,frame2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher window = new Teacher();
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
	public Teacher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 890, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton listQuestions = new JButton("List of Questions");
		listQuestions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listQuestions.setForeground(new Color(255, 255, 255));
		listQuestions.setBackground(new Color(255, 140, 0));
		listQuestions.setBounds(292, 127, 253, 48);
		frame.getContentPane().add(listQuestions);
		
		JButton addQuestion = new JButton("Add Question");
		addQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addQuestion.setBackground(new Color(255, 140, 0));
		addQuestion.setForeground(new Color(255, 255, 255));
		addQuestion.setBounds(292, 208, 253, 48);
		frame.getContentPane().add(addQuestion);
		
		JButton editQuestion = new JButton("Edit Question");
		editQuestion.setForeground(new Color(255, 255, 255));
		editQuestion.setBackground(new Color(255, 140, 0));
		editQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editQuestion.setBounds(292, 287, 253, 48);
		frame.getContentPane().add(editQuestion);
		
		JButton RemoveQuestion = new JButton("Remove Question");
		RemoveQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RemoveQuestion.setBackground(new Color(255, 140, 0));
		RemoveQuestion.setForeground(new Color(255, 255, 255));
		RemoveQuestion.setBounds(292, 365, 253, 48);
		frame.getContentPane().add(RemoveQuestion);
		
		JButton btnNewButton = new JButton("List Contesters");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setBounds(295, 438, 250, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setBounds(775, 565, 89, 35);
		frame.getContentPane().add(btnNewButton_1);
	}
}
