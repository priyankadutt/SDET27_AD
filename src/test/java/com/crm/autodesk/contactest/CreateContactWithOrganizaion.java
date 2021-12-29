package com.crm.autodesk.contactest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.objectRepository.ContactInfoPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.CreateNewContactPage;
import com.crm.autodesk.objectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationPage;

public class CreateContactWithOrganizaion extends BaseClass {
	
	@Test(groups = "regressionSuite")

	public void CreateContactWithOrgTest() throws Throwable { 
	     
         //get random data
	     int randomdata = jlib.getRandomNumber();
	     
	     
         //read test data from xcel file
	     String orgname = elib.getDataFromExcel("sheet1", 3, 2) + randomdata;
	     String lastname = elib.getDataFromExcel("sheet1", 3, 3) + randomdata;
	     
	     //step:2 navigate to org module
	     HomePage hp = new HomePage(driver);
	     hp.clickOnOrglink();;
	     
	     //step:3 click on create org button
	     OrganizationPage op = new OrganizationPage(driver);
	     op.clickOnCreateOrgbutton();
	     
	     //step:4 enter all details and create a org
	     CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	     cnop.createOrganization(orgname);
	     
	     //wait for element to be active
	     wlib.waitForElementToBeClickable(driver, driver.findElement(By.className("dvHeaderText")));
	     
	     //step:6 navigate to contacts module
	     hp.clickOnConLink();
	     //driver.findElement(By.linkText("Contacts")).click();
	     
	     //step:7 click on create contact button
	     ContactsPage cp = new ContactsPage(driver);
	     cp.createNewContact();
	     
	     //step:8 provide all the details and create a contact
	     CreateNewContactPage cncp = new CreateNewContactPage(driver);
	     cncp.createContact(driver, lastname, orgname);
	     
	     //step:9 verify the contact name from header msg
	     ContactInfoPage cip = new ContactInfoPage(driver);
	     String actual_cont = cip.getConInfo();
	     Assert.assertTrue(actual_cont.contains(lastname));
	     
	}

}
