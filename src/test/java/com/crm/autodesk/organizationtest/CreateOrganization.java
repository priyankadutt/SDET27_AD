package com.crm.autodesk.organizationtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.objectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.OrganizationInfoPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

@Listeners(com.crm.autodesk.genericUtility.ListnerImplementation.class)
public class CreateOrganization extends BaseClass{
	
	
	@Test(groups = "smokeSuite")

	public void createOrgTest() throws Throwable{

		// get random data
		int randomdata = jlib.getRandomNumber();

		// read test data from xcel file
		
		String orgname = elib.getDataFromExcel("sheet1", 1, 2) + randomdata;

		// step:2 navigate to org module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrglink();
		
         
		// step:3 click on create org button
        OrganizationPage op = new OrganizationPage(driver);
        op.clickOnCreateOrgbutton();
		
		// step:4 enter all details and create a org
        CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
        cnop.createOrganization(orgname);
        
		
        // step:5 verify orgname from header msg
        OrganizationInfoPage oinfo = new OrganizationInfoPage(driver);
        String actual_name = oinfo.getOrgInfo();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(actual_name.contains(orgname));
        sa.assertAll();
		
        
	}
		
		@Test
		public void createOrgDemoTest()
		{
			System.out.println("create org demo test is working");
		}
	

}
