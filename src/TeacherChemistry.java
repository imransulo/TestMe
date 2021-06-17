import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class TeacherChemistry {

	JFrame frame;
	private JFrame a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherChemistry window = new TeacherChemistry();
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
	public TeacherChemistry() {
		initialize();
	}

	public TeacherChemistry(JFrame a) {	
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
				new TeacherChemistry(questionsTable());			
					
			}		
		});
		listQuestions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listQuestions.setForeground(new Color(255, 255, 255));
		listQuestions.setBackground(new Color(255, 140, 0));
		listQuestions.setBounds(303, 128, 253, 48);
		frame.getContentPane().add(listQuestions);
		
		JButton addQuestion = new JButton("Add Question");
		addQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int limit = 0;
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Statement s = con.createStatement();
					String query1 = "select question from Chemistry";
					ResultSet rs = s.executeQuery(query1);
					while(rs.next()) limit++;
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(limit == 20) JOptionPane.showMessageDialog(null, "               Maximum number of questions has been reached.\n Remove a question to add a new one or edit an existing question.");
				
				else {
					frame.dispose();				
				    new TeacherChemistry(addQuestion());	
				}	
			}
		});
		addQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addQuestion.setBackground(new Color(255, 140, 0));
		addQuestion.setForeground(new Color(255, 255, 255));
		addQuestion.setBounds(303, 196, 253, 48);
		frame.getContentPane().add(addQuestion);
		
		JButton editQuestion = new JButton("Edit Question");
		editQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new TeacherChemistry(editQuestion());
				
			}
		});
		editQuestion.setForeground(new Color(255, 255, 255));
		editQuestion.setBackground(new Color(255, 140, 0));
		editQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editQuestion.setBounds(303, 265, 253, 48);
		frame.getContentPane().add(editQuestion);
		
		JButton removeQuestion = new JButton("Remove Question");
		removeQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new TeacherChemistry(removeQuestion());
				
			}
		});
		removeQuestion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		removeQuestion.setBackground(new Color(255, 140, 0));
		removeQuestion.setForeground(new Color(255, 255, 255));
		removeQuestion.setBounds(303, 334, 253, 48);
		frame.getContentPane().add(removeQuestion);
		
		JButton listContesters = new JButton("List Contesters");
		listContesters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new TeacherChemistry(listContesters());
			}
		});
		listContesters.setForeground(new Color(255, 255, 255));
		listContesters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listContesters.setBackground(new Color(255, 140, 0));
		listContesters.setBounds(303, 401, 253, 48);
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
		
		JLabel lblNewLabel = new JLabel("Chemistry Section");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 864, 108);
		frame.getContentPane().add(lblNewLabel);
		
		JButton listContesters_1 = new JButton("Remove Contester");
		listContesters_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new TeacherChemistry(removeContester());
			}
		});
		listContesters_1.setForeground(Color.WHITE);
		listContesters_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listContesters_1.setBackground(new Color(255, 140, 0));
		listContesters_1.setBounds(303, 469, 253, 48);
		frame.getContentPane().add(listContesters_1);
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
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(350, 533, 89, 28);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TeacherChemistry().frame.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
			Statement s = con.createStatement();
			String query1 = "Select ID,Question,correct_alternative as Answer from Chemistry";
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

				if(question.getText().trim().isEmpty() || first.getText().trim().isEmpty() || second.getText().trim().isEmpty() || third.getText().trim().isEmpty() || fourth.getText().trim().isEmpty() || correct.getText().trim().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Statement s = con.createStatement();
					String query1 = "insert into Chemistry(question,first_alternative,second_alternative,third_alternative,fourth_alternative,correct_alternative) "
							+ "values ('"+question.getText()+"','"+first.getText()+"','"+second.getText()+"','"+third.getText()+"','"+fourth.getText()+"','"+correct.getText()+"')";
					
					s.execute(query1);
					new TeacherChemistry().frame.setVisible(true);
					frame.dispose();
					JOptionPane.showMessageDialog(null, "Question added");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(688, 551, 104, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TeacherChemistry().frame.setVisible(true);
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
		
		JLabel lblNewLabel_1 = new JLabel("Question ID:");
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				if(oldQuestion.getText().trim().isEmpty() || newQuestion.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Question fields can not be empty");
				}			
				
				else {	
					
					try {
						
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Statement s = con.createStatement();
					String query1 = "Select question from Chemistry where id = '"+oldQuestion.getText()+"'";
					ResultSet rs = s.executeQuery(query1);
					if(rs.next()) { 
						
						String query2 = "update Chemistry set question = '"+newQuestion.getText()+"' where id = '"+oldQuestion.getText()+"'";
						s.execute(query2); 
						
						if(!first.getText().trim().isEmpty()) {
						String query3 = "update Chemistry set first_alternative = '"+first.getText()+"' where question = '"+newQuestion.getText()+"'";
						s.execute(query3); 
						}						
						if(!second.getText().trim().isEmpty()) {
						String query4 = "update Chemistry set second_alternative = '"+second.getText()+"' where question = '"+newQuestion.getText()+"'";
						s.execute(query4);
						}
						if(!third.getText().trim().isEmpty()) {
						String query5 = "update Chemistry set third_alternative = '"+third.getText()+"' where question = '"+newQuestion.getText()+"'";
						s.execute(query5); 
						}
						if(!fourth.getText().trim().isEmpty()) {
						String query6 = "update Chemistry set fourth_alternative = '"+fourth.getText()+"' where question = '"+newQuestion.getText()+"'";
						s.execute(query6); 
						}
						if(!correct.getText().trim().isEmpty()) {
						String query7 = "update Chemistry set correct_alternative = '"+correct.getText()+"' where question = '"+newQuestion.getText()+"'";
						s.execute(query7); 
						}
						
						new TeacherChemistry().frame.setVisible(true); 
						frame.dispose(); 
						JOptionPane.showMessageDialog(null, "Question Edited");					
					}
		
					else JOptionPane.showMessageDialog(null, "Wrong question ID");
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
				
			}
		});
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
				
				new TeacherChemistry().frame.setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;	
	}
	
	private JFrame removeQuestion() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 779, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Question");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblNewLabel.setBounds(0, 11, 753, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Question ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 169, 170, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextField question = new JTextField();
		question.setBounds(130, 178, 613, 38);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Statement s = con.createStatement();
					String query1 = "Select question from Chemistry where id = '"+question.getText()+"'";
					ResultSet rs = s.executeQuery(query1);
					if(rs.next()) {
						String query2 = "delete from Chemistry where id = '"+question.getText()+"'";
						s.execute(query2);
						new TeacherChemistry().frame.setVisible(true);
						frame.dispose();
						JOptionPane.showMessageDialog(null, "Question removed");
					}
					else JOptionPane.showMessageDialog(null, "Wrong question ID");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  }			
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(301, 292, 160, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherChemistry().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(648, 406, 105, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		return frame;
	}
	
	private JFrame listContesters() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 1161, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 1125, 552);
		scrollPane.setToolTipText("");
		frame.getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(531, 584, 89, 34);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TeacherChemistry().frame.setVisible(true);
				frame.dispose();		
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);

	        
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
		    Statement s = con.createStatement();	
		    String query1 = "select * from contesters";
			ResultSet rs = s.executeQuery(query1 );
			table.setModel(DbUtils.resultSetToTableModel(rs));		
				
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		frame.setVisible(true);
		return frame;
	}
	
   private JFrame removeContester() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 779, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Contester");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblNewLabel.setBounds(0, 11, 753, 88);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contester ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 169, 128, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextField question = new JTextField();
		question.setBounds(174, 178, 535, 38);
		frame.getContentPane().add(question);
		question.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
					Statement s = con.createStatement();
					String query1 = "Select id from contesters where id = '"+question.getText()+"'";
					ResultSet rs = s.executeQuery(query1);
					if(rs.next()) {
						String query2 = "delete from contesters where id = '"+question.getText()+"'";
						String query3 = "delete from UserLogIn where id = '"+question.getText()+"'";
						String query4 = "delete from UserSignUp where id = '"+question.getText()+"'";
						s.execute(query2);
						s.execute(query3);
						s.execute(query4);
						new TeacherChemistry().frame.setVisible(true);
						frame.dispose();
						JOptionPane.showMessageDialog(null, "Contester removed");
					}
					else JOptionPane.showMessageDialog(null, "Wrong contester ID");
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}						
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(301, 283, 160, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherChemistry().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(657, 406, 96, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;
	}
}
