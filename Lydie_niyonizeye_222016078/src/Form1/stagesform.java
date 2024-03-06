
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

import com.mysql.cj.protocol.Resultset;

public class stagesform implements ActionListener{
		JFrame frame;
		JLabel idlb= new JLabel("ST_STAGEID");
		JLabel NMlb= new JLabel("ST_NAME");
		JLabel CClb= new JLabel("ST_CAPACITY");
		
		JTextField idTextField= new JTextField();    
		JTextField NMTextField= new JTextField();
		JTextField CCTextField= new JTextField();
		
		
		JButton insertbtn= new JButton ("INSERT");
		
		
		
		JButton readbtn= new JButton ("READ");
		JButton updatebtn= new JButton ("UPDATE");
		JButton deltebtn= new JButton ("DELTE");
		
		public stagesform() {
			createwindows1();
		}
		
		
		private void createwindows1() {
			frame= new JFrame();
			frame.setTitle("STAGESFORM");
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
			CClb.setBounds(10,90,200,30);
				
			
			idTextField.setBounds(160,10,130,30);
			NMTextField.setBounds(160,50,130,30);
			CCTextField.setBounds(160,90,130,30);
			
			
			
			insertbtn.setBounds(10,250,85,30);
			readbtn.setBounds(100,250,85,30);
			updatebtn.setBounds(190,250,85,30);
			deltebtn.setBounds(280,250,85,30);
			addcomponenttoframe();
			
			// TODO Auto-generated method stub
			
		}


		private void addcomponenttoframe() {
			frame.add(idlb);
			frame.add(NMlb);
			frame.add(CClb);
			
			frame.add(idTextField);
			frame.add(NMTextField);
			frame.add(CCTextField);
			
			
			frame.add(insertbtn);
			frame.add(readbtn);
			frame.add(updatebtn);
			frame.add(deltebtn);
			ActionEvent();
			
			
			
			
			// TODO Auto-generated method stub
			
		}


		private void ActionEvent() {
			insertbtn.addActionListener(this);
			readbtn = new JButton("read");
			readbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					readbtn.addActionListener(new ActionListener() {
						private Object stagescode;

						public void actionPerformed(ActionEvent e) {
							try {
								Class.forName("com.mysql.cj.jdbc.Driver");
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
								Statement stm=con.createStatement();
								String query="Select * from stages";
								Resultset rs =stm.executeQuery(query);
								java.sql.ResultSetMetaData rsmd= rs.getMetaData();
								DefaultTableModel model=(DefaultTableModel) table.getModel();
								int cols=rsmd.getColumnCount();
								String[] colName=new String[cols];
								for(int i=0; i<cols; i++)
									colName[i]=rsmd.getColumnName(i+1);
								model.setColumnIdentifiers(colName);
								String employeecode,firstname,lastname,phone,email,address,status;
								while(rs.next()) {
									stagescode=rs.getString(1);
									name = rs.getStrin	g(2);
								       capacity = rs.getString(3);
									idrs.getString(4);
									String[] row= {stagescode,name,capacity,id};
									model.addRow(row);
								}
								stm.close();
								con.close();
							} catch (Exception e2) {
								System.out.println(e2.getMessage());
							}

							
						}
					});
					
					
				}
			});
			insertbtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String query="INSERT INTO stages VALUES(?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(idTextField.getText()));
						pStatement.setString(2, NMTextField.getText());
						pStatement.setString(3, CCTextField.getText());
						
					
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
						String sql="UPDATE stages SET  ST_NAME=?,ST_CAPACITY=?WHERE ST_stageid=?";
						PreparedStatement stm=connection.prepareStatement(sql);
						
						stm.setString(1, NMTextField.getText());
						stm.setString(2, CCTextField.getText());
						stm.setInt(3,Integer.parseInt(idTextField.getText()));
					
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
						String sql="DELETE FROM stages  WHERE ST_STAGEID='"+delete_id+"'";
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
			CClb.setFont(fontii);
			
			
			
			idTextField.setFont(fontii);
			NMTextField.setFont(fontii);
			CCTextField.setFont(fontii);
			
			
			
			
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
		stagesform atf=new stagesform();

	}
	}


	

























