package Product.Repo;

import Product.Model.AdminModel;
import Product.Model.CustomerModel;
import java.sql.*;

public class CustomerRep {

//	int id;
	public boolean addCustomer(CustomerModel cm) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("insert into customer values('0',?,?,?)");
				stmt.setString(1, cm.getName());
				stmt.setString(2, cm.getPassword());
				stmt.setString(3, cm.getContact());
				int value=stmt.executeUpdate();
				return value>0?true:false;
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				return false;
			}
		}
		else
		{
			System.out.println("Something wrong..");
			return false;
		}
	}
	
	public boolean deleteCustomer(String name) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt=conn.prepareStatement("delete from customer where name=?");
				stmt.setString(1, name);
				int value=stmt.executeUpdate();
				return value>0?true:false;
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				return false;
			}
		}
		else
		{
			System.out.println("Something wrong..");
			return false;
		}
	}
	
	public boolean findCustomer(String name,String password) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select *from customer where Name=? and password=?");
				stmt.setString(1, name);
				stmt.setString(2,password);
				ResultSet rs = stmt.executeQuery();
				if(rs.next())
				{
//					id=rs.getInt(1);
					return true;
				}
				else
				{
					return false;
				}
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				return false;
			}
		}
		else
		{
			System.out.println("Driver not connected");
			return false;
		}
	}
	
	public int getId(String customerName) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction","root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select *from customer where name=?");
				stmt.setString(1, customerName);
				ResultSet rs = stmt.executeQuery();
				if(rs.next())
				{
					return rs.getInt(1);
				}
				else
				{
					return 0;
				}
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				return 0;
			}
		}
		else
		{
			System.out.println("Driver not connected");
			return 0;
		}
	}
	
	public boolean findCustomer2(CustomerModel cm) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		try {
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		 if(conn!=null)
		 {
			 PreparedStatement stmt=conn.prepareStatement("select *from customer where password=? or contact=?");
			 stmt.setString(1, cm.getPassword());
			 stmt.setString(2, cm.getContact());
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
