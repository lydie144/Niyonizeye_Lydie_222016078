
package Form1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Artistsform implements ActionListener{
		JFrame frame;
		JLabel Artistidlb= new JLabel("AR_ARTISTID");
		JLabel NMlb= new JLabel("AR_NAME");
		JLabel GRlb= new JLabel("AR_GENRE");
		JLabel WSlb= new JLabel("AR_WEBSITE");
		JLabel CElb= new JLabel("AR_CONTACTEMAIL");
		
		JTextField ArtistidTextField= new JTextField();    
		JTextField NMTextField= new JTextField();
		JTextField GRTextField= new JTextField();
		JTextField WSTextField= new JTextField();
		JTextField CETextField= new JTextField();
		
		JButton insertbtn= new JButton ("INSERT");
		JButton readbtn= new JButton ("READ");
		JButton updatebtn= new JButton ("UPDATE");
		JButton deltebtn= new JButton ("DELTE");
		
		public Artistsform() {
			createwindows1();
		}
		
		
		public void createwindows1() {
			frame= new JFrame();
			frame.setTitle("ARTISTSFORM");
			frame.setBounds(10,10,500,400);
			frame.getContentPane().setBackground(Color.CYAN);
			frame.getContentPane().setLayout(null);
			frame.setResizable(true);
			frame.setVisible(true);
			setsizeandlocation();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		}
		 
		
		private void setsizeandlocation() {
			Artistidlb.setBounds(10,10,200,30);
			NMlb.setBounds(10,50,200,30);
			GRlb.setBounds(10,90,200,30);
			WSlb.setBounds(10,130,200,30);
			CElb.setBounds(10,170,200,30);	
			
			ArtistidTextField.setBounds(160,10,130,30);
			NMTextField.setBounds(160,50,130,30);
			GRTextField.setBounds(160,90,130,30);
			WSTextField.setBounds(160,130,130,30);
			CETextField.setBounds(160,170,130,30);
			
			
			insertbtn.setBounds(10,250,85,30);
			readbtn.setBounds(100,250,85,30);
			updatebtn.setBounds(190,250,85,30);
			deltebtn.setBounds(280,250,85,30);
			addcomponenttoframe();
			
			// TODO Auto-generated method stub
			
		}


		private void addcomponenttoframe() {
			frame.add(Artistidlb);
			frame.add(NMlb);
			frame.add(GRlb);
			frame.add(WSlb);
			frame.add(CElb);
			
			frame.add(ArtistidTextField);
			frame.add(NMTextField);
			frame.add(GRTextField);
			frame.add(WSTextField);
			frame.add(CETextField);
			frame.add(insertbtn);
			frame.add(readbtn);
			frame.add(updatebtn);
			frame.add(deltebtn);
			ActionEvent();
			
			
			
			
			// TODO Auto-generated method stub
			
		}


		private void ActionEvent() {
			insertbtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String query="INSERT INTO artists VALUES(?,?,?,?,?)";
						PreparedStatement pStatement=connection.prepareStatement(query);
						pStatement.setInt(1,Integer.parseInt(ArtistidTextField.getText()));
						pStatement.setString(2, NMTextField.getText());
						pStatement.setString(3, GRTextField.getText());
						pStatement.setString(4, WSTextField.getText());
						pStatement.setString(5, CETextField.getText());
					
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
		} else if (e.getSource() == readbtn) {
           // Perform action for view button here
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root",
                        "");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Artist_ARTISTID");
                model.addColumn("Artist_NAME");
                model.addColumn("Artist_GENRE");
                model.addColumn("Artist_WEBSITE");
                model.addColumn("Artist_CONTACTEMAIL");

                while (resultSet.next()) {
                    Object[] row = new Object[4];
                    row[0] = resultSet.getInt("artist_artistid");
                    row[1] = resultSet.getString("artist_name");
                    row[2] = resultSet.getString("artist_genre");
                    row[3] = resultSet.getInt("artist_website");
                    row[4] = resultSet.getInt("artist_contactemail");
                    model.addRow(row);
                }

                JTable table = new JTable(model);
                JOptionPane.showMessageDialog(readbtn, table);
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        
    
		   
			updatebtn.addActionListener(this);
			updatebtn.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String sql="UPDATE Artists SET Ar_name=?,Ar_genre=?,Ar_website=?,Ar_contactemail=? WHERE Ar_artistid=?";
						PreparedStatement stm=connection.prepareStatement(sql);
					
						stm.setString(1, NMTextField.getText());
						stm.setString(2, GRTextField.getText());
						stm.setString(3, WSTextField.getText());
						stm.setString(4, CETextField.getText());
						stm.setInt(5,Integer.parseInt(ArtistidTextField.getText()));
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
					String delete_id=ArtistidTextField.getText();
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");	
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
						String sql="DELETE FROM Artists  WHERE Ar_artistid='"+delete_id+"'";
						PreparedStatement stm=connection.prepareStatement(sql);
						stm.execute();
						JOptionPane.showMessageDialog(deltebtn, "Successful Deleted!!!!!!!!!");
					} catch (Exception e2) {
						System.out.println(e2.getMessage());
					}
					
				}
			});		
			readbtn.addActionListener(this);
			updatebtn.addActionListener(this);
			deltebtn.addActionListener(this);
			setFontforall();	
		
			
			
		



		
		private void setFontforall() {
			
			Font fontii= new Font("Georgia", Font.ITALIC,18); 
			Artistidlb.setFont(fontii);
			NMlb.setFont(fontii);
			GRlb.setFont(fontii);
			WSlb.setFont(fontii);
			CElb.setFont(fontii);
			
			
			ArtistidTextField.setFont(fontii);
			NMTextField.setFont(fontii);
			GRTextField.setFont(fontii);
			WSTextField.setFont(fontii);
			CETextField.setFont(fontii);
			
			
			
			Font fii=new Font("CourierNew",Font.BOLD,12);
			insertbtn.setFont(fii);
			readbtn.setFont(fii);
			updatebtn.setFont(fii);
			deltebtn.setFont(fii);
		}
			// TODO Auto-generated method stub
			
		


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}	
		



	public static  void main(String[] args) {
		Artistsform atc=	new Artistsform();

	}}
	


	

























