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

public class Ticketform implements ActionListener{
	JFrame frame;
	JLabel Ticketidlb= new JLabel("TK_TICKETID");
	JLabel PRlb= new JLabel("TK_PRICE");
	JLabel PDlb= new JLabel("TK_PURCHASEDATE");
	
	JTextField TicketidTextField= new JTextField();    
	JTextField PRTextField= new JTextField();
	JTextField PDTextField= new JTextField();
	
	JButton insertbtn= new JButton ("INSERT");
	
	
	
	JButton readbtn= new JButton ("READ");
	JButton updatebtn= new JButton ("UPDATE");
	JButton deltebtn= new JButton ("DELTE");
	
	public Ticketform() {
		createwindows1();
	}
	
	
	private void createwindows1() {
		frame= new JFrame();
		frame.setTitle("TICKETFORM");
		frame.setBounds(10,10,500,400);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		setsizeandlocation();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	 
	
	private void setsizeandlocation() {
		Ticketidlb.setBounds(10,10,200,30);
		PRlb.setBounds(10,50,200,30);
		PDlb.setBounds(10,90,200,30);
		
		
		TicketidTextField.setBounds(160,10,130,30);
		PRTextField.setBounds(160,50,130,30);
		PDTextField.setBounds(160,90,130,30);
		
		
		insertbtn.setBounds(10,250,85,30);
		readbtn.setBounds(100,250,85,30);
		updatebtn.setBounds(190,250,85,30);
		deltebtn.setBounds(280,250,85,30);
		addcomponenttoframe();
		
		// TODO Auto-generated method stub
		
	}


	private void addcomponenttoframe() {
		frame.add(Ticketidlb);
		frame.add(PRlb);
		frame.add(PDlb);
		
		frame.add(TicketidTextField);
		frame.add(PRTextField);
		frame.add(PDTextField);
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
					String query="INSERT INTO Ticket VALUES(?,?,?)";
					PreparedStatement pStatement=connection.prepareStatement(query);
					pStatement.setInt(1,Integer.parseInt(TicketidTextField.getText()));
					pStatement.setString(2, PRTextField.getText());
			        pStatement.setInt(3,Integer.parseInt(PDTextField.getText()));
				
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
					String sql="UPDATE ticket SET TK_PRICE=?,TK_PURCHASEDATE=? WHERE TK_TICKETID=?";
					PreparedStatement stm=connection.prepareStatement(sql);
				
					stm.setString(1, PRTextField.getText());
					stm.setInt(2,Integer.parseInt(PDTextField.getText()));
					stm.setString(3,TicketidTextField.getText());
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
				String delete_id=TicketidTextField.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");	
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music","root","");
					String sql="DELETE FROM ticket  WHERE TK_TICKETID='"+delete_id+"'";
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
		Ticketidlb.setFont(fontii);
		PRlb.setFont(fontii);
		PDlb.setFont(fontii);
		
		
		
		TicketidTextField.setFont(fontii);
		PRTextField.setFont(fontii);
		PDTextField.setFont(fontii);
		
		
		
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



public static void main(String[] args) {
	Ticketform atf=new Ticketform();

}
}
