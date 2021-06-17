import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ListTable {

	private JFrame frame;
	private JTable table;
	private String query2 = "Select math_score from contesters";
	private String query3 = "Select fname,lname from contesters";
	private ResultSet rs,rs1;
	private Statement s,s1;
	private Connection con;
	private String query1 = "Select * from contesters";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListTable window = new ListTable();
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
	public ListTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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

	}
}
