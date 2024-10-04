package Product.Repo;

import java.sql.*;

import Product.Model.OrderModel;
import java.util.*;

public class OrderRep {

	List<OrderModel> list;
	List<OrderModel> list2;
	public boolean addOrder(int id,int productId) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
	    if(conn!=null)
	    {
	    	try
	    	{
	    	  PreparedStatement stmt = conn.prepareStatement("insert into order_table values(?,?,curdate())");
	    	  stmt.setInt(1, id);
	    	  stmt.setInt(2, productId);
	    	  int value=stmt.executeUpdate();
	    	  return value>0?true:false;
	    	}
	    	catch(Exception ex)
	    	{
	    		System.out.println("Error is "+ex);
//	    		System.out.println("11111111111111");
	    		return false;
	    	}
	    }
	    else
	    {
	    	System.out.println("Driver not connected");
	    	return false;
	    }
	}
	
	public List<OrderModel>showCustomerOrder(int id) throws SQLException
	{
		list = new ArrayList<OrderModel>();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("select c.customer_id,c.name,p.pname,cc.cname,p.weight,p.price,o.order_date from order_table o inner join customer c on o.customer_id=c.customer_id inner join product p on o.product_id=p.product_id inner join category cc on p.category_id=cc.category_id where c.customer_id=?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					OrderModel om = new OrderModel();
					om.setId(rs.getInt(1));
					om.setName(rs.getString(2));
					om.setPname(rs.getString(3));
					om.setCname(rs.getString(4));
					om.setWeight(rs.getInt(5));
					om.setPrice(rs.getInt(6));
//					First Method*********
//					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					String date = dateFormat.format(rs.getDate(6));
//					om.setDate(date);
//					Second Method**********
					om.setDate(rs.getDate(7));
					list.add(om);
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
	
	public boolean deleteOrder(int productId) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement("delete from order_table where Product_id=?");
				stmt.setInt(1, productId);
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
			System.out.println("Driver not connected");
			return false;
		}
	}
	
	public List<OrderModel>showOrder() throws SQLException
	{
		list = new ArrayList<OrderModel>();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				PreparedStatement stmt = conn.prepareStatement(" select c.customer_id,c.name,p.pname,cc.cname,p.weight,p.price,o.order_date from order_table o inner join customer c on o.customer_id=c.customer_id inner join product p on o.product_id=p.product_id inner join category cc on p.category_id=cc.category_id");
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					OrderModel om = new OrderModel();
					om.setId(rs.getInt(1));
					om.setName(rs.getString(2));
					om.setPname(rs.getString(3));
					om.setCname(rs.getString(4));
					om.setWeight(rs.getInt(5));
					om.setPrice(rs.getInt(6));
					//om.setDate(rs.getDate(6));
//					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					String date = dateFormat.format(rs.getDate(6));
//					om.setDate2(date);
					om.setDate2(rs.getDate(7));
					list.add(om);
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
	
	public boolean billCheck(String customerName) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
			  PreparedStatement stmt=conn.prepareStatement("select c.customer_id from order_table o inner join customer c on o.customer_id=c.customer_id inner join product p on o.product_id=p.product_id inner join category cc on p.category_id=cc.category_id where c.name=? and o.order_date=curdate()");
			  stmt.setString(1, customerName);
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
			System.out.println("Driver not connected");
			return false;
		}
	}
	
	public int bill(String customerName) throws SQLException
	{
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
				int value=0;
				PreparedStatement stmt = conn.prepareStatement("select sum(price) from order_table o inner join customer c on o.customer_id=c.customer_id inner join product p on o.product_id=p.product_id inner join category cc on p.category_id=cc.category_id where c.name=? and o.order_date=curdate()");
				stmt.setString(1, customerName);
				ResultSet rs=stmt.executeQuery();
				if(rs.next())
				{
					value=rs.getInt(1);
				}
				return value;
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
	
	public List<OrderModel> orderList(String customerName) throws SQLException
	{
		list2 = new ArrayList();
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/priceprediction", "root", "Akki0987");
		if(conn!=null)
		{
			try
			{
//				int value=0;
				PreparedStatement stmt = conn.prepareStatement("select c.name,p.pname,cc.cname,p.weight,p.price,o.order_date from order_table o inner join customer c on o.customer_id=c.customer_id inner join product p on o.product_id=p.product_id inner join category cc on p.category_id=cc.category_id where c.name=? and o.order_date=curdate()");
				stmt.setString(1, customerName);
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
					OrderModel om= new OrderModel();
					om.setName(rs.getString(1));
					om.setPname(rs.getString(2));
					om.setCname(rs.getString(3));
					om.setWeight(rs.getInt(4));
					om.setPrice(rs.getInt(5));
					om.setDate(rs.getDate(6));
					
					list2.add(om);
				}
				return list2.size()>0?list2:null;
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
