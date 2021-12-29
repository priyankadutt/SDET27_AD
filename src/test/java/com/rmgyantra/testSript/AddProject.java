package com.rmgyantra.testSript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AddProject {

	public static void main(String[] args) throws SQLException {


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8084");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("rainbow");
		driver.findElement(By.name("createdBy")).sendKeys("priyanka");
		WebElement dd = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select s = new Select(dd);
		s.selectByVisibleText("Completed");
		driver.findElement(By.xpath("//input[@type='submit']")).click();



		driver.quit();



		Connection connection=null;
		try
		{
			String expectedProjectName = "rainbow";
			//register database
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);
			//connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			//issue statement
			Statement statement = connection.createStatement();
			//execute
			ResultSet result = statement.executeQuery("select * from project");
			while(result.next())
			{
				if(result.getString(4).equals(expectedProjectName))
				{
					System.out.println("project name present");
				}
			}
		}
		catch(Exception e)
		{

		}
		finally
		{
			//close
			connection.close();		
		}



	}

}
