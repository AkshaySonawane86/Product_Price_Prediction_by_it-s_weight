package Product.Services;
import java.util.*;
import Product.Repo.PredictionRep;

import java.sql.*;
public class PredictionService {

	PredictionRep pr = new PredictionRep();
	List<Integer> DOfX;
	List<Integer> DOfY;
	public int showPrediction(String name,int weight) throws SQLException
	{
		int x=pr.findX(name);
		//System.out.println(x);
		int y=pr.findY(name);
		//System.out.println(y);
		List<Integer> weightNo=pr.Weight(name);
		List<Integer> PriceNo = pr.Price(name);
		//System.out.println("Weight is "+weightNo);
		//System.out.println("Price is "+PriceNo);
		DOfX = new ArrayList<Integer>();
		DOfY= new ArrayList<Integer>();
		int sumProductDeviation = 0;
		for(Integer m:weightNo)
		{
			int no=m-x;
			
			DOfX.add(no);
		}
		for(Integer m:PriceNo)
		{
			int no=m-y;
			
			sumProductDeviation+=no;
			
			DOfY.add(no);
		}
		
		List<Integer> ProductDeviation = new ArrayList<Integer>();
		for(int i=0;i<DOfY.size();i++)
		{
			int valOfX=DOfX.get(i);
			int valOfY=DOfY.get(i);
			int value=valOfX*valOfY;
			sumProductDeviation+=value;
			
			ProductDeviation.add(value);
		}
		
		List<Integer> SquareDOfX = new ArrayList<Integer>();
		int sum=0;
		for(int i=0;i<DOfX.size();i++)
		{
			int valOfX=DOfX.get(i);
			int value=valOfX*valOfX;
			sum+=value;
			
			SquareDOfX.add(value);
		}
		int m=sumProductDeviation/sum;
		int b=y-(m*x);
		int yy=m*weight+b;
//		System.out.println("Deviation of x "+DOfX);
//		System.out.println("Deviation of y "+DOfY);
//		System.out.println("Product of Deviation "+ProductDeviation);
//		System.out.println("Sum of product of deviation "+sumProductDeviation);
//		System.out.println("Square of deviation of x "+SquareDOfX);
//		System.out.println("Sum of square of deviation of x "+sum);
//		System.out.println("m is "+m);
//		System.out.println("b is "+b);
//		System.out.println("y is "+yy);
		

		
		
		return yy;
	}
}
