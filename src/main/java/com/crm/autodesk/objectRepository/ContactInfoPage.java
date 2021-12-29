package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//step:1 create a  separate class for webpage
public class ContactInfoPage {
	
	//step:2 identify all the webelements and declare all as private
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement conHeaderText;

	
	//step:3  initialize the elements using constructor
	
    public ContactInfoPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

    //step:4  utilization : providing getter methods
    
	public WebElement getConHeaderText() {
		return conHeaderText;
	}
	
	//business library for verification
			public String getConInfo()
			{
				return(conHeaderText.getText());
			}
}
