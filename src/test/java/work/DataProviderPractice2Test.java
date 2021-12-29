package work;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2Test {

	@Test(dataProvider="getData")
	public void readDataProviderTest(String brand, int gb, int price)
	{
		System.out.println("Brand==>"+brand+"Gb==>"+gb+"Price==>"+price);
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[5][3];
		
		objArr[0][0]="hp";
		objArr[0][1]=32;
		objArr[0][2]=40000;
		
		objArr[1][0]="dell";
		objArr[1][1]=64;
		objArr[1][2]=50000;
		
		objArr[2][0]="apple";
		objArr[2][1]=64;
		objArr[2][2]=86000;
		
		objArr[3][0]="hcl";
		objArr[3][1]=32;
		objArr[3][2]=35000;
		
		objArr[4][0]="lenevo";
		objArr[4][1]=32;
		objArr[4][2]=42000;
		
		return objArr;
		
	}
}
