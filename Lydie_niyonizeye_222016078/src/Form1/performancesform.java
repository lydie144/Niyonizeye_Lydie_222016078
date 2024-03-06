
package Form1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class performancesform implements ActionListener{
		protected static final AbstractButton STextField = null;
		JFrame frame;
		JLabel idlb= new JLabel("PF_PERFORMANCEID");
		JLabel PDlb= new JLabel("PF_PERFORMANCEDATE");
		JLabel STlb= new JLabel("PF_STARTTIME");
		JLabel DRlb= new JLabel("PF_DURATION");
		
		
		JTextField idTextField= new JTextField();    
		JTextField PDTextField= new JTextField();
		JTextField STTextField= new JTextField();
		JTextField DRTextField= new JTextField();
		
		
		JButton insertbtn= new JButton ("INSERT");
		
		
		
		JButton readbtn= new JButton ("READ");
		JButton updatebtn= new JButton ("UPDATE");
		JButton deltebtn= new JButton ("DELTE");
		
		public performancesform() {
			createwindows1();
		}
		
		
		private void createwindows1() {
			frame= new JFrame();
			frame.setTitle("PERFORMANCESFORM");
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
			PDlb.setBounds(10,50,200,30);
			STlb.setBounds(10,90,200,30);
			DRlb.setBounds(10,130,200,30);
				
			
			idTextField.setBounds(250,10,130,30);
			PDTextField.setBounds(250,50,130,30);
			STTextField.setBounds(250,90,130,30);
			DRTextField.setBounds(250,130,130,30);
			
			
			
			insertbtn.setBounds(10,250,85,30);
			readbtn.setBounds(100,250,85,30);
			updatebtn.setBounds(190,250,85,30);
			deltebtn.setBounds(280,250,85,30);
			addcomponenttoframe();
			
			// TODO Auto-generated method stub
			
		}


		private void addcomponenttoframe() {
			frame.add(idlb);
			frame.add(PDlb);
			frame.add(STlb);
			frame.add(DRlb);
			
			
			frame.add(idTextField);
			frame.add(PDTextField);
			frame.add(STTextField);
			frame.add(DRTextField);
			frame.add(insertbtn);
			frame.add(readbtn);
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
						String query="INSERT INTO performances VALUES(?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
						pStatement.setString(2, PDTextField.getText());
						pStatement.setString(3, STTextField.getText());
						pStatement.setString(4, DRTextField.getText());
					
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
						String sql="UPDATE performances SET PF_PERFORMANCEEDATE=?,PF_STARTTIME=?,PF_DURATION=? WHERE PF_PERFORMANCEID=?";
						
						PreparedStatement stm=connection.prepareStatement(sql);
					
						stm.setString(1, PDTextField.getText());
						stm.setString(2, STTextField.getText());
						stm.setString(3, DRTextField.getText());
						stm.setInt(4,Integer.parseInt(idTextField.getText()));
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
						String sql="DELETE FROM performances  WHERE PF_PERFORMANCEID='"+delete_id+"'";
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
			PDlb.setFont(fontii);
			STlb.setFont(fontii);
			DRlb.setFont(fontii);
			
			
			
			idTextField.setFont(fontii);
			PDTextField.setFont(fontii);
			STTextField.setFont(fontii);
			DRTextField.setFont(fontii);
			
			
			
			
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
		performancesform atf=new performancesform();

	}
	}


	

























