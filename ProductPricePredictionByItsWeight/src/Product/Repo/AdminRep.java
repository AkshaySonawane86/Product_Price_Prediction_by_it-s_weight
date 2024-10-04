package Product.Repo;

import Product.Model.AdminModel;
import java.sql.*;
public class AdminRep {


	public boolean setAdmin(AdminModel am) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		try {
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		 if(conn!=null)
		 {
			 PreparedStatement stmt=conn.prepareStatement("insert into admin values('0',?,?,?)");
			 stmt.setString(1,am.getName());
			 stmt.setString(2, am.getPassword());
			 stmt.setString(3, am.getConatact());
			 int value=stmt.executeUpdate();
			 return value>0?true:false;
		 }
		 else
		 {
			 System.out.println("Someting problem is here....");
			 return false;
		 }
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}	
	}
	
	public boolean checkAdmin(String name,String password) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root","Akki0987");
		    if(conn!=null)
		    {
		    	PreparedStatement stmt = conn.prepareStatement("select *from admin where Aname=? and apassword=?");
		    	stmt.setString(1,name);
		    	stmt.setString(2, password);
		    	ResultSet rs = stmt.executeQuery();
		    	if(rs.next())
		    	{
		    		return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		    }
		    else
		    {
		    	System.out.println("Something wrong....");
		    	return false;
		    }
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}
	
	public boolean findAdmin(AdminModel am) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		try {
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		 if(conn!=null)
		 {
			 PreparedStatement stmt=conn.prepareStatement("select *from admin where (Aname=? and apassword=?) or conatact=?");
			 stmt.setString(1,am.getName());
			 stmt.setString(2, am.getPassword());
			 stmt.setString(3, am.getConatact());
			 ResultSet rs = stmt.executeQuery();
		    	if(rs.next())
		    	{
		    		return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		 }
		 else
		 {
			 System.out.println("Someting problem is here....");
			 return false;
		 }
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}	
	}
}
