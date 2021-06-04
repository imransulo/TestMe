import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class Math {

	JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	private JFrame a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Math window = new Math();
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
	public Math() {
		initialize();
	}
	public Math(JFrame a) {	
		this.a = a;
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
		listQuestions.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
								
				frame.dispose();
				new Math(questionsTable());			
					
			}		
		});
		listQuestions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listQuestions.setForeground(new Color(255, 255, 255));
		listQuestions.setBackground(new Color(255, 140, 0));
		listQuestions.setBounds(292, 149, 253, 48);
		frame.getContentPane().add(listQuestions);
		
		JButton addQuestion = new JButton("Add Question");
		addQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Math(addQuestion());	
			}
		});
		addQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addQuestion.setBackground(new Color(255, 140, 0));
		addQuestion.setForeground(new Color(255, 255, 255));
		addQuestion.setBounds(292, 221, 253, 48);
		frame.getContentPane().add(addQuestion);
		
		JButton editQuestion = new JButton("Edit Question");
		editQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new Math(editQuestion());
				
			}
		});
		editQuestion.setForeground(new Color(255, 255, 255));
		editQuestion.setBackground(new Color(255, 140, 0));
		editQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editQuestion.setBounds(292, 291, 253, 48);
		frame.getContentPane().add(editQuestion);
		
		JButton removeQuestion = new JButton("Remove Question");
		removeQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		removeQuestion.setBackground(new Color(255, 140, 0));
		removeQuestion.setForeground(new Color(255, 255, 255));
		removeQuestion.setBounds(292, 360, 253, 48);
		frame.getContentPane().add(removeQuestion);
		
		JButton listContesters = new JButton("List Contesters");
		listContesters.setForeground(new Color(255, 255, 255));
		listContesters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listContesters.setBackground(new Color(255, 140, 0));
		listContesters.setBounds(292, 429, 253, 48);
		frame.getContentPane().add(listContesters);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TeacherScienceCategory().frame.setVisible(true);
			    frame.dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setBounds(775, 565, 89, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Math Section");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-11, 11, 854, 108);
		frame.getContentPane().add(lblNewLabel);
	}
	
	
	private JFrame questionsTable() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 824, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 11, 788, 511);
		frame.getContentPane().add(scrollPane);
		
		btnNewButton = new JButton("Close");
		btnNewButton.setBounds(350, 533, 89, 28);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Math().frame.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
			Statement s = con.createStatement();
			String query1 = "Select Question,correct_alternative as Answer from Math";
			ResultSet rs = s.executeQuery(query1);
			table.setModel(DbUtils.resultSetToTableModel(rs));
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setVisible(true);
		return frame;
	}
	
	private JFrame addQuestion() {
		
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
		
		JTextField question = new JTextField();
		question.setBounds(132, 116, 600, 34);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("First alternative:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 173, 138, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextField first = new JTextField();
		first.setBounds(189, 179, 543, 34);
		frame.getContentPane().add(first);
		first.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Second alternative:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(20, 233, 150, 41);
		frame.getContentPane().add(lblNewLabel_3);
		
		JTextField second = new JTextField();
		second.setBounds(189, 239, 543, 34);
		frame.getContentPane().add(second);
		second.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Third alternative:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(20, 294, 150, 41);
		frame.getContentPane().add(lblNewLabel_4);
		
		JTextField third = new JTextField();
		third.setBounds(189, 300, 543, 34);
		frame.getContentPane().add(third);
		third.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fourth alternative:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(20, 357, 150, 34);
		frame.getContentPane().add(lblNewLabel_5);
		
		JTextField fourth = new JTextField();
		fourth.setBounds(189, 360, 543, 34);
		frame.getContentPane().add(fourth);
		fourth.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Correct alternative:");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(20, 417, 150, 41);
		frame.getContentPane().add(lblNewLabel_6);
		frame.setBounds(100, 100, 818, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField correct = new JTextField();
		correct.setBounds(189, 420, 543, 34);
		frame.getContentPane().add(correct);
		correct.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(330, 500, 104, 41);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Statement s = con.createStatement();
					String query1 = "insert into Math(question,first_alternative,second_alternative,third_alternative,fourth_alternative,correct_alternative) "
							+ "values ('"+question.getText()+"','"+first.getText()+"','"+second.getText()+"','"+third.getText()+"','"+fourth.getText()+"','"+correct.getText()+"')";
					
					s.execute(query1); 
					JOptionPane.showMessageDialog(null, "Question added");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(688, 551, 104, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Math().frame.setVisible(true);
				frame.dispose();
			}
		});
		
		
		
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 818, 638);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;
	}
	
	private JFrame editQuestion() {
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
		
		JTextField oldQuestion = new JTextField();
		oldQuestion.setBounds(132, 129, 539, 35);
		frame.getContentPane().add(oldQuestion);
		oldQuestion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New question:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 186, 135, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextField newQuestion = new JTextField();
		newQuestion.setBounds(132, 193, 539, 35);
		frame.getContentPane().add(newQuestion);
		newQuestion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("First alternative:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(10, 252, 135, 42);
		frame.getContentPane().add(lblNewLabel_3);
		
		JTextField first = new JTextField();
		first.setBounds(163, 256, 508, 35);
		frame.getContentPane().add(first);
		first.setColumns(10);
		
		JTextField second = new JTextField();
		second.setBounds(163, 309, 508, 35);
		frame.getContentPane().add(second);
		second.setColumns(10);
		
		JTextField third = new JTextField();
		third.setBounds(163, 365, 508, 35);
		frame.getContentPane().add(third);
		third.setColumns(10);
		
		JTextField fourth = new JTextField();
		fourth.setBounds(163, 420, 508, 35);
		frame.getContentPane().add(fourth);
		fourth.setColumns(10);
		
		JTextField correct = new JTextField();
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
		
		JLabel lblNewLabel_5 = new JLabel("Third alternative:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(10, 358, 155, 42);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fourth alternative:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(10, 413, 150, 42);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Correct alternative:");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(10, 471, 150, 35);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(680, 588, 82, 35);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Math().frame.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;	
	}
}
