package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

//step:1 create separate class for webpage
public class HomePage extends WebDriverUtility {
	
	//step:1 identify all the elements and make them as private
	
	@FindBy(linkText="Organizations")
	private WebElement organizationslink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement loginLookUp;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//step:3  initialize the elements using constructor
	
	public HomePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
    
	//step:4  utilization : providing getter methods
	
	public WebElement getOrganizationslink() {
		return organizationslink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getLoginLookUp() {
		return loginLookUp;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
		
	
	//business library for click on organizations module
	public void clickOnOrglink()
	{
		organizationslink.click();
	}
	
	//business library for click on contacts module
	public void clickOnConLink()
	{
		contactslink.click();
	}
	
	//business library for logout 
	public void logout(WebDriver driver) 
	{
		mouseOverOnElement(driver,loginLookUp);
		signOutLink.click();
	}
	
    
}
