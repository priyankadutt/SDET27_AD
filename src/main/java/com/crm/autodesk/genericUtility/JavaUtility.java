package com.crm.autodesk.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Priyanka
 * 
 */
public class JavaUtility {

	/**
	 * 
	 * it is use to  generate random number 
	 * @return int data
	 */
	public int getRandomNumber() {
		
		
		Random random = new Random();
		int intNum = random.nextInt(1000);
		return intNum;
	}
	
	/**
	 * 
	 * it is use to get system date and time in IST format
	 * @return String
	 */
	public String getSystemDateAndTime()
	{
	Date date = new Date();
	return date.toString();
		
	}
	
	/**
	 * 
	 * it is use to get system date in YYYY-MM-DD format
	 * @return String
	 */
	public String getSystemDateInFormat()
	{
		Date date = new Date();
		String datetime = date.toString();
		String yyyy = datetime.split(" ")[5];
		String dd = datetime.split(" ")[2];
	    int mm = date.getMonth();
	    String finalformate = yyyy + "-" + mm + "-" + dd;
		return finalformate;
	    
		
	}

}
