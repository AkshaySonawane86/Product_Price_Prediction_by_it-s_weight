package Product.Services;

import java.sql.SQLException;

import Product.Model.CategoryModel;
import Product.Repo.CategoryRep;
import java.util.*;

public class CategoryService {

	CategoryRep cr = new CategoryRep();
	public boolean addCategory(CategoryModel cm) throws SQLException
	{
		return cr.addCategory(cm);
	}
	
	public int findCategory(String category) throws SQLException
	{
		return cr.findCategory(category);
	}
	
	public List<CategoryModel>showCategory() throws SQLException
	{
		return cr.showCategory();
	}
}
