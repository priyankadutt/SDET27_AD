package com.crm.autodesk.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LogInPage;

public class BaseClass {

      public DataBaseUtility dlib = new DataBaseUtility();
      public FileUtility flib = new FileUtility();
      public WebDriverUtility wlib = new WebDriverUtility();
      public JavaUtility jlib = new JavaUtility();
      public ExcelUtility elib = new ExcelUtility();
      public WebDriver driver;
      public static WebDriver sdriver;
      
      
      @BeforeSuite(groups = {"smokeSuite","regressionSuite"})
      public void dbConnection()
      {
    	  dlib.connectToDB();
    	  System.out.println("------database connection successful");
      }
      
      
      @BeforeClass(groups = {"smokeSuite","regressionSuite"})
      public void lunchBrowser() throws Throwable
      {
    	  String BROWSER = flib.fileUtility("browser");
    	  String URL = flib.fileUtility("url");
    	  if (BROWSER.equals("ie")) {
  			driver = new InternetExplorerDriver();
  		} else if (BROWSER.equals("firefox")) {
  			driver = new FirefoxDriver();
  		} else {
  			driver = new ChromeDriver();
  		}
    	 
    	 sdriver=driver;
    	 wlib.windowMaximize(driver);
 	     wlib.waitForPageToLoad(driver);
 	     driver.get(URL);
 	     System.out.println("browser launched");
    	  
      }
      
      
      @BeforeMethod(groups = {"smokeSuite","regressionSuite"})
       public void logInToApp() throws Throwable
    	{
    	 String USERNAME = flib.fileUtility("username");
 	     String PASSWORD = flib.fileUtility("password");  
 	     LogInPage lp = new LogInPage(driver);
		 lp.login(USERNAME, PASSWORD);
		 System.out.println("login to app");
    	 }
      
      @AfterMethod(groups = {"smokeSuite","regressionSuite"})
      public void logOutOfApp()
      {
    	  HomePage hp = new HomePage(driver);
    	  hp.logout(driver);
    	  System.out.println("logout successfully");
      }
      
      
      @AfterClass(groups = {"smokeSuite","regressionSuite"})
      public void closeBrowser()
      {
    	  driver.quit();
    	  System.out.println("browser closed");
      }
      
      
      @AfterSuite(groups = {"smokeSuite","regressionSuite"})
      public void closeDBconnection()
      {
    	dlib.closeDB();
    	System.out.println("close the connection");
      }
      
	
}
