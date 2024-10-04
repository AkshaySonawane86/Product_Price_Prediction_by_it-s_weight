package Product.Services;

import java.sql.*;

import Product.Model.CustomerModel;
import Product.Repo.CustomerRep;

public class CustomerService {

	CustomerRep cr = new CustomerRep();
	public int Name(String name)
	{
		  char ch[]=name.toCharArray();
		  int flag=0;
		  for(int i=0;i<ch.length;i++)
		  {
		    if((ch[i]>=65 && ch[i]<=90)||(ch[i]>=97 && ch[i]<=122))
		   	{
				flag=1;
			}
			else
			{
				flag=0;
			}
		}
		if(flag==0)
		{
			System.out.println("Enter a valid name");
			return flag;
		}
		else
		{
			return flag;
		}
	}
	
	public int Contact(String contact)
	{
		char no[]=contact.toCharArray();
		int flag2=0;
		int flag=1;
		for(int i=0;i<no.length;i++)
		{
			if(no[i]>=48 && no[i]<=57) {
			    flag=1;	
			}
			else
			{
				flag=0;
				break;
			}
		}		
		if(flag==0)
		{
			System.out.println("Enter a valid No");
		}
		else
		{
			if(no.length>9 && no.length<11 && flag==1)
			{
				flag2=1;
			}
			else
			{
				System.out.println("Enter a valid 10 digit no");
			}
		}
			return flag2;	
	}
	public boolean addCustomer(CustomerModel cm) throws SQLException
	{
		boolean b = cr.findCustomer2(cm);
		if(b)
		{
			return false;
		}
		else
		{
			return cr.addCustomer(cm);
		}
		//return cr.addCustomer(cm);
	}
	
	public boolean deleteCustomer(String name) throws SQLException
	{
		return cr.deleteCustomer(name);
	}
	
	public boolean findCustomer(String name,String password) throws SQLException
	{
		return cr.findCustomer(name,password);
	}
}
