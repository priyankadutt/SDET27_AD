package com.crm.autodesk.contactest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.objectRepository.ContactInfoPage;
import com.crm.autodesk.objectRepository.ContactsPage;
import com.crm.autodesk.objectRepository.CreateNewContactPage;
import com.crm.autodesk.objectRepository.HomePage;

public class CreateContact extends BaseClass{

	@Test(groups = "smokeSuite")
	public void createContactTest() throws Throwable {
		
	     
         //get random data
	     int randomdata = jlib.getRandomNumber();
	     
	     
         //read test data from xcel file
	     String lastname = elib.getDataFromExcel("sheet1", 2, 3) + randomdata;
	     
         //step:2 navigate to contacts module
	     HomePage hp =new HomePage(driver);
	     hp.clickOnConLink();
	     
	     //step:3 click on create contact button
	     ContactsPage cp = new ContactsPage(driver);
	     cp.createNewContact();
	     
	     //step:4 provide all the details and create a contacts
	     CreateNewContactPage cncp = new CreateNewContactPage(driver);
	     cncp.createContact(lastname);
	     
	     //step:5 verify contact name from header msg
	     ContactInfoPage cip = new ContactInfoPage(driver);
	     String actual_name = cip.getConInfo();
	     Assert.assertTrue(actual_name.contains(lastname));
	     System.out.println("contact created sussesfully");
	     
	     
	}

}
