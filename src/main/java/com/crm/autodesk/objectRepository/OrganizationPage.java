package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//step:1 create a  separate class for webpage 
public class OrganizationPage {

	    //step:2 identify all the webelements and declare all as private
	
		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement createOrgLookUp;
		
		@FindBy(name="search_text")
		private WebElement searchForBar;
		
		@FindBy(name="submit")
		private WebElement searchNowButton;
		
		@FindBy(linkText="Go to Advanced Search")
		private WebElement AdvSearchLink;
		
		@FindBy(id="fcol0")
		private WebElement AdvSearchBar;
		
		//step:3  initialize the elements using constructor
		
		public OrganizationPage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);	
		}
		
		//step:4  utilization : providing getter methods
		public WebElement getCreateOrgLookUp() {
			return createOrgLookUp;
		}

		public WebElement getSearchForBar() {
			return searchForBar;
		}

		public WebElement getSearchNowButton() {
			return searchNowButton;
		}
		
		public WebElement getAdvSearchLink() {
			return AdvSearchLink;
		}

		//business library for click on create org button
		public void clickOnCreateOrgbutton()
		{
			createOrgLookUp.click();
		}
		
}
