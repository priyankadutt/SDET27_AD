package com.crm.autodesk.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.FileUtility;
import com.crm.autodesk.genericUtility.JavaUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;
import com.crm.autodesk.objectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LogInPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

public class SearchOrgByRating {

	public static void main(String[] args) throws Throwable {
		
		//create object of generic libraries
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
				
				
		 // read common data from properties file
		 String URL = flib.fileUtility("url");
	     String USERNAME = flib.fileUtility("username");
	     String PASSWORD = flib.fileUtility("password");
	     String BROWSER = flib.fileUtility("browser");

		// get random data
		int randomdata = jlib.getRandomNumber();

		// read test data from xcel file
		
		String orgname = elib.getDataFromExcel("sheet1", 6, 2) + randomdata;
		String rating = elib.getDataFromExcel("sheet1", 6, 7);

		// driver launching condition
		WebDriver driver;
		if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.windowMaximize(driver);
	    wlib.waitForPageToLoad(driver);
		driver.get(URL);
		// step:1 login step
		LogInPage lp = new LogInPage(driver);
		lp.login(USERNAME, PASSWORD);

		// step:2 navigate to org module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrglink();
		

		// step:3 click on create org button
		OrganizationPage op = new OrganizationPage(driver);
	    op.clickOnCreateOrgbutton();

		// step:4 enter organization name and rating and create a organization
	    CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	    cnop.createOrganization(orgname, rating);
		//driver.findElement(By.name("accountname")).sendKeys(orgname);
		//WebElement drop = driver.findElement(By.name("rating"));
		//Select sel = new Select(drop);
		//sel.selectByValue("Active");
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//wait for element activation
		wlib.waitForElementToBeClickable(driver, driver.findElement(By.className("dvHeaderText")));
		
		
		// step:5 navigate to org module
		hp.clickOnOrglink();
		//driver.findElement(By.linkText("Organizations")).click();
		
		//step:6 search org by rating
		driver.findElement(By.linkText("Go to Advanced Search")).click();
		
		wlib.select(driver.findElement(By.id("fcol0")), "Rating");
		
		wlib.select(driver.findElement(By.id("fop0")), "equals");
		
		driver.findElement(By.id("fval0")).sendKeys("Active");
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
		
		//step:7 verify
		
		
		
		//step:8 logout
		 wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	     driver.findElement(By.linkText("Sign Out")).click();
	     driver.quit();

	}

}
