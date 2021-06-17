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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import net.proteanit.sql.DbUtils;

public class UserHistory {

	JFrame frame;
	private int sec = 0;
	private int min = 20;
	private Timer time;
	private int id = 1;
	private int points = 0;
	private String answer;
	private ResultSet rs;
	private Connection con;
	private Statement s;
	private JButton submit;
	private JFrame f;
	private String query1 = "select * from contesters";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHistory window = new UserHistory();
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
	public UserHistory() {
		initialize();
	}

	public UserHistory(JFrame frame) {
		this.frame = frame; 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 823, 560);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("History Section");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblNewLabel.setBounds(10, 23, 787, 93);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start Exam");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new UserHistory(startExam());			
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(285, 179, 218, 77);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("List Contesters");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new UserHistory(listContesters());
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(285, 308, 218, 77);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UserSocialCategory().frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 140, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(687, 465, 110, 45);
		frame.getContentPane().add(btnNewButton_2);
	}
	
private JFrame startExam() {	
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 205));
		frame.setBounds(100, 100, 969, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel question = new JLabel("");
		question.setForeground(new Color(255, 255, 255));
		question.setFont(new Font("Tahoma", Font.PLAIN, 40));
		question.setHorizontalAlignment(SwingConstants.CENTER);
		question.setBounds(10, 118, 933, 76);
		frame.getContentPane().add(question);
		
		JRadioButton alt2 = new JRadioButton("New radio button");
		alt2.setHorizontalAlignment(SwingConstants.CENTER);
		alt2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		alt2.setForeground(new Color(255, 255, 255));
		alt2.setBackground(new Color(0, 0, 205));
		alt2.setBounds(10, 268, 933, 47);
		frame.getContentPane().add(alt2);
		
		JRadioButton alt3 = new JRadioButton("New radio button");
		alt3.setHorizontalAlignment(SwingConstants.CENTER);
		alt3.setForeground(new Color(255, 255, 255));
		alt3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		alt3.setBackground(new Color(0, 0, 205));
		alt3.setBounds(10, 318, 933, 47);
		frame.getContentPane().add(alt3);
		
		JRadioButton alt4 = new JRadioButton("New radio button");
		alt4.setHorizontalAlignment(SwingConstants.CENTER);
		alt4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		alt4.setForeground(new Color(255, 255, 255));
		alt4.setBackground(new Color(0, 0, 205));
		alt4.setBounds(10, 368, 933, 47);
		frame.getContentPane().add(alt4);
		
		JRadioButton alt1 = new JRadioButton("New radio button");
		alt1.setHorizontalAlignment(SwingConstants.CENTER);
		alt1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		alt1.setForeground(new Color(255, 255, 255));
		alt1.setBackground(new Color(0, 0, 205));
		alt1.setBounds(10, 218, 933, 47);
		frame.getContentPane().add(alt1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(alt1);
		group.add(alt2);
		group.add(alt3);
		group.add(alt4);
		
		JButton next = new JButton("Choose");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(alt1.isSelected()) answer = alt1.getText();
				if(alt2.isSelected()) answer = alt2.getText();
				if(alt3.isSelected()) answer = alt3.getText();
				if(alt4.isSelected()) answer = alt4.getText();			
				
				try {	
					rs = s.executeQuery("select * from History where id = "+id+"");
					while(rs.next()) {
						if(answer != null && answer.equals(rs.getString("correct_alternative"))) points+=5;
						question.setText(rs.getString("question"));
						alt1.setText(rs.getString("first_alternative"));
						alt2.setText(rs.getString("second_alternative"));
						alt3.setText(rs.getString("third_alternative"));
						alt4.setText(rs.getString("fourth_alternative"));
					}

					id++;

			if(id == 21) next.setVisible(false);		
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}					
			}
		});
		next.setForeground(new Color(255, 255, 255));
		next.setFont(new Font("Tahoma", Font.BOLD, 16));
		next.setBackground(new Color(255, 140, 0));
		next.setBounds(421, 462, 117, 47);
		frame.getContentPane().add(next);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int r = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", null, JOptionPane.YES_NO_OPTION);
				if(r == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null,"You got "+points+" points");
					try {
						s.execute("update contesters set history_score = "+points+" where id = "+UserLogIn.getLogInfo()+"");						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					new UserHistory().frame.setVisible(true);
					frame.dispose();
				}
			}
		});
		submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(255, 140, 0));
		submit.setFont(new Font("Tahoma", Font.BOLD, 16));
		submit.setBounds(429, 545, 101, 39);
		frame.getContentPane().add(submit);
		
		JLabel timer = new JLabel("Time Remaining:");
		timer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timer.setForeground(new Color(255, 255, 255));
		timer.setBounds(700, 11, 152, 47);
		frame.getContentPane().add(timer);
		
		JLabel minLabel = new JLabel();
		minLabel.setForeground(new Color(255, 255, 255));
		minLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		minLabel.setBounds(870, 11, 32, 47);
		frame.getContentPane().add(minLabel);
		
		JLabel secLabel = new JLabel();
		secLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		secLabel.setForeground(new Color(255, 255, 255));
		secLabel.setBounds(904, 0, 27, 47);
		frame.getContentPane().add(secLabel);
		
		
		 time = new Timer(1000,new ActionListener(){ 			
			 @Override
			public void actionPerformed(ActionEvent event){	                  	
			    secLabel.setText(String.valueOf(sec));
	        	minLabel.setText(String.valueOf(min)); 
	        	if(min == 0 && sec == 0) {
        			time.stop();
        			JOptionPane.showMessageDialog(null, "Time is over");        	
        		}
	        	if(sec == 0) {        		
	        		sec = 59;
	        		min--;	        		
	        	}	        	
	        	sec--;
	        }
	    });	 
		 time.start();			 
		 
		 try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
				s = con.createStatement();
				rs = s.executeQuery("select * from History where id = "+id+"");		
				
				while(rs.next()) {
					question.setText(rs.getString("question"));
					alt1.setText(rs.getString("first_alternative"));
					alt2.setText(rs.getString("second_alternative"));
					alt3.setText(rs.getString("third_alternative"));
					alt4.setText(rs.getString("fourth_alternative"));
				}			
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
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
			
			new UserHistory().frame.setVisible(true);
			frame.dispose();		
		}
	});
	frame.getContentPane().add(btnNewButton);
	
	JTable table = new JTable();
	scrollPane.setViewportView(table);
	table.setRowHeight(30);
	table.setAutoCreateRowSorter(true);
        
	try {
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testme","root","root");
	    s = con.createStatement();	
		 rs = s.executeQuery(query1);
		table.setModel(DbUtils.resultSetToTableModel(rs));		
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	frame.setVisible(true);
	return frame;
}
}
