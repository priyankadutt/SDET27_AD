package work;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.RetryAnalyserImplementation;

public class Retry {
	
	@Test(retryAnalyzer=RetryAnalyserImplementation.class)
	public void retryTest()
	{
		System.out.println("Retry test script");
		Assert.fail();
	}

}
