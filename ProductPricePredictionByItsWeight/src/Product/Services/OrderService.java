package Product.Services;

import java.sql.SQLException;

import Product.Repo.CustomerRep;
import Product.Repo.OrderRep;
import Product.Repo.ProductRep;
import Product.Model.OrderModel;
import Product.Model.ProductModel;

import java.util.*;

public class OrderService {

	CustomerRep cr = new CustomerRep();
	ProductRep pr = new ProductRep();
	OrderRep or = new OrderRep();
	PredictionService ps = new PredictionService();
//	PredictionService pss = new PredictionService();
	public int addOrder(String name,String customerName,int weight,int cid) throws SQLException
	{
		int id=cr.getId(customerName);
		boolean b=pr.getProductName(customerName, weight);
		if(b)
		{
			int ans[]=pr.getProductId(name, weight);
			int ProductId=ans[0];
			int Price=ans[1];
//			System.out.println("ProductId is "+ans[0]);
//			System.out.println("Price is "+ans[1]);
			or.addOrder(id,ProductId);
			return Price;
		}
		else
		{
			int price=ps.showPrediction(name,weight);
			ProductModel pm= new ProductModel();
    	    pm.setProduct(name);
    	    pm.setWeiht(weight);
    	    pm.setPrice(price);
    	    ProductRep pr = new ProductRep();
    	    b=pr.addProduct(pm,cid);;
    	    if(b)
    	    {
//    	    	System.out.println("Product added..");
    	    	int ans[]=pr.getProductId(name, weight);
    			int ProductId=ans[0];
    			int Price=ans[1];
    			or.addOrder(id,ProductId);
    			return Price;
    	    }
    	    else
    	    {
    	    	System.out.println("Something error in product");
//    	    	int ProductId=0;
    			int Price=0;
    			return Price;
    	    }
		}
		//int productId=pr.getProductId(name,weight);
		//System.out.println("Customer id "+id);
		//System.out.println("Product id "+productId);
		//return or.addOrder(id,productId);
	}
	
	public List<OrderModel>showCustomerOrder(String customerName) throws SQLException
	{
		int id=cr.getId(customerName);
		return or.showCustomerOrder(id);
	}
	
//	public boolean deleteOrder(String name) throws SQLException
//	{
//		int productId=pr.deleteOrder(name);
//		return or.deleteOrder(productId);
//	}
	
	public List<OrderModel>showOrder() throws SQLException
	{
		return or.showOrder();
	}

	public boolean billCheck(String customerName) throws SQLException
	{
		return or.billCheck(customerName);
	}
	
	public int bill(String customerName) throws SQLException
	{
		return or.bill(customerName);
	}
	
	public List<OrderModel> orderList(String customerName) throws SQLException
	{
		return or.orderList(customerName);
	}
}
