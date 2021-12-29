package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//step:1 create a  separate class for webpage 
public class OrganizationInfoPage {

	    //step:2 identify all the webelements and declare all as private
	
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement orgHeaderText;
		
		@FindBy(id="dtlview_Industry")
		private WebElement industryTextField;
		
		@FindBy(id="dtlview_Type")
		private WebElement typeTextField;
		
		//step:3  initialize the elements using constructor
		
	    public OrganizationInfoPage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);	
		}

	    //step:4  utilization : providing getter methods
	    
		public WebElement getOrgHeaderText() {
			return orgHeaderText;
		}
		
	    
		public WebElement getIndustryTextField() {
			return industryTextField;
		}

		public WebElement getTypeTextField() {
			return typeTextField;
		}

		//business library for verification
		public String getOrgInfo()
		{
			return(orgHeaderText.getText());
		}
		
		//business library for 
		public String getIndustryInfo()
		{
			return(industryTextField.getText());
		}
		
		//business library for 
		public String getTypeInfo()
		{
		   return(typeTextField.getText());
		}
	    

}
