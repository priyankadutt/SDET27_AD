package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

//step:1 create a  separate class for webpage 
public class CreateNewOrganizationPage extends WebDriverUtility {

	//step:2 identify all the webelements and declare all as private
	
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])")
	private WebElement saveButton;
	
	@FindBy(name="rating")
	private WebElement ratingDropDown;
	
	//step:3  initialize the elements using constructor
	
    public CreateNewOrganizationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

    //step:4  utilization : providing getter methods
    
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public WebElement getRatingDropDown() {
		return ratingDropDown;
	}

	//business library for create organization with organization name only
	public void createOrganization(String orgname)
	{
		organizationNameEdt.sendKeys(orgname);
		saveButton.click();
	}
	
	//business library for create organization with industry and type
	public void createOrgWtihIndustryAndType(String orgname, String industry, String type)
	{
		organizationNameEdt.sendKeys(orgname);
		select(industryDropDown, industry);
		select(typeDropDown, type);
		saveButton.click();
		
	}
	
	//business library for create organization with organization name and rating
		public void createOrganization(String orgname, String rating)
		{
			organizationNameEdt.sendKeys(orgname);
			select(ratingDropDown,rating); 
			saveButton.click();
		}
	
	

}
