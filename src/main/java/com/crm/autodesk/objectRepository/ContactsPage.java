package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//step:1 create a  separate class for webpage
public class ContactsPage {

	//step:2 identify all the webelements and declare all as private
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContLookupImg;
	
	//step:3  initialize the elements using constructor
	
    public ContactsPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

    //step:4  utilization : providing getter methods
    
	public WebElement getCreateContLookupImg() {
		return createContLookupImg;
	}
    
    //business library for creating contact
	public void createNewContact()
	{
		createContLookupImg.click();
	}
	
	
	
}
