package Product.Repo;

import Product.Model.CategoryModel;

import java.sql.*;
import java.util.*;

public class CategoryRep {

	List<CategoryModel> list;
	public boolean addCategory(CategoryModel cm) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
			if(conn!=null)
			{
				PreparedStatement stmt = conn.prepareStatement("insert into category values('0',?)");
				stmt.setString(1, cm.getCategory());
				int value=stmt.executeUpdate();
				return value>0?true:false;
			}
			else
			{
				System.out.println("Something error is there....");
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}
	
	public int findCategory(String category) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
			if(conn!=null)
			{
				PreparedStatement stmt = conn.prepareStatement("select *from category where CName=?");
				stmt.setString(1, category);
				ResultSet rs=stmt.executeQuery();
				if(rs.next())
				{
					return rs.getInt(1);
				}
				else
				{
					System.out.println("Something is wrong..");
					return 0;
				}
				
			}
			else
			{
				System.out.println("Something error is there....");
				return 0;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return 0;
		}
	}
	
	public List<CategoryModel>showCategory() throws SQLException
	{
		list = new ArrayList<CategoryModel>();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction","root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select *from category");
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					CategoryModel cm = new CategoryModel();
					cm.setId(rs.getInt(1));
					cm.setCategory(rs.getString(2));
					
					list.add(cm);
				}
				return list.size()>0?list:null;
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
