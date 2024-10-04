package Product.Repo;

import java.sql.SQLException;
import java.sql.*;
import java.util.*;

public class PredictionRep {

	List<Integer> weightNo;
	List<Integer> priceNo;
	
	public int findX(String name) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select avg(weight) from product where pname=?");
				stmt.setString(1, name);
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
	
	public int findY(String name) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select avg(price) from product where pname=?");
				stmt.setString(1, name);
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
	
	public List<Integer>Weight(String name) throws SQLException
	{
		weightNo = new ArrayList<Integer>();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select weight from product where pname=?");
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					weightNo.add(rs.getInt(1));
				}
				return weightNo.size()>0?weightNo:null;
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				return null;
			}
		}
		else
		{
			System.out.println("Driver not connected");
			return null;
		}
	}
	
	public List<Integer>Price(String name) throws SQLException
	{
		priceNo = new ArrayList<Integer>();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select price from product where pname=?");
				stmt.setString(1, name);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{	
					priceNo.add(rs.getInt(1));
				}
				return priceNo.size()>0?priceNo:null;
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				return null;
			}
		}
		else
		{
			System.out.println("Driver not connected");
			return null;
		}
	}
}
