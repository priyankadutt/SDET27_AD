package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author priyanka
 *
 */
public class FileUtility {
	
	/**
	 * 
	 * it is use to read data from property file based on key which you passed as an argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String fileUtility(String key) throws Throwable
	{
	FileInputStream fis = new FileInputStream(IpathCostant.filePath);
	Properties pobj = new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
	}
}
