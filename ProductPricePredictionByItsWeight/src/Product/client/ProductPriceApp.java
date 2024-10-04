package Product.client;
import java.sql.SQLException;
import java.util.*;

import Product.Model.AdminModel;
import Product.Model.CategoryModel;
import Product.Model.CustomerModel;
import Product.Model.OrderModel;
import Product.Model.ProductModel;
import Product.Services.AdminService;
import Product.Services.CategoryService;
import Product.Services.CustomerService;
import Product.Services.OrderService;
import Product.Services.PredictionService;
import Product.Services.ProductService;
public class ProductPriceApp {

	public static void main(String x[]) throws SQLException
	{
		AdminService as = new AdminService();
		CategoryService cr = new CategoryService();
		ProductService ps = new ProductService();
		CustomerService cs = new CustomerService();
		OrderService os = new OrderService();
		PredictionService pss = new PredictionService();
		
		int choice2,choice3,choice4;
		
			do
			{
				Scanner xyz = new Scanner(System.in);
				System.out.println("***********************************************************");
				System.out.println("1: Add new admin");
				System.out.println("2: Add new product in shop database or store/view/delete/update");
				System.out.println("3: Add new customer");
				System.out.println("4: View costomer");
				System.out.println("5: Check prediction");
				System.out.println("6: Check all customer orders");
				System.out.println("Enter your choice");
				int choice=xyz.nextInt();
				switch(choice)
				{
				  case 1:
					      xyz.nextLine();
					      System.out.println("***Sign up***");
					      String name=null;
					      while(true)
					      {
					    	  System.out.println("Enter the admin name");
						      name=xyz.nextLine();
						      int flag=as.Name(name);
						      if(flag==1)
						      {
						    	  break;
						      }
					      }
					      System.out.println("Enter the password");
					      String password=xyz.nextLine();
					      String contact=null;
					      while(true)
					      {
					    	  System.out.println("Enter the contact");
						      contact=xyz.nextLine();
						      int flag=as.Contact(contact);
						      if(flag==1)
						      {
						    	  break;
						      }
					      }
					      
					      AdminModel am=new AdminModel();
					      am.setName(name);
					      am.setPassword(password);
					      am.setConatact(contact);
					      
					      boolean b=as.setAdmin(am);
					      if(b)
					      {
					    	  System.out.println("Admin add successfully...");
					      }
					      else
					      {
					    	  System.out.println("Admin present already");
					      }
					      break;
					      
				  case 2:
					      xyz.nextLine();
					      System.out.println("***Admin login***");
					      while(true)
					      {
					    	  System.out.println("Enter the admin name");
						      name=xyz.nextLine();
						      int flag=as.Name(name);
						      if(flag==1)
						      {
						    	  break;
						      }
					      }
//					      System.out.println("Enter the name");
//					      name=xyz.nextLine();
					      System.out.println("Enter the password");
					      password=xyz.nextLine();
					      b=as.checkAdmin(name,password);
					      if(b)
					      {
					    	  System.out.println("***** Welcome "+name+" *****");
					    	  int choice1;
					    	  do
					    	  {
					    		  System.out.println("1: Add new category");
					    		  System.out.println("2: Add new product");
					    		  System.out.println("3: View product");
					    		  System.out.println("4: delete product");
					    		  System.out.println("5: update product");
					    		  System.out.println("6: Exit");
					    		  System.out.println("Enter the choice");
					    		  choice1=xyz.nextInt();
					    		  switch(choice1)
					    		  {
					    		    case 1:
					    		    	    xyz.nextLine();
					    		    	    System.out.println("Enter the category name ");
					    		    	    String category=xyz.nextLine();
					    		    	    
					    		    	    int categoryPresent=cr.findCategory(category);
					    		    	    if(categoryPresent==0)
					    		    	    {
					    		    	    
					    		    	      CategoryModel cm = new CategoryModel();
					    		    	      cm.setCategory(category);
					    		    	    
					    		    	      b=cr.addCategory(cm);
					    		    	      if(b)
					    		    	      {
					    		    	    	 System.out.println("Category added..");
					    		    	      }
					    		    	      else
					    		    	      {
					    		    	         System.out.println("Something wrog...");
					    		    	      }
					    		    		
					    		    	    }
					    		    	    else
					    		    	    {
					    		    	    	System.out.println("Category already present");
					    		    	    }
					    		    	    break;
					    		    	    
					    		    case 2:
					    		    	    xyz.nextLine();
					    		    	    List<CategoryModel> CategoryName=cr.showCategory();
					    		    	    System.out.println("Category Name");
						    			    for(CategoryModel m:CategoryName)
						    			    {
						    			      System.out.println(" "+m.getCategory());
						    			    }
						    			    System.out.println("Enter the category name");
					    		    	    category=xyz.nextLine();
					    		    	    System.out.println("Enter product name");
					    		    	    String product=xyz.nextLine();
					    		    	    System.out.println("Enter the weight");
					    		    	    int weight=xyz.nextInt();
					    		    	    System.out.println("Enter the price");
					    		    	    int price=xyz.nextInt();
					    		    	    
					    		    	    ProductModel pm= new ProductModel();
					    		    	    pm.setProduct(product);
					    		    	    pm.setWeiht(weight);
					    		    	    pm.setPrice(price);
					    		    	    
					    		    	    b=ps.addProduct(pm,category);
					    		    	    if(b)
					    		    	    {
					    		    	    	System.out.println("Product added..");
					    		    	    }
					    		    	    else
					    		    	    {
					    		    	    	System.out.println("Something error is there...");
					    		    	    }
					    		    	    break;
					    		    case 3:
					    		    	    List<ProductModel> productlist=ps.showProduct();
					    		    	    System.out.println("Product\t\t\tCategory\tWeight\tPrice");
					    		    	    for(ProductModel p:productlist)
					    		    	    {
					    		    	    	System.out.print(p.getProduct()+"   \t     ");
					    		    	    	System.out.println("    "+p.getCategory()+"     \t"+p.getWeiht()+"kg\t₹"+p.getPrice());			    		    	
					    		    	    }
					    		    	    break;
					    		    case 4:
					    		    	    xyz.nextLine();
   		    	    			            List<CategoryModel> CategoryName1=cr.showCategory();
   		    	    			            System.out.println("Category Name");
   		    	    			            for(CategoryModel cm:CategoryName1)
   		    	    			            {
   		    	    			            	 System.out.println(" "+cm.getCategory());
   		    	    			            }
   		    	    			            System.out.println("Enter the category name");
   		    	    			            category=xyz.nextLine();
   		    	    			            int cid=cr.findCategory(category);
   		    	    			            List<ProductModel> pm1=ps.orderProduct(cid);
   		    	    			            System.out.println("Productname\t  \tweight\tprice");
   		    	    			            for(ProductModel m:pm1)
   		    	    			            {
   		    	    			    	        System.out.print(m.getProduct()+"   \t     ");
					    		    	    	System.out.println("    "+m.getWeiht()+"kg\t₹"+m.getPrice());	
					    		    	    }
					    		    	    System.out.println("Enter the product name");
					    		    	    name=xyz.nextLine();
					    		    	    System.out.println("Enter the weight name");
					    		    	    weight=xyz.nextInt();
					    		    	    b=ps.deleteProduct(name,weight);
					    		    	    if(b)
					    		    	    {
					    		    	    	System.out.println("Product delete successfully..");
					    		    	    }
					    		    	    else
					    		    	    {
					    		    	    	System.out.println("Something wrong...");
					    		    	    }
					    		    	    break;
					    		    case 5:
					    		    	    xyz.nextLine();
					    		    	    System.out.println("Enter the product name");
					    		    	    product=xyz.nextLine();
					    		    	    System.out.println("Enter the new product name");
					    		    	    name=xyz.nextLine();
					    		    	    b=ps.updateProduct(product,name);
					    		    	    if(b)
					    		    	    {
					    		    	    	System.out.println("Product updated successfully..");
					    		    	    }
					    		    	    else
					    		    	    {
					    		    	    	System.out.println("Something wrong..");
					    		    	    }
					    		  }
					    	  }while(choice1<=5);
					      }
					      else
					      {
					    	  System.out.println("Admin not found");
					      }
					      break;
					      
				  case 3:
					      do
					      {
					    	  System.out.println("1: Add new customer");
					    	  System.out.println("2: Delete customer");
					    	  System.out.println("3: Exit");
					    	  System.out.println("Enter the choice no");
					    	  choice2=xyz.nextInt();
					    	  switch(choice2)
					    	  {
					    	    case 1:
					    	    	    xyz.nextLine();
					    	    	    System.out.println("***Sign up***");
					    	    	    while(true)
									      {
					    	    	    	  System.out.println("Enter the customer name");
										      name=xyz.nextLine();
										      int flag=cs.Name(name);
										      if(flag==1)
										      {
										    	  break;
										      }
									      }
//					    	    	    System.out.println("Enter the customer name");
//					    	    	    name=xyz.nextLine();
					    	    	    System.out.println("Enter the customer password");
					    	    	    password=xyz.nextLine();
					    	    	    while(true)
									      {
									    	  System.out.println("Enter the contact");
										      contact=xyz.nextLine();
										      int flag=cs.Contact(contact);
										      if(flag==1)
										      {
										    	  break;
										      }
									      }
//					    	    	    System.out.println("Enter the contact");
//					    	    	    contact=xyz.nextLine();
					    	    	    
					    	    	    CustomerModel cm = new CustomerModel();
					    	    	    cm.setName(name);
					    	    	    cm.setPassword(password);
					    	    	    cm.setContact(contact);
					    	    	    
					    	    	    b=cs.addCustomer(cm);
					    	    	    if(b)
					    	    	    {
					    	    	    	System.out.println("Customer added successfully..");
					    	    	    }
					    	    	    else
					    	    	    {
					    	    	    	System.out.println("Customer present Already");
					    	    	    }
					    	    	    break;
					    	    case 2:
					    	    	    xyz.nextLine();
					    	    	    System.out.println("Enter the customer");
					    	    	    name=xyz.nextLine();
					    	    	    b=cs.deleteCustomer(name);
					    	    	    if(b)
					    	    	    {
					    	    	    	System.out.println("Deleted customer");
					    	    	    }
					    	    	    else
					    	    	    {
					    	    	    	System.out.println("Something wrong..");
					    	    	    }
					    	  }
					      }while(choice2<3);
					      break;
					      
				  case 4:
					      do
					      {
					    	  System.out.println("1: View product");
				    		  System.out.println("2: Order product & Customer login");
				    		  System.out.println("3: Exit");
				    		  System.out.println("Enter the choice no");
				    		  choice3=xyz.nextInt();
				    		  switch(choice3)
				    		  {
				    		    case 1:
				    		    	   List<ProductModel> productlist=ps.showProduct();
		    		    	           System.out.println("Product\t\t\tCategory\tWeight\tPrice");
		    		    	           for(ProductModel p:productlist)
		    		    	           {
		    		    	        	  System.out.print(p.getProduct()+"   \t     ");
			    		    	    	  System.out.println("    "+p.getCategory()+"     \t"+p.getWeiht()+"kg\t₹"+p.getPrice());			    		    	
			    		    	    
		    		    	           }	
		    		    	           break;
				    		    case 2:
				    		    	   System.out.println("***Customer login***");
				    		    	   xyz.nextLine();
				    		    	   while(true)
									      {
					    	    	    	  System.out.println("Enter the customer name");
										      name=xyz.nextLine();
										      int flag=cs.Name(name);
										      if(flag==1)
										      {
										    	  break;
										      }
									      }
//				    		    	   System.out.println("Enter the customer name");
//			   					       name=xyz.nextLine();
			   					       String customerName=name;
			   					       System.out.println("Enter the password");
			   					       password=xyz.nextLine();
			   					       b=cs.findCustomer(name,password);
			   					       if(b)
			   					       {
			   					    	  System.out.println("***** Welcome "+name+" *****");
			    		    	         do
			    		    	         {
			    		    	      
			    		    	    	 System.out.println("1: Order new Product");
			    		    	    	 System.out.println("2: Today bill for product");
			    		    	    	 System.out.println("3: Check previous order details");
			    		    	    	 System.out.println("4: exit");
			    		    	    	 System.out.println("Enter the choice no");
			    		    	    	 choice4=xyz.nextInt();
			    		    	    	 switch(choice4)
			    		    	    	 {
			    		    	    		 case 1:
			    		    	    			     xyz.nextLine();
			    		    	    			     List<CategoryModel> CategoryName=cr.showCategory();
			    		    	    			     System.out.println("Category Name");
			    		    	    			     for(CategoryModel cm:CategoryName)
			    		    	    			     {
			    		    	    			    	 System.out.println(" "+cm.getCategory());
			    		    	    			     }
			    		    	    			     System.out.println("Enter the category name");
			    		    	    			     String category=xyz.nextLine();
			    		    	    			     int cid=cr.findCategory(category);
			    		    	    			     List<ProductModel> pm=ps.orderProduct(cid);
			    		    	    			     System.out.println("Productname\t  \tweight\tprice");
			    		    	    			     for(ProductModel m:pm)
			    		    	    			     {
//			    		    	    			    	 System.out.print(m.getId()+"\t"+m.getProduct()+"   \t     ");
			    		    	    			    	 System.out.print(m.getProduct()+"   \t     ");
								    		    	    	System.out.println("    "+m.getWeiht()+"kg\t₹"+m.getPrice());	
								    		    	 }
			    		    	    			     System.out.println("Enter the product name");
			    		    	    			     name=xyz.nextLine();
			    		    	    			     System.out.println("Enter the product weight");
			    		    	    			     int weight=xyz.nextInt();
			    		    	    			     int price=os.addOrder(name,customerName,weight,cid);
			    		    	    			     if(price==0)
			    		    	    			     {
			    		    	    			    	 System.out.println("Something wrong..");
			    		    	    			     }
			    		    	    			     else
			    		    	    			     {
			    		    	    			    	 System.out.println("price is ₹"+price);
			    		    	    			    	 System.out.println("Product add successfully..");
			    		    	    			     }
			    		    	    			     break;
			    		    	    			     
			    		    	    		 case 2:
//			    		    	    			     b=os.billCheck(customerName);
//			    		    	    			     if(b)
//			    		    	    			     {
//			    		    	    			    	System.out.println("Order first");
//			    		    	    			     }
//			    		    	    			     else
//			    		    	    			     {
//			    		    	    			    	 System.out.println("Bill is ");
//			    		    	    			     }
			    		    	    			     List<OrderModel> order=os.orderList(customerName);
			    		    	    			     try { 
			    		    	    			    	 System.out.println("CustomerName\tProductName\t\tCategory\tWeight\tPrice\tDate");
			    		    	    			         for(OrderModel m:order)
			    		    	    			         {
			    		    	    			    	    System.out.print(m.getName()+"\t\t");
								    		    	    	System.out.print(m.getPname()+"   \t     ");
								    		    	    	System.out.println("    "+m.getCname()+"     \t"+m.getWeight()+"kg\t₹"+m.getPrice()+"\t"+m.getDate());
			    		    	    			         }
			    		    	    			         int bill=os.bill(customerName);
			    		    	    			         if(bill>0)
			    		    	    			         {
			    		    	    			    	    System.out.println("************Bill is "+bill+"********");
			    		    	    			         }
			    		    	    			         else
			    		    	    			         {
			    		    	    			    	    System.out.println("Something wrong");
			    		    	    			          }
			    		    	    			      }
			    		    	    			      catch(NullPointerException ex)
			    		    	    			      {
			    		    	    			    	 System.out.println("Order first");
			    		    	    			      }
			    		    	    			     break;
			    		    	    		 case 3:
							    		    	     List<OrderModel> OrderList = os.showCustomerOrder(customerName);
							    		    	     System.out.println("CustomerName\tProductName\t\tCategory\tWeight\tPrice\tDate");
							    		    	     for(OrderModel m : OrderList)
							    		    	     {
							    		    	    	System.out.print(m.getName()+"\t\t");
//							    		    	    	+m.getPname()+"\t    \t"+m.getCname()+"     \t"+m.getWeight()+"kg\t₹"+m.getPrice()+"\t"+m.getDate());
							    		    	    	System.out.print(m.getPname()+"   \t     ");
//							    		    	    	System.out.print(p.getId()+"\t"+p.getProduct()+"   \t     ");
							    		    	    	System.out.println("    "+m.getCname()+"     \t"+m.getWeight()+"kg\t₹"+m.getPrice()+"\t"+m.getDate());			    		    	
//							    		    	    	System.out.println("     \t"+m.getWeight()+"kg\t₹"+m.getPrice()+"\t"+m.getDate());	
							    		    	     }
							    		    	     break;
			    		    	    	  }
			    		    	        }while(choice4<4);
			   					      }
			    		    	     else
								      {
								    	  System.out.println("Customer not found");
								      }
								      break;

				    		  }
				    	  }while(choice3<2);    
					    break;
					    		    	    
					    		   
					    		    
//					    		    case 4:
//					    		    	    xyz.nextLine();
//					    		    	    System.out.println("Enter the product name");
//					    		    	    name=xyz.nextLine();
//					    		    	    b=os.deleteOrder(name);
//					    		    	    if(b)
//					    		    	    {
//					    		    	    	System.out.println("Order delete successfully");
//					    		    	    }
//					    		    	    else
//					    		    	    {
//					    		    	    	System.out.println("Something wrong");
//					    		    	    }
					    		    	    //break;
					    		 
					      
					      
				  case 5:
					      xyz.nextLine();
	    			      List<CategoryModel> CategoryName=cr.showCategory();
	    			      for(CategoryModel cm:CategoryName)
	    			      {
	    			    	 System.out.println(cm.getId()+"\t"+cm.getCategory());
	    			      }
	    			      System.out.println("Enter the category");
	    			      name=xyz.nextLine();
	    			      int cid=cr.findCategory(name);
 	    			      List<ProductModel> pm=ps.orderProduct(cid);
 	    			      for(ProductModel m:pm)
 	    			      {
 	    			    	 System.out.print(m.getProduct()+"   \t     ");
	    		    	    	System.out.println("    "+m.getWeiht()+"kg\t₹"+m.getPrice());
	    		    	  }
 	    			      System.out.println("Enter the product name");
	    			      name=xyz.nextLine();
	    			      System.out.println("Enter the prediction weight(kg)");
	    			      int weight=xyz.nextInt();
	    			      int price=pss.showPrediction(name,weight);
	    			      if(price==0)
	    			      {
	    			    	  System.out.println("Something wrong..");
	    			      }
	    			      else
	    			      {
	    			    	  System.out.println("Price is ₹"+price);
	    			      }
					      break;
				  case 6:
					      List<OrderModel> OrderList = os.showOrder();
					      System.out.println("CustomerName\tProductName\t\tCategory\tWeight\tPrice\tDate");
		    	          for(OrderModel m : OrderList)
		    	          {
//		    	        	System.out.println(m.getId()+"\t"+m.getName()+"\t\t"+m.getPname()+"\t\t"+m.getCname()+"     \t"+m.getWeight()+"kg\t₹"+m.getPrice()+"\t"+m.getDate2());
		    	        	  System.out.print(m.getName()+"\t\t");	    		    	   
	    		    	    	System.out.print(m.getPname()+"   \t     ");
	    		    	    	System.out.println("    "+m.getCname()+"     \t"+m.getWeight()+"kg\t₹"+m.getPrice()+"\t"+m.getDate2());
		    	          }
					      break;
					      
				  default:
					      System.out.println("Wrong choice");
				}
			}while(true);
		}
	

}
