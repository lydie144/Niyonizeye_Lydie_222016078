package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;

public class LOGIN {
	 JFrame frmLoginForm;
		private JTextField usertxf;
		private JPasswordField passwordField;

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						login window = new login();
						window.frmLoginForm.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public login() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frmLoginForm = new JFrame();
			frmLoginForm.setTitle("login form");
			frmLoginForm.getContentPane().setBackground(new Color(64, 128, 128));
			frmLoginForm.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("LOGIN FORM");
			lblNewLabel.setBounds(287, 11, 243, 47);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 24));
			frmLoginForm.getContentPane().add(lblNewLabel);
			
			JLabel uslb = new JLabel("USERNAME");
			uslb.setForeground(new Color(255, 255, 255));
			uslb.setFont(new Font("Tahoma", Font.BOLD, 20));
			uslb.setBounds(10, 85, 174, 47);
			frmLoginForm.getContentPane().add(uslb);
			
			usertxf = new JTextField();
			usertxf.setBounds(201, 69, 342, 54);
			frmLoginForm.getContentPane().add(usertxf);
			usertxf.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_1_1.setBounds(10, 145, 174, 47);
			frmLoginForm.getContentPane().add(lblNewLabel_1_1);
			
			JButton btnNewButton = new JButton("LOGIN");
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MUSIC","root","");
						Statement stm=con.createStatement();
						String query="select * from registration where username='"+usertxf.getText()+"' and password='"+passwordField.getText().toString()+"'";
						ResultSet set=stm.executeQuery(query);
						if (set.next()) {
							JOptionPane.showMessageDialog(btnNewButton, "Login Successfully!!!");
							AttendanceForm login= new AttendanceForm();
				             login.setVisible(true);
				             frmLoginForm.dispose(); 
							
						}
						else {
							JOptionPane.showMessageDialog(null, "username or password incorrect");
						}
					} catch (Exception e2) {
						
					}
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setForeground(new Color(128, 0, 255));
			btnNewButton.setBounds(54, 313, 121, 38);
			frmLoginForm.getContentPane().add(btnNewButton);
			
			JButton btnSignup = new JButton("SIGNUP");
			btnSignup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrationForm login= new RegistrationForm();
		             login.setVisible(true);
		             frmLoginForm.dispose();
				}
			});
			btnSignup.setForeground(new Color(0, 0, 255));
			btnSignup.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnSignup.setBounds(252, 313, 121, 38);
			frmLoginForm.getContentPane().add(btnSignup);
			
			JButton btnCancel = new JButton("CANCEL");
			btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							usertxf.setText("");
							passwordField.setText("");
				}
			});
			btnCancel.setForeground(Color.RED);
			btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCancel.setBounds(420, 313, 106, 38);
			frmLoginForm.getContentPane().add(btnCancel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(201, 149, 342, 47);
			frmLoginForm.getContentPane().add(passwordField);
			
			JButton btnNewButton_1 = new JButton("LOGIN AS ADMIN");
			btnNewButton_1.setForeground(new Color(0, 0, 160));
			btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_attendance","root","");
							java.sql.Statement stm=con.createStatement();
							String query="select * from admin where username='"+usertxf.getText()+"' and password='"+passwordField.getText().toString()+"'";
							ResultSet set=stm.executeQuery(query);
							if (set.next()) {
								JOptionPane.showMessageDialog(btnNewButton, "Login Successfully!!!");
								Artistform dd=new Artistform();
							 
								
							}
							else {
								JOptionPane.showMessageDialog(null, "username or password incorrect");
							}
						} catch (Exception e2) {
							
						}
						
					}
				});
			btnNewButton_1.setFont(new Font("Sorts Mill Goudy", Font.ITALIC, 19));
			btnNewButton_1.setBounds(234, 231, 243, 38);
			frmLoginForm.getContentPane().add(btnNewButton_1);
			frmLoginForm.setBounds(100, 100, 611, 461);
			frmLoginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		protected static void setVisible(boolean b) {
			// TODO Auto-generated method stub
			
		}
	}

