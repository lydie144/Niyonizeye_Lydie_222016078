package Form1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Attendeesform implements ActionListener{
		
		JFrame frame;
		JLabel idlb= new JLabel("AT_ATTENDEEID");
		JLabel FNlb= new JLabel("AT_FIRSTNAME");
		JLabel LNlb= new JLabel("AT_LASTNAME");
		JLabel EMlb= new JLabel("AT_EMAIL");
		JLabel PHlb= new JLabel("AT_PHONE");
		
		JTextField idTextField= new JTextField();    
		JTextField FNTextField= new JTextField();
		JTextField LNTextField= new JTextField();
		JTextField EMTextField= new JTextField();
		JTextField PHTextField= new JTextField();
		
		JButton insertbtn= new JButton ("INSERT");
		
		
		

		JButton updatebtn= new JButton ("UPDATE");
		JButton deltebtn= new JButton ("DELTE");
		
		public Attendeesform() {
			createwindows1();
		}
		
		
		private void createwindows1() {
			frame= new JFrame();
			frame.setTitle("ATTENDEESFORM");
			frame.setBounds(10,10,500,400);
			frame.getContentPane().setBackground(Color.CYAN);
			frame.getContentPane().setLayout(null);
			frame.setResizable(true);
			frame.setVisible(true);
			setsizeandlocation();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		}
		 
		
		private void setsizeandlocation() {
			idlb.setBounds(10,10,200,30);
			FNlb.setBounds(10,50,200,30);
			LNlb.setBounds(10,90,200,30);
			EMlb.setBounds(10,130,200,30);
			PHlb.setBounds(10,170,200,30);	
			
			idTextField.setBounds(160,10,130,30);
			FNTextField.setBounds(160,50,130,30);
			LNTextField.setBounds(160,90,130,30);
			EMTextField.setBounds(160,130,130,30);
			PHTextField.setBounds(160,170,130,30);
			
			
			insertbtn.setBounds(10,250,85,30);
			updatebtn.setBounds(190,250,85,30);
			deltebtn.setBounds(280,250,85,30);
			addcomponenttoframe();
			
			// TODO Auto-generated method stub
			
		}


		private void addcomponenttoframe() {
			frame.add(idlb);
			frame.add(FNlb);
			frame.add(LNlb);
			frame.add(EMlb);
			frame.add(PHlb);
			
			frame.add(idTextField);
			frame.add(FNTextField);
			frame.add(LNTextField);
			frame.add(EMTextField);
			frame.add(PHTextField);
			frame.add(insertbtn);
			frame.add(updatebtn);
			frame.add(deltebtn);
			ActionEvent();
			
			
			
			
			// TODO Auto-generated method stub
			
		}


		private void ActionEvent() {
			insertbtn.addActionListener(this);
			insertbtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String query="INSERT INTO Attendees VALUES(?,?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
						pStatement.setString(2, FNTextField.getText());
						pStatement.setString(3, LNTextField.getText());
						pStatement.setString(4, EMTextField.getText());
				        pStatement.setInt(5,Integer.parseInt(PHTextField.getText()));
					
						pStatement.executeUpdate();
						JOptionPane.showMessageDialog(insertbtn, "data inserted well");
						pStatement.close();
						connection.close();	
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
					
				}
			});	
			updatebtn.addActionListener(this);
			updatebtn.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String sql="UPDATE attendees SET AT_FIRSTNAME=?, AT_LASTNAME=?, AT_EMAIL=?, AT_PHONE=? WHERE AT_ATTENDEEID=?";
						PreparedStatement stm=connection.prepareStatement(sql);
					
						stm.setInt(1, Integer.parseInt(idTextField.getText()));
						stm.setString(2,FNTextField.getText());
						stm.setString(3,LNTextField.getText());
						stm.setString(4,EMTextField.getText());
						stm.setInt(5,Integer.parseInt(PHTextField.getText()));
						stm.executeUpdate();
						JOptionPane.showMessageDialog(updatebtn, "update data!");
						stm.close();
						connection.close();	
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
					
				}
			});
			deltebtn.addActionListener(this);
			deltebtn.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String delete_id=idTextField.getText();
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String sql="DELETE FROM attendees  WHERE AT_ATTENDEEID='"+delete_id+"'";
						PreparedStatement stm=connection.prepareStatement(sql);
						stm.execute();
						JOptionPane.showMessageDialog(deltebtn, "Successful Deleted!!!!!!!!!");
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
					
				}
			});
			setFontforall();
			
			
			
			
		}



		
		private void setFontforall() {
			
			Font fontii= new Font("Georgia", Font.ITALIC,18); 
			idlb.setFont(fontii);
			FNlb.setFont(fontii);
			LNlb.setFont(fontii);
			EMlb.setFont(fontii);
			PHlb.setFont(fontii);
			
			
			idTextField.setFont(fontii);
			FNTextField.setFont(fontii);
			LNTextField.setFont(fontii);
			EMTextField.setFont(fontii);
			PHTextField.setFont(fontii);
			
			
			
			Font fii=new Font("CourierNew",Font.BOLD,12);
			insertbtn.setFont(fii);
			updatebtn.setFont(fii);
			deltebtn.setFont(fii);
			// TODO Auto-generated method stub
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}



	public static  void main(String[] args) {
		Attendeesform atf=new Attendeesform();

	}
	}


	

























