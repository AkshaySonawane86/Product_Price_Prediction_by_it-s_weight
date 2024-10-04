package Product.Repo;

import Product.Model.ProductModel;
import Product.Services.PredictionService;

import java.util.*;
import java.sql.*;

public class ProductRep {

	int id;
	List<ProductModel> list;
	PredictionService pss = new PredictionService();
	public boolean addProduct(ProductModel pm,int id) throws SQLException
	{
		
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		try
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
			if(conn!=null)
			{
			  PreparedStatement stmt = conn.prepareStatement("insert into product values('0',?,?,?,?)");
			  stmt.setString(1, pm.getProduct());
			  stmt.setInt(2, id);
			  stmt.setInt(3, pm.getWeiht());
			  stmt.setInt(4, pm.getPrice());
			  int value=stmt.executeUpdate();
			  return value>0?true:false;
			}
			else
			{
				System.out.println("Something is error..");
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			System.out.println("2222222");
			return false;
		}
	}
	
	public List<ProductModel> showProduct() throws SQLException
	{
		list = new ArrayList<ProductModel>();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction","root", "Akki0987");
		if(conn!=null)
		{
			try {
			PreparedStatement stmt = conn.prepareStatement("select Product_id,PName,CName,Weight,Price from product p inner join category c on p.category_id=c.category_id");
		    ResultSet rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	ProductModel pm = new ProductModel();
		    	pm.setId(rs.getInt(1));
		    	pm.setProduct(rs.getString(2));
		    	pm.setCategory(rs.getString(3));
		    	pm.setWeiht(rs.getInt(4));
		    	pm.setPrice(rs.getInt(5));
		    	
		    	list.add(pm);
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
			System.out.println("Something wrong..");
			return null;
		}
	}
	
	public boolean deleteProduct(String name,int weight) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try {
			PreparedStatement stmt =  conn.prepareStatement("delete from product where PName=? and weight=?");
			stmt.setString(1, name);
			stmt.setInt(2, weight);
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
			System.out.println("Error..");
			return false;
		}
	}
	
	public boolean updateProduct(String product,String name) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try {
			PreparedStatement stmt = conn.prepareStatement("update product set PName=? where PName=?");
			stmt.setString(1, name);
			stmt.setString(2,product);
			int value=stmt.executeUpdate();
			return value>0?true:false;
			}
			catch(Exception ex)
			{
				System.out.println("Error is"+ex);
				return false;
			}
		}
		else
		{
			System.out.println("Something wrong..");
			return false;
		}
	}
	
	public List<ProductModel> orderProduct(int cid) throws SQLException
	{
		list=new ArrayList<ProductModel>();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select *from product where Category_id=?");
				stmt.setInt(1, cid);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					ProductModel pm = new ProductModel();
					pm.setId(rs.getInt(1));
					pm.setProduct(rs.getString(2));
					pm.setWeiht(rs.getInt(4));
					pm.setPrice(rs.getInt(5));
					
					list.add(pm);
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
	
	public boolean getProductName(String name,int weight) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select *from product where pname=? and weight=?");
				stmt.setString(1, name);
				stmt.setInt(2, weight);
				int value=stmt.executeUpdate();
				return value>0?true:false;
			}
			catch(SQLException ex)
			{
				return false;
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				System.out.println("111111111");
				return false;
			}
		}
		else
		{
			System.out.println("Driver not Connected");
			return false;
		}
	}
	
	public int[] getProductId(String name,int weight) throws SQLException
	{
		int ans[]=new int[2];
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select *from product where pname=? and weight=?");
				stmt.setString(1, name);
				stmt.setInt(2, weight);
				ResultSet rs = stmt.executeQuery();
				if(rs.next())
				{
					ans[0]=rs.getInt(1);
					ans[1]=rs.getInt(5);
					return ans;
				}
				else
				{
//					try
//					{
//						PreparedStatement stmt1 = conn.prepareStatement("select *from product where pname=?");
//						stmt1.setString(1, name);
//						ResultSet rs1 = stmt1.executeQuery();
//						if(rs1.next())
//						{
//							ans[0]=rs1.getInt(1);							
//						}
//						ans[1]=pss.showPrediction(name,weight);
//						return ans;
//					}
//					catch(Exception ex)
//					{
//						System.out.println("Error is "+ex);
//						ans[0]=0;
//						ans[1]=0;
//						return ans;
//					}
					ans[0]=0;
					ans[1]=0;
					return ans;
//					return null;
				}
			}
//			catch(SQLIntegrityConstraintViolationException ex)
//			{
//				ans[1]=pss.showPrediction(name,weight);
//				System.out.println("$$$$$");
//				return ans;
//			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				System.out.println("*********");
				ans[0]=0;
				ans[1]=0;
				return ans;
				//second method-->return null;
			}
		}
		else
		{
			System.out.println("Driver not Connected");
			return null;
		}
	}
}
