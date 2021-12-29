package work;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	
	@Test(dataProvider="getData")
	public void readDataFromDataProviderTest(String name, int qty)
	{
		System.out.println("mobile name==>"+name+"\t"+"mobile quantity==>"+qty);
	}
	
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0] = "samsung";
		objArr[0][1] = 25;
		
		objArr[1][0] = "nokia";
		objArr[1][1] = 30;
		
		objArr[2][0] = "vivo";
		objArr[2][1] = 35;
		
		return objArr;
	}
	

}
