package session1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;


public class LoginDemo implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel lab1,lab2;
	JTextField t1,t2;
	JButton b1,b2;
	
	public LoginDemo() 
	{
		f = new JFrame("Login Form");
		p = new JPanel();
		p.setLayout(null);
		
		lab1= new JLabel("UserName");
		lab1.setBounds(50, 60, 80, 20);
		lab2= new JLabel("Password");
		lab2.setBounds(50, 100, 80, 20);
		
		
		t1= new JTextField();
		t1.setBounds(130, 60, 80, 20);
		t2= new JTextField();
		t2.setBounds(130, 100, 80, 20);
		
		
		b1 = new JButton("Submit");
		b1.setBounds(90, 150, 80, 25);
		b2= new JButton("Reset");
		b2.setBounds(180, 150, 80, 25);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p.add(lab1);
		p.add(lab2);
		p.add(t1);
		p.add(t2);
		p.add(b1);
		p.add(b2);
		
		f.add(p);
		f.setSize(400, 500);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new LoginDemo();
	}


	public void actionPerformed(ActionEvent e) 
	{
		
		String username= t1.getText();
		String pass= t2.getText();
		
		if(e.getSource()==b1)
		{
		

			try{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/ruchitha","root",""); 
			
			 
			System.out.println("connected");
			String sql = "insert into login values('"+username+"','"+pass+"')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, "Login is Successfull!!!");
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		if(e.getSource()==b2)
		{
			
			
		}
	}


	
}





