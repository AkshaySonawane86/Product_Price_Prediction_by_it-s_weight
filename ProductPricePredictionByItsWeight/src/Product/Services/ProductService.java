package Product.Services;

import java.sql.SQLException;
import java.util.*;

import Product.Model.ProductModel;
import Product.Repo.CategoryRep;
import Product.Repo.ProductRep;

public class ProductService {

	CategoryRep cr = new CategoryRep();
	ProductRep pr = new ProductRep();
	public boolean addProduct(ProductModel pm,String category) throws SQLException
	{
		int id=cr.findCategory(category);
		return pr.addProduct(pm,id);
	}
	
	public List<ProductModel> showProduct() throws SQLException
	{
		return pr.showProduct();
	}
	
	public boolean deleteProduct(String name,int weight) throws SQLException
	{
		return pr.deleteProduct(name,weight);
	}
	
	public boolean updateProduct(String product,String name) throws SQLException
	{
		return pr.updateProduct(product,name);
	}
	
	public List<ProductModel> orderProduct(int cid) throws SQLException
	{
		return pr.orderProduct(cid);
	}
}
