package session1;

	import java.sql.*;
	import java.util.Scanner;  
	class MysqlCon{  
	public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/ruchitha","root","");   
	Statement stmt=con.createStatement(); 

	Scanner k = new Scanner(System.in); 
	System.out.println("enter ssn"); 
	String ssn = k.next(); 
	System.out.println("enter name"); 
	String name = k.next(); 
	System.out.println("enter address"); 
	String address = k.next(); 
	System.out.println("enter sex");
	String sex = k.next();
	System.out.println("enter salary");
	int salary = k.nextInt();
	System.out.println("enter superssn");
	String superssn = k.next();
	System.out.println("enter dno");
	int dno = k.nextInt();

	//Inserting data using SQL query 
	String sql = "insert into employee values('"+ssn+"','"+name+"','"+address+"','"+sex+"',"+salary+",'"+superssn+"',"+dno+")"; 

	try
	{ 
		
		//Reference to connection interface 
		Statement st = con.createStatement(); 
		int m = st.executeUpdate(sql); 
		if (m == 1) 
			System.out.println("inserted successfully : "+sql); 
		else
			System.out.println("insertion failed"); 
	} 
	catch(Exception ex) 
	{ 
		System.err.println(ex); 
	}

	ResultSet rs=stmt.executeQuery("select name from employee where name like 's%' ");  
	while(rs.next())  
	System.out.println(rs.getString(1));
	ResultSet rs1=stmt.executeQuery("select name from employee where dno=2");  
	while(rs1.next())  
	System.out.println(rs1.getString(1));
	
	con.close();  
	}catch(Exception e){ System.out.println(e);}  
	}  
	}  





