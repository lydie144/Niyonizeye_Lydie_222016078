package Form1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextField;
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

public class Festivalsform implements ActionListener{
		JFrame frame;
		JLabel idlb= new JLabel("FV_FESTIVALID");
		JLabel NMlb= new JLabel("FV_NAME");
		JLabel LClb1= new JLabel("FV_LOCATION");
		JLabel SDlb= new JLabel("FV_STARTDATE");
		JLabel EDlb= new JLabel("FV_ENDDATE");
		JLabel ORlb= new JLabel("FV_ORGANIZER");
		JLabel TPlb= new JLabel("FV_TICKETPRICE");
		
		JTextField idTextField= new JTextField();    
		JTextField NMTextField= new JTextField();
		JTextField LCTextField= new JTextField();
		JTextField SDTextField= new JTextField();
		JTextField EDTextField= new JTextField();
		JTextField ORTextField= new JTextField();
		JTextField TPTextField= new JTextField();
		
		JButton insertbtn= new JButton ("INSERT");
		
		
		
		JButton readbtn= new JButton ("READ");
		JButton updatebtn= new JButton ("UPDATE");
		JButton deltebtn= new JButton ("DELTE");
		
		public Festivalsform() {
			createwindows1();
		}
		
		
		private void createwindows1() {
			frame= new JFrame();
			frame.setTitle("FESTIVALSFORM");
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
			NMlb.setBounds(10,50,200,30);
	        LClb1.setBounds(10,90,200,30);
	        SDlb.setBounds(10,130,200,30);
			EDlb.setBounds(10,170,200,30);
			ORlb.setBounds(10,210,200,30);
			TPlb.setBounds(10,250,200,30);
				
			
			idTextField.setBounds(160,10,130,30);
			NMTextField.setBounds(160,50,130,30);
			LCTextField.setBounds(160,90,130,30);
			SDTextField.setBounds(160,130,130,30);
			EDTextField.setBounds(160,170,130,30);
			ORTextField.setBounds(160,210,130,30);
			TPTextField.setBounds(160,250,130,30);
			
			
			
			
			insertbtn.setBounds(10,290,85,30);
			readbtn.setBounds(100,290,85,30);
			updatebtn.setBounds(190,290,85,30);
			deltebtn.setBounds(280,290,85,30);
			addcomponenttoframe();
			
			// TODO Auto-generated method stub
			
		}


		private void addcomponenttoframe() {
			frame.add(idlb);
			frame.add(NMlb);
			frame.add(LClb1);
			frame.add(SDlb);
			frame.add(EDlb);
			frame.add(ORlb);
			frame.add(TPlb);
			
			frame.add(idTextField);
			frame.add(NMTextField);
			frame.add(LCTextField);
			frame.add(SDTextField);
			frame.add(EDTextField);
			frame.add(ORTextField);
			frame.add(TPTextField);
			
			
			
			frame.add(insertbtn);
			frame.add(readbtn);
			frame.add(updatebtn);
			frame.add(deltebtn);
			ActionEvent();
			
			
			
			
			// TODO Auto-generated method stub
			
		}


		private void ActionEvent() {
			insertbtn.addActionListener(this);
			insertbtn.addActionListener(this);
			insertbtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String query="INSERT INTO Festivals VALUES(?,?,?,?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
						pStatement.setString(2, NMTextField.getText());
						pStatement.setString(3, LCTextField.getText());
						pStatement.setString(4, SDTextField.getText());
						pStatement.setString(5, EDTextField.getText());
						pStatement.setString(6, ORTextField.getText());
						pStatement.setInt(7,Integer.parseInt(TPTextField.getText()));
					
						pStatement.executeUpdate();
						JOptionPane.showMessageDialog(insertbtn, "data inserted well");
						pStatement.close();
						connection.close();	
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
					
				}
			});	
			readbtn.addActionListener(this);
			updatebtn.addActionListener(this);
			updatebtn.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String sql="UPDATE Festivals SET FV_NAME=?,FV_LOCATION=?,FV_STARTDATE=?,FV_ENDDATE=?,FV_ORGANIZER=?,FV_TICKETPRICE=? WHERE FV_id=?";
						PreparedStatement stm=connection.prepareStatement(sql);
					
						stm.setString(1, NMTextField.getText());
						stm.setString(2, LCTextField.getText());
						stm.setString(3, SDTextField.getText());
						stm.setString(4, EDTextField.getText());
						stm.setString(5, ORTextField.getText());
						stm.setInt(6,Integer.parseInt(TPTextField.getText()));
						stm.setInt(7,Integer.parseInt(idTextField.getText()));
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
						String sql="DELETE FROM Festivals  WHERE FV_ID='"+delete_id+"'";
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
			NMlb.setFont(fontii);
			LClb1.setFont(fontii);
			SDlb.setFont(fontii);
			EDlb.setFont(fontii);
			ORlb.setFont(fontii);
			TPlb.setFont(fontii);
			
			
			
			idTextField.setFont(fontii);
			NMTextField.setFont(fontii);
			LCTextField.setFont(fontii);
			SDTextField.setFont(fontii);
			EDTextField.setFont(fontii);
			ORTextField.setFont(fontii);
			TPTextField.setFont(fontii);
			
			
			
			
			
			Font fii=new Font("CourierNew",Font.BOLD,12);
			insertbtn.setFont(fii);
			readbtn.setFont(fii);
			updatebtn.setFont(fii);
			deltebtn.setFont(fii);
			// TODO Auto-generated method stub
			
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}



	public static  void main(String[] args) {
		Festivalsform atf=new Festivalsform();

	}
	}


	

























