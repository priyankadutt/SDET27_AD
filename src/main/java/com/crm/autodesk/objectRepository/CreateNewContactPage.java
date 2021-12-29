package com.crm.autodesk.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

//step:1 create a  separate class for webpage 
public class CreateNewContactPage extends WebDriverUtility {
	
	//step:2 identify all the webelements and declare all as private
	
	@FindBy(name="lastname")
	private WebElement lastnmeEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgNameSelectLookupImg;
	
	@FindBy(name="search_text")
	private WebElement searchOrgBar;
	
	@FindBy(name="search")
	private WebElement searchOrgButton;

	
	//step:3  initialize the elements using constructor
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step:4  utilization : providing getter methods
	
	public WebElement getLastnmeEdt() {
		return lastnmeEdt;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public WebElement getSearchOrgBar() {
		return searchOrgBar;
	}

	public WebElement getSearchOrgButton() {
		return searchOrgButton;
	}

	public WebElement getOrgNameSelectLookupImg() {
		return orgNameSelectLookupImg;
	}

	//business library for create contact
	public void createContact(String lastname)
	{
		lastnmeEdt.sendKeys(lastname);
		saveButton.click();
	}
	
	//business library for create contact with organization name
	public void createContact(WebDriver driver, String lastname, String orgname)
	{
		lastnmeEdt.sendKeys(lastname);
		orgNameSelectLookupImg.click();
		swithToWindow(driver, "Accounts");
		searchOrgBar.sendKeys(orgname);
		searchOrgButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		swithToWindow(driver, "contacts");
		saveButton.click();
		
	}
	

}
