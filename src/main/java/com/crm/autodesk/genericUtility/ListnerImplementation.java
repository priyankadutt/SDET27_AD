package com.crm.autodesk.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		//capture the method name
		String methodName = result.getMethod().getMethodName();
		
		//capture the current data
		String currentDate = new JavaUtility().getSystemDateInFormat();
		
		//concatenate for screenshot name
		String schreenshotName = methodName+"_"+currentDate;
		try
		{
			new WebDriverUtility().takeScreenshot(BaseClass.sdriver, schreenshotName);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	


}
