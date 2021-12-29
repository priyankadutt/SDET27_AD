package com.crm.autodesk.organizationtest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericUtility.ExcelUtility;
import com.crm.autodesk.genericUtility.WebDriverUtility;

public class SearchOrgByWebsite {

	public static void main(String[] args) throws Throwable {
		
		        //create object of generic libraries
				WebDriverUtility wlib = new WebDriverUtility();
				ExcelUtility elib = new ExcelUtility();
				
				
		        // read common data from properties file
				FileInputStream fis = new FileInputStream("./data/data.properties");
				Properties pp = new Properties();
				pp.load(fis);
				String URL = pp.getProperty("url");
				String USERNAME = pp.getProperty("username");
				String PASSWORD = pp.getProperty("password");
				String BROWSER = pp.getProperty("browser");

				// get random data
				Random r = new Random();
				int randomdata = r.nextInt(100);

				// read test data from xcel file
                String orgname = elib.getDataFromExcel("sheet1", 5, 2) + randomdata;
				String website = elib.getDataFromExcel("sheet1", 5, 6) + randomdata;

				// driver launching condition
				WebDriver driver;
				if (BROWSER.equals("ie")) {
					driver = new InternetExplorerDriver();
				} else if (BROWSER.equals("firefox")) {
					driver = new FirefoxDriver();
				} else {
					driver = new ChromeDriver();
				}

				// step:1 login step
				 wlib.windowMaximize(driver);
			     wlib.waitForPageToLoad(driver);
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();

				// step:2 navigate to org module
				driver.findElement(By.linkText("Organizations")).click();

				// step:3 click on create org button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

				// step:4 enter all details and create a org
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				driver.findElement(By.name("website")).sendKeys(website);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//wait for element activation
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
				
				
				// step:5 navigate to org module
				driver.findElement(By.linkText("Organizations")).click();
				
				//step:6 search org by website
				driver.findElement(By.name("search_text")).sendKeys(website);
				WebElement drop = driver.findElement(By.id("bas_searchfield"));
				Select sel = new Select(drop);
				sel.selectByVisibleText("Website");
				driver.findElement(By.name("submit")).click();
				
				// step:7 verification
				 String act_website = driver.findElement(By.linkText(website)).getText();
				if(act_website.contains(website))
				{
					System.out.println("Organization is successfully searched by==>" + website + ":PASS");
				}
				else
					System.out.println("Organization is not successfully searched by==>"  + website + ":FAIL");
				
				
				
				 // step:8 logout
				 wlib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
			     driver.findElement(By.linkText("Sign Out")).click();
			     driver.quit();
			
				

	}

}
