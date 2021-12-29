package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//step:1 create a  separate class for webpage 
public class LogInPage{

	//step:2 identify all the webelements and declare all as private
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passWordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	
	//step:3  initialize the elements using constructor
	
	public LogInPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

	
	//step:4  utilization : providing getter methods
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getPassWordEdt() {
		return passWordEdt;
	}


	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
	//business library
	public void login(String username, String password)
	{
		 userNameEdt.sendKeys(username);
		 passWordEdt.sendKeys(password);
		 submitButton.click();
	}
	
	
	
}
