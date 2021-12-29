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
public class CreateOrganizationWithIndusteryAndType extends BaseClass {
	
	@Test(groups = "regressionSuite")
	
	public void createOrgWithIndustryAndTypeTest() throws Throwable {
				
			     // get random data
				int randomdata = jlib.getRandomNumber();

				// read test data from xcel file
				String orgname = elib.getDataFromExcel("sheet1", 4, 2) + randomdata;
				String industryname = elib.getDataFromExcel("sheet1", 4, 4);
				String typename = elib.getDataFromExcel("sheet1", 4, 5);
				

				// step:2 navigate to org module
				 HomePage hp = new HomePage(driver);
				 hp.clickOnOrglink();
					
				// step:3 click on create org button
				 OrganizationPage op = new OrganizationPage(driver);
			     op.clickOnCreateOrgbutton();
				 
				// step:4 enter all details and create a org
			     CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			     cnop.createOrgWtihIndustryAndType(orgname, industryname, typename);
				
				// step:5 verification
			    OrganizationInfoPage oip = new OrganizationInfoPage(driver); 
				String actual_org = oip.getOrgInfo();
				String actual_ind = oip.getIndustryInfo();
				String actual_type = oip.getTypeInfo();
				
				
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(actual_org.contains(orgname));
				sa.assertEquals(actual_ind,industryname);
				sa.assertEquals(actual_type,typename);
				sa.assertAll();
				
				
		
	}

}
